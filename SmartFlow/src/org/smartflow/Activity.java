package org.smartflow;

public class Activity {
	
	private String name = "";
	private String id = "";
	private String description = "";
	private String imagePath = "";
	public boolean isStartActivity = false;
	public boolean isEndActivity = false;
	
	public Activity () {
		
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return name;
	}
	
	public void setId(String id) {
		if(id != null) this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getDescription() {
		return this.description;
	}


	

}
