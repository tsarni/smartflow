package org.smartflow;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import org.smartflow.server.HttpServer;


public class SmartFlow  {


	public static void main(String[] args) throws Exception, IOException {
		
		System.out.println ("TCPServer Waiting for client on port 5000");
		//WorkflowEngine.getInstance();
		//parseTest();
		//HttpServer httpServer = new HttpServer();
		//httpServer.run();
		SmartFlowParser sfParser = new SmartFlowParser();
		sfParser.parseXpdlFile("Smartflow.xpdl");
		
		
		
	}
	
	

	
}
