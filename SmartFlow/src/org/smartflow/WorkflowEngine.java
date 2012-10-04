package org.smartflow;

import java.util.HashMap;
import java.util.Timer;



public class WorkflowEngine implements MessageReceiver{

	private static final WorkflowEngine _workflowEngine = new WorkflowEngine();
	private HashMap<Activity,String> activities = new HashMap<Activity,String>();
	
	private WorkflowEngine() {
		MessageHandler.getInstance().registerReceiver(this);
		MessageHandler.getInstance().registerReceiver(this);
	}
	
	public static WorkflowEngine getInstance() {
		return _workflowEngine;
	}
	
	public void storeActivity(Activity _activity) {
		activities.put(_activity, _activity.getId());
	}
	
	public void startProcess() {
		//Timer timer = new Timer();
		//timer.scheduleAtFixedRate(new ScheduledTask(Settings.ACTIVITY_DURATION), 0, Settings.ACTIVITY_DURATION);
		Scheduler scheduler = new Scheduler(300);
		scheduler.run();
	}
	
	@Override
	public void messageReceived(String _msg) {
		System.out.print("Event: Message Received");
		System.out.print("Message: " + _msg);
		MessageHandler.getInstance().sendMessage("Onnistuuko näin?");
	}
	
	
	
	
}
