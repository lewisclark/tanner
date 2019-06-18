package org.doubt.tanner;

import org.osbot.rs07.api.map.Area;

public enum Location {
	AL_KHARID;

	private Area bankArea = new Area(0, 0, 0, 0);
	private Area tanArea = new Area(0, 0, 0, 0);
	private String tannerName = "n/a";
	private String areaName = "n/a";

	static {
		AL_KHARID.bankArea = new Area(3269, 3170, 3271, 3164);
		AL_KHARID.tanArea = new Area(3277, 3189, 3272, 3194);
		AL_KHARID.tannerName = "Ellis";
		AL_KHARID.areaName = "Al Kharid";
	}

	@Override
	public String toString() {
		return getAreaName();
	}

	public Area getBankArea() {
		return bankArea;
	}

	public Area getTanArea() {
		return tanArea;
	}

	public String getTannerName() {
		return tannerName;
	}

	public String getAreaName() {
		return areaName;
	}
}