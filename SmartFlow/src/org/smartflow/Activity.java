package org.smartflow;

public class Activity {
	
	private String id;
	private String completionQuantity;
	private String name;
	private String status;
	private boolean isATransaction;
	private boolean isForCompensation;
	private int startQuantity;
	
	private SequenceFlow transition;
	
	
	public Activity () {
		
	}
}
