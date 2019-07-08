package org.doubt.tanner;

import java.util.concurrent.TimeUnit;

import org.osbot.rs07.Bot;

public final class Util {
	public static void abort(Bot bot, String reason) throws InterruptedException {
		bot.getLogger().info("Aborting: " + reason);
		bot.getScriptExecutor().stop();
	}

	public static String formatTime(long ms) {
		long hours = TimeUnit.MILLISECONDS.toHours(ms);
		long mins = TimeUnit.MILLISECONDS.toMinutes(ms) -
			TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(ms));
		long secs = TimeUnit.MILLISECONDS.toSeconds(ms) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms));   
		long msRem = ms % 1000;

		return String.format("%02d:%02d:%02d.%03d", hours, mins, secs, msRem);
	}
}