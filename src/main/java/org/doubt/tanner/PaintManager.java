package org.doubt.tanner;

import java.awt.Color;
import java.awt.Graphics2D;
import org.osbot.rs07.Bot;

public final class PaintManager {
	private Bot bot;
	private long timeStarted = 0;

	public PaintManager(Bot bot) {
		this.bot = bot;

		timeStarted = bot.getClient().gameClockMs();
	}

	public void paint(Graphics2D g) {
		g.setColor(new Color(255, 255, 255));

		g.drawString("Prime Tanner", 5, 305);
		g.drawString(getTimeRunning(), 5, 320);
		g.drawString("Tanned: " + Global.hidesTanned, 5, 335);
	}

	private String getTimeRunning() {
		return Util.formatTime(bot.getClient().gameClockMs() - timeStarted);
	}
}