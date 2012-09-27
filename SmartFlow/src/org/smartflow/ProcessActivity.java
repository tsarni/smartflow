package org.smartflow;

public class ProcessActivity {
	
	private String id;
	private String completionQuantity;
	private String name;
	private String status;
	private boolean isATransaction;
	private boolean isForCompensation;
	private int startQuantity;
	
	private StartEvent event;
	private ProcessTransition transition;
	
	
	public ProcessActivity () {
		
	}
}
