package org.doubt.tanner;

public enum Hide {
	SOFT_LEATHER("Cowhide", "Leather", "Soft leather"),
	HARD_LEATHER("Cowhide", "Hard leather", "Hard leather"),
	GREEN("Green dragonhide", "Green dragon leather", "Green d'hide"),
	BLUE("Blue dragonhide", "Blue dragon leather", "Blue d'hide"),
	RED("Red dragonhide", "Red dragon leather", "Red d'hide"),
	BLACK("Black dragonhide", "Black dragon leather", "Black d'hide");

	private String rawName = "n/a";
	private String tannedName = "n/a";
	private String tannerName = "n/a"; // The name in the tanner gui

	Hide(String rawName, String tannedName, String tannerName) {
		this.rawName = rawName;
		this.tannedName = tannedName;
		this.tannerName = tannerName;
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
}