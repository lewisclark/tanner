package org.doubt.tanner;

import java.awt.Graphics2D;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.swing.SwingUtilities;

import org.doubt.tanner.actions.*;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

@ScriptManifest (
	author = "doubt",
	info = Global.SCRIPT_INFO,
	logo = "https://i.imgur.com/em0j2xO.jpg",
	name = Global.SCRIPT_NAME,
	version = Global.SCRIPT_VERSION
)

public final class Main extends Script {
	private ActionController act_con;
	private Gui gui;
	private PaintManager paintmgr;

	@Override
	public int onLoop() throws InterruptedException {
		if (act_con != null)
			return act_con.onLoop();
		else
			return 1000;
	}
	
	@Override
	public void onStart() throws InterruptedException {
		Global.config = new Config();

		HashMap<String, String> params = getParams();

		if (params == null || !isValidParams(params)) {
			log("CLI script parameters not given or are invalid - opening GUI");

			try {
				SwingUtilities.invokeAndWait(() -> {
					gui = new Gui();
					gui.open();
				});
			} catch (InterruptedException | InvocationTargetException e) {
				Util.abort(getBot(), "Failed to invoke gui creation");
				e.printStackTrace();
				return;
			}

			if (!gui.isReady())
				Util.abort(getBot(), "Gui aborted");

			Global.config.setHide(gui.getSelectedHide());
			Global.config.setLocation(gui.getSelectedLocation());
		} else {
			log("Using CLI parameters");

			Global.config.setHide(Hide.fromCliName(params.get("hide")));
			Global.config.setLocation(Location.fromCliName(params.get("location")));
		}

		act_con = new ActionController();
		act_con.addAction(new WalkToBank(getBot()));
		act_con.addAction(new WalkToTanner(getBot()));
		act_con.addAction(new Bank(getBot()));
		act_con.addAction(new Tan(getBot()));

		paintmgr = new PaintManager(getBot());
	}

	@Override
	public void onPaint(Graphics2D g) {
		if (paintmgr != null) {
			paintmgr.paint(g);
		}
	}

	private HashMap<String, String> getParams() {
		HashMap<String, String> params = new HashMap<>();
		String strParams = getParameters();

		if (strParams == null || strParams.isEmpty())
			return null;

		for (String kvJoined : strParams.split("\\.")) {
			String[] kv = kvJoined.split("=");

			if (kv != null && kv.length == 2) {
				params.put(kv[0].toLowerCase(), kv[1].toLowerCase());
			} else {
				return null; // Invalid param syntax
			}
		}

		return params;
	}

	private boolean isValidParams(HashMap<String, String> params) {
		if (!params.containsKey("hide")) {
			return false;
		}

		if (!params.containsKey("location")) {
			return false;
		}

		if (Hide.fromCliName(params.get("hide")) == null)
			return false;

		if (Location.fromCliName(params.get("location")) == null)
			return false;

		return true;
	}
}
