package org.smartflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class WorkflowEngine implements MessageReceiver{

	private static final WorkflowEngine _workflowEngine = new WorkflowEngine();
	private ArrayList<Activity> activities = new ArrayList<Activity>();
	private HashMap<String,String> transitions = new HashMap<String,String>();
	
	private String startId;
	private String currentStepId;
	private Scheduler scheduler;
	
	private boolean isStarted = false;

	
	private WorkflowEngine() {
		MessageHandler.getInstance().registerReceiver(this);
		
	}
	
	public static WorkflowEngine getInstance() {
		return _workflowEngine;
	}
	
	public void storeActivity(Activity _activity) {
		activities.add(_activity);
	}
	
	public void storeTransition(String from, String to) {
		this.transitions.put(from, to);
	}
	
	public void startProcess() {
		this.currentStepId = this.startId;
		System.out.println("Start");
		//Timer timer = new Timer();
		//timer.scheduleAtFixedRate(new ScheduledTask(Settings.ACTIVITY_DURATION), 0, Settings.ACTIVITY_DURATION);
		
		//scheduler = new Scheduler(300);
		//scheduler.run();
		
	}
	private Activity getActivity(String id) {
		
		Activity activity = null;
		
		for(int i = 0; i < this.activities.size(); i++) {
			if(activities.get(i).getId().compareTo(id) == 0) {
				activity =  activities.get(i);
			}
		}
		return activity;
	}
	

	
	public void goToNextStep() {
		
		if(!this.isStarted) {
			this.startProcess();
			this.isStarted = true;
		}
		
		if(this.getActivity(this.currentStepId).isEndActivity) {
			System.out.println("End");
			this.scheduler.isStopped = true;
		} else {
			this.currentStepId = this.transitions.get(this.currentStepId);
			if(this.getActivity(this.currentStepId).getName() != null) {
				MessageHandler.getInstance().sendMessage(this.getActivity(this.currentStepId).getName());
				System.out.println(this.getActivity(this.currentStepId).getName());
			}
			
		}
		
	}
	

	public void goToPreviousStep() {
		
		if(!this.isStarted) {
			this.startProcess();
			this.isStarted = true;
		}
		
		if(this.getActivity(this.currentStepId).isStartActivity) {
			MessageHandler.getInstance().sendMessage("Start");
		} else {
			//this.currentStepId = this.transitions.get(this.currentStepId);
			this.currentStepId = getKeyByValue(this.transitions, this.currentStepId);
			if(this.getActivity(this.currentStepId).getName() != null) {
				MessageHandler.getInstance().sendMessage(this.formatMessage());
				System.out.println(this.getActivity(this.currentStepId).getName());
			}
			
		}
		
	}
	
	public static <T, E> T getKeyByValue(Map<T, E> map, E value) { 
	    for (Entry<T, E> entry : map.entrySet()) { 
	        if (value.equals(entry.getValue())) { 
	            return entry.getKey(); 
	        } 
	    } 
	    return null; 
	} 

	
	public void setStartId(String id) {
		this.startId = id;
	}

	private String formatMessage() {
		String msg = "";
		if (this.getActivity(this.currentStepId).getName() != null) msg += this.getActivity(this.currentStepId).getName() + "/r/n" ;
		if (this.getActivity(this.currentStepId).getImagePath() != null) msg +=  "<img src=\"" + this.getActivity(this.currentStepId).getImagePath() + " \"</img>" + "/r/n";
		if (this.getActivity(this.currentStepId).getDescription() != null) msg += this.getActivity(this.currentStepId).getDescription() + "/r/n";
		
		return msg;
	}
	
	@Override
	public void messageReceived(String _msg) {
		
		if (_msg.equals("Next")) {
			this.goToNextStep();
		}
		
		if (_msg.equals("Previous")) {
			this.goToPreviousStep();
		}
		//MessageHandler.getInstance().sendMessage(_msg);
	}
	
	
	
	
}
