package org.smartflow;

public class SequenceFlow {
	
	private String id;
	private String fromActivityId;
	private String toActivityId;
	private String condition;
	
	public SequenceFlow (String id, String fromActivity, String toActivity, String condition) {
		
		this.id = id;
		this.fromActivityId = fromActivity;
		this.toActivityId = toActivity;
		this.condition = condition;
	}
	
}
