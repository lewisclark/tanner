package org.doubt.tanner;

public enum Hide {
	SOFT_LEATHER("Cowhide", "Leather", "Soft leather", 1),
	HARD_LEATHER("Cowhide", "Hard leather", "Hard leather", 28),
	GREEN("Green dragonhide", "Green dragon leather", "Green d'hide", 57),
	BLUE("Blue dragonhide", "Blue dragon leather", "Blue d'hide", 66),
	RED("Red dragonhide", "Red dragon leather", "Red d'hide", 73),
	BLACK("Black dragonhide", "Black dragon leather", "Black d'hide", 79);

	private String rawName = "n/a";
	private String tannedName = "n/a";
	private String tannerName = "n/a"; // The name in the tanner gui
	private int minCraftingLvl = 99;

	Hide(String rawName, String tannedName, String tannerName, int minCraftingLvl) {
		this.rawName = rawName;
		this.tannedName = tannedName;
		this.tannerName = tannerName;
		this.minCraftingLvl = minCraftingLvl;
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