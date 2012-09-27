package org.smartflow;

public class ProcessTransition {
	
	private String id;
	private String entryActivityId;
	private String exitActivityId;
	
	public ProcessTransition (String id, String from, String to) {
		
		this.id = id;
		this.entryActivityId = from;
		this.exitActivityId = to;
	}
	
}
