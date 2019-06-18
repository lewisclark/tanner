package org.doubt.tanner;

import org.osbot.rs07.Bot;

public final class Util {
	public static void abort(Bot bot, String reason) throws InterruptedException {
		bot.getLogger().info("Aborting: " + reason);
		bot.getScriptExecutor().stop();
	}
}