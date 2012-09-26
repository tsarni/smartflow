package org.smartflow;

import java.io.IOException;

import org.smartflow.server.HttpServer;


public class SmartFlow {


	public static void main(String[] args) throws Exception, IOException {

		System.out.println ("TCPServer Waiting for client on port 5000");
		HttpServer.getInstance().run();	

	}
	

}
