package org.smartflow;



public class WorkflowEngine implements MessageReceiver{

	private static final WorkflowEngine _workflowEngine = new WorkflowEngine();
	
	private WorkflowEngine() {
		MessageHandler.getInstance().registerReceiver(this);
		MessageHandler.getInstance().registerReceiver(this);
	}
	
	public static WorkflowEngine getInstance() {
		return _workflowEngine;
	}

	@Override
	public void messageReceived() {
		System.out.print("Event: Message Received");
		MessageHandler.getInstance().sendMessage("Onnistuuko näin?");
	}
	
	
	
	
}
