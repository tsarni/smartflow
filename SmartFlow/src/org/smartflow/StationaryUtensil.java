package org.smartflow;

import java.util.ArrayList;



public class StationaryUtensil {
	
	private int[] dimensions = new int[3];
	private String name; 
	private  ArrayList<MovableUtensil> containedUtensils = new ArrayList<MovableUtensil>();
	
	
	public StationaryUtensil() {
		
	}
	
	public void addUtensil(MovableUtensil _utensil) {
		this.containedUtensils.add(_utensil);
	}
	
	public ArrayList<MovableUtensil> getUtensils() {
		return this.containedUtensils;
	}
	
	public int[] getDimensions() {
		return dimensions;
	}

	public void setDimensions(int[] dimensions) {
		this.dimensions = dimensions;
	}

}
