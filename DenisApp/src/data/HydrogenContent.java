package data;

public enum HydrogenContent {
	
	A("> 15"),
	B("10 <= 15"),
	C("5 <= 10"),
	D("3 <= 5"),
	E("<= 3");
	
	private String description;
	
	HydrogenContent(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
