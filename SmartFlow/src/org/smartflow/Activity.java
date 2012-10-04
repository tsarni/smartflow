package org.smartflow;

public class Activity {
	
	private String name;
	private String id;
	private String description;
	
	public Activity () {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
