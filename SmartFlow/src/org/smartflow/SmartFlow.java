package org.smartflow;

import java.io.IOException;


import org.smartflow.server.HttpServer;


public class SmartFlow  {


	public static void main(String[] args) throws Exception, IOException {
		
		System.out.println ("TCPServer Waiting for client on port " + Settings.SERVER_PORT);
		SmartFlowParser sfParser = new SmartFlowParser();
		sfParser.parseXpdlFile("Smartflow.xpdl");
		
		@SuppressWarnings("unused")
		HttpServer httpServer = new HttpServer();
		
		
		
	}

	

	
}
