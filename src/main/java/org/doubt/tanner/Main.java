package org.doubt.tanner;

import java.awt.Graphics2D;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import org.doubt.tanner.actions.*;
import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

@ScriptManifest (
	author = "doubt",
	info = "Tans all types of hides.",
	logo = "",
	name = Global.SCRIPT_NAME,
	version = 1.0
)

public final class Main extends Script {
	private ActionController act_con;
	private Gui gui;
	private PaintManager paintmgr;

	@Override
	public int onLoop() throws InterruptedException {
		return act_con.onLoop();
	}
	
	@Override
	public void onStart() throws InterruptedException {
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

		act_con = new ActionController();
		Global.config = new Config();
		Global.config.setHide(gui.getSelectedHide());
		Global.config.setLocation(gui.getSelectedLocation());

		if (bot.getMethods().getSkills().getStatic(Skill.CRAFTING) < Global.config.getHide().getMinCraftingLvl()) {
			Util.abort(getBot(), "Crafting level too low");
		}

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
}
