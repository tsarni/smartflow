package org.smartflow;

public class Scheduler extends Thread {
	
	private int duration;
	private String min;
	private String sec;
	public boolean isStopped = false;
	
	
	public Scheduler (int duration) {
		this.duration = duration;
	}
	
	public void run() {
		
		int _elapsed = 0;
		
		while(!isStopped)
		
			for(int m = 0; m < 60 ;m++) {
				
				for(int s = 0; s < 60; s++) {
					
					if(s < 10) {
						sec = "0" + s;
					} else {
						sec = Integer.toString(s);
					}
					if (m < 10) {
						min = "0" + m;
					} else {
						min = Integer.toString(m);
					}
						
					//System.out.println(min + ":" + sec);
					
					try{
                	 Scheduler.sleep(1000);
					}	catch(Exception e){
                	 //nothing
					}
					
					_elapsed++;
					if(this.isStopped) break;
					WorkflowEngine.getInstance().goToNextStep();
					//System.out.println(_elapsed);
             }
         }
	}

}


