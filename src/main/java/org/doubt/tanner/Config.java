package org.doubt.tanner;

import org.osbot.rs07.script.MethodProvider;

public final class Config {
	private Hide hide;
	private Location location;

	public Hide getHide() {
		return hide;
	}

	public void setHide(Hide hide) {
		this.hide = hide;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int sleepDuration() {
		return MethodProvider.random(500, 800);
	}
}