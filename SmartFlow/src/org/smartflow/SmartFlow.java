package org.smartflow;

import java.io.IOException;


import org.smartflow.server.HttpServer;


public class SmartFlow  {


	public static void main(String[] args) throws Exception, IOException {
		
		System.out.println ("TCPServer Waiting for client on port 5000");

		
		//startHttpServer();
	
		SmartFlowParser sfParser = new SmartFlowParser();
		sfParser.parseXpdlFile("Smartflow.xpdl");
		//WorkflowEngine.getInstance().startProcess();
		HttpServer httpServer = new HttpServer();
		
		
		
	}
	
	private void startHttpServer() {
		//Thread serverThread = new Thread();
	}
	
	

	
}
