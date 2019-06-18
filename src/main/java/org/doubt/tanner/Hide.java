package org.doubt.tanner;

public enum Hide {
	SOFT_LEATHER,
	HARD_LEATHER,
	GREEN,
	BLUE,
	RED,
	BLACK;

	private String rawName = "n/a";
	private String tannedName = "n/a";
	private String tannerName = "n/a"; // The name in the tanner gui
	private int minCraftingLvl = 99;

	static {
		SOFT_LEATHER.rawName = "Cowhide";
		SOFT_LEATHER.tannedName = "Leather";
		SOFT_LEATHER.tannerName = "Soft leather";
		SOFT_LEATHER.minCraftingLvl = 1;

		HARD_LEATHER.rawName = "Cowhide";
		HARD_LEATHER.tannedName = "Hard leather";
		HARD_LEATHER.tannerName = "Hard leather";
		HARD_LEATHER.minCraftingLvl = 28;

		GREEN.rawName = "Green dragonhide";
		GREEN.tannedName = "Green dragon leather";
		GREEN.tannerName = "Green d'hide";
		GREEN.minCraftingLvl = 57;

		BLUE.rawName = "Blue dragonhide";
		BLUE.tannedName = "Blue dragon leather";
		BLUE.tannerName = "Blue d'hide";
		BLUE.minCraftingLvl = 66;

		RED.rawName = "Red dragonhide";
		RED.tannedName = "Red dragon leather";
		RED.tannerName = "Red d'hide";
		RED.minCraftingLvl = 73;

		BLACK.rawName = "Black dragonhide";
		BLACK.tannedName = "Black dragon leather";
		BLACK.tannerName = "Black d'hide";
		BLACK.minCraftingLvl = 79;
	}
	
	@Override
	public String toString() {
		return tannedName;
	}

	public String getRawName() {
		return rawName;
	}

	public String getTannedName() {
		return tannedName;
	}

	public String getTannerNamme() {
		return tannerName;
	}

	public int getMinCraftingLvl() {
		return minCraftingLvl;
	}
}