package org.smartflow;

public class Activity {
	
	private String name = "";
	private String id = "";
	private String description = "";
	private String imagePath = "";
	private String videoComponent = "";
	private Utensil attachedUtensil;
	private int duration = 0;
	private int camera;
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
	
	public void attachUtensil(Utensil utensil) {
		this.attachedUtensil = utensil;
	}
	
	public Utensil getAttachedUtensil() {
		return this.attachedUtensil;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getCamera() {
		return camera;
	}

	public void setCamera(int camera) {
		this.camera = camera;
	}

	public String getVideoComponent() {
		return videoComponent;
	}

	public void setVideoComponent(String videoComponent) {
		this.videoComponent = videoComponent;
	}

	

}
