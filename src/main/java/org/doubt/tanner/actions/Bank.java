package org.doubt.tanner.actions;

import org.doubt.tanner.Action;
import org.doubt.tanner.Global;
import org.doubt.tanner.Sleep;
import org.doubt.tanner.Util;
import org.osbot.rs07.Bot;

public final class Bank extends Action {
	public Bank(Bot bot) {
		super(bot);
	}

	@Override
	public boolean shouldExecute() {
		return Global.config.getLocation().getBankArea().contains(bot.getMethods().myPlayer()) &&
			(!bot.getMethods().getInventory().contains(Global.config.getHide().getRawName()) ||
			!bot.getMethods().getInventory().contains("Coins"));
	}

	@Override
	public void execute() throws InterruptedException {
		if (!bot.getMethods().getBank().isOpen() && !bot.getMethods().getBank().open())
			return;

		if (!Sleep.sleepUntil(() -> bot.getMethods().getBank().isOpen(), 10000))
			return;

		if (!withdrawAll("Coins"))
			return;

		if (!bot.getMethods().getBank().depositAllExcept("Coins"))
			return;

		if (!withdrawAll(Global.config.getHide().getRawName()))
			return;
	}

	private boolean withdrawAll(String item) throws InterruptedException {
		if (!bot.getMethods().getInventory().contains(item)) {
			if (bot.getMethods().getBank().contains(item)) {
				return bot.getMethods().getBank().withdrawAll(item);
			} else {
				Util.abort(bot, "Ran out of " + item);
				return false;
			}
		} else {
			return true;
		}
	}
}