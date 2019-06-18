package org.doubt.tanner.actions;

import org.doubt.tanner.Action;
import org.doubt.tanner.Global;
import org.osbot.rs07.Bot;

public final class WalkToTanner extends Action {
	public WalkToTanner(Bot bot) {
		super(bot);
	}

	@Override
	public boolean shouldExecute() {
		return !Global.config.getLocation().getTanArea().contains(bot.getMethods().myPlayer()) &&
			bot.getMethods().getInventory().contains(Global.config.getHide().getRawName()) &&
			bot.getMethods().getInventory().contains("Coins");
	}

	@Override
	public void execute() throws InterruptedException {
		bot.getMethods().getWalking().webWalk(Global.config.getLocation().getTanArea());
	}
}