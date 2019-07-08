package org.doubt.tanner.actions;

import org.doubt.tanner.Action;
import org.doubt.tanner.Global;
import org.doubt.tanner.Sleep;
import org.osbot.rs07.Bot;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.api.ui.RS2Widget;

public final class Tan extends Action {
	public Tan(Bot bot) {
		super(bot);
	}

	@Override
	public boolean shouldExecute() {
		return Global.config.getLocation().getTanArea().contains(bot.getMethods().myPlayer())
				&& bot.getMethods().getInventory().contains("Coins")
				&& bot.getMethods().getInventory().contains(Global.config.getHide().getRawName());
	}

	@Override
	public void execute() throws InterruptedException {
		RS2Widget button = getButton();

		if (button == null) {
			NPC tanner = bot.getMethods().getNpcs().closest(Global.config.getLocation().getTannerName());

			if (tanner == null || !tanner.interact("Trade"))
				return;

			if (!Sleep.sleepUntil(() -> getButton() != null, 10000))
				return;
		} else {
			if (!button.interact("Tan All"))
				return;
		
			String tannedName = Global.config.getHide().getTannedName();

			if (!Sleep.sleepUntil(() -> bot.getMethods().getInventory().contains(tannedName), 2500))
				return;

			Global.hidesTanned += bot.getMethods().getInventory().getAmount(tannedName);
		}
	}

	private RS2Widget getButton() {
		return bot.getMethods().getWidgets().getWidgetContainingText(324, Global.config.getHide().getTannerNamme());
	}
}