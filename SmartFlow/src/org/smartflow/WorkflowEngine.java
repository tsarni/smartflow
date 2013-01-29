package org.smartflow;

import java.io.FileWriter;
import java.io.IOException;
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

	private String processStep;
	private int stepNumber;
	private int currentStep;
	private long startTime;
	
	
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
		this.stepNumber = 0;
		
		
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
			this.startTime = System.currentTimeMillis();
		}	
		
		if(this.getActivity(this.currentStepId).isEndActivity) {
			//nothing
		} else {
			this.currentStepId = this.transitions.get(this.currentStepId);
			this.stepNumber++;
			
			if (this.getActivity(this.currentStepId).isEndActivity) {
				MessageHandler.getInstance().sendMessage("End");
			} else {
				if(this.getActivity(this.currentStepId).getName() != null) {
					MessageHandler.getInstance().sendMessage(this.formatLayout());
					System.out.println(this.getActivity(this.currentStepId).getName());
					this.currentStep++;
					this.logTimeElapsed();
				}
			}
		}
	}
	

	public void goToPreviousStep() {
		
		if(!this.isStarted) {
			this.startProcess();
			this.isStarted = true;
		}
		
		if(this.getActivity(this.currentStepId).isStartActivity) {
			
		} else {
			
			this.currentStepId = getKeyByValue(this.transitions, this.currentStepId);
			this.stepNumber--;
			if(this.getActivity(this.currentStepId).isStartActivity) {
				MessageHandler.getInstance().sendMessage("Start");
			}else {
				if(this.getActivity(this.currentStepId).getName() != null) {
					MessageHandler.getInstance().sendMessage(this.formatLayout());
					System.out.println(this.getActivity(this.currentStepId).getName());
					this.currentStep--;
					this.logTimeElapsed();
				}
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

	private String formatLayout() {
		String msg = "";
		this.processStep = "(" + this.stepNumber + "/" + (this.activities.size() - 2)  + ") "; //reduce two from size() since start and end activities are counted in size
		if (this.getActivity(this.currentStepId).getName() != null) msg += this.processStep + this.getActivity(this.currentStepId).getName()  + "<br />";
		if (this.getActivity(this.currentStepId).getDescription() != null) msg += Resources.DIV_OPEN + this.getActivity(this.currentStepId).getDescription() + "</td></tr><tr><td>";
		if (this.getActivity(this.currentStepId).getImagePath() != null && this.getActivity(this.currentStepId).getImagePath().length() > 0 ) msg +=  "<img src=\"" + this.getActivity(this.currentStepId).getImagePath() + "\"</img>"  + Resources.DIV_CLOSE + "</td>";
		if (this.getActivity(this.currentStepId).getVideoComponent() != null && this.getActivity(this.currentStepId).getVideoComponent().length() > 0 ) msg += this.getActivity(this.currentStepId).getVideoComponent()  + Resources.DIV_CLOSE + "</td>";
		if (this.getActivity(this.currentStepId).getAttachedUtensil() != null && this.getActivity(this.currentStepId).getAttachedUtensil().getImagePath().length() > 0 ) msg +=  "<td><table><tr><td class=\"table_cell\">" + Resources.UTENSIL_LABEL + "</td></tr><tr><td class=\"table_cell\"><img src=\"" + this.getActivity(this.currentStepId).getAttachedUtensil().getImagePath() + "\"</img></td></tr><tr><td class=\"table_cell\">"; 
		if (this.getActivity(this.currentStepId).getCamera() > 0) msg += Resources.CAMERAS[this.getActivity(this.currentStepId).getCamera() - 1] + Resources.DIV_CLOSE + Resources.DIV_CLOSE;
			
		this.appendVariable(Integer.toString(this.getActivity(this.currentStepId).getDuration())); //write duration in to a text file which will be read by javascript timer later
		   
		return msg;
	}
	
	private void appendVariable(String variable) {
		try
		{
		    String filename= "durationValue.txt";
		    FileWriter fw = new FileWriter(filename,false); 
		    fw.write(variable);
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}

	}
	
	private void logTimeElapsed () {
		
		try
		{
		    String filename= "elapsed_times.txt";
		    long elapsedTime = System.currentTimeMillis() - this.startTime;

		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write(this.currentStep + ": " + elapsedTime + " ms\n");//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
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
