package org.smartflow.server;

public class WorkflowEngine {
	
	private static WorkflowEngine _smartFlowEngine = new WorkflowEngine();
	
	private WorkflowEngine() {
	}
	
	public static WorkflowEngine getInstance() {
		return _smartFlowEngine;
	}
}
