package org.doubt.tanner;

public enum Hide {
	SOFT_LEATHER("Cowhide", "Leather", "Soft leather", "soft"),
	HARD_LEATHER("Cowhide", "Hard leather", "Hard leather", "hard"),
	GREEN("Green dragonhide", "Green dragon leather", "Green d'hide", "green"),
	BLUE("Blue dragonhide", "Blue dragon leather", "Blue d'hide", "blue"),
	RED("Red dragonhide", "Red dragon leather", "Red d'hide", "red"),
	BLACK("Black dragonhide", "Black dragon leather", "Black d'hide", "black");

	private String rawName = "n/a";
	private String tannedName = "n/a";
	private String tannerName = "n/a"; // The name in the tanner gui
	private String cliName = "n/a";

	Hide(String rawName, String tannedName, String tannerName, String cliName) {
		this.rawName = rawName;
		this.tannedName = tannedName;
		this.tannerName = tannerName;
		this.cliName = cliName;
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

	public String getCliName() {
		return cliName;
	}

	public static Hide fromCliName(String cliName) {
		for (Hide hide : Hide.values()) {
			if (hide.cliName.equalsIgnoreCase(cliName)) {
				return hide;
			}
		}

		return null;
	}
}