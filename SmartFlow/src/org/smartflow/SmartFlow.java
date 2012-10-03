package org.smartflow;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import org.smartflow.server.HttpServer;


public class SmartFlow  {


	public static void main(String[] args) throws Exception, IOException {
		
		System.out.println ("TCPServer Waiting for client on port 5000");
		WorkflowEngine.getInstance();
		//parseTest();
		//HttpServer.getInstance().run();
		HttpServer httpServer = new HttpServer();
		httpServer.run();
		
		
		
		
	}
	
	private static void parseTest() throws DocumentException {
		File xmlFile = new File("testworkflow.xpdl");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(xmlFile);
		
		
		Element PACKAGE = document.getRootElement();
			 
		System.out.println("Root Element: " + PACKAGE.getName());
			 
		for (Iterator<?> i1 = PACKAGE.elementIterator("WorkflowProcesses"); i1.hasNext();) {
			
			Element WORKFLOWPROCESSES = (Element) i1.next();
		
			for (Iterator<?> i2 = WORKFLOWPROCESSES.elementIterator("WorkflowProcess");i2.hasNext();) {
				
				Element WORKFLOWPROCESS = (Element) i2.next();
				
				for (Iterator<?> i3 = WORKFLOWPROCESS.elementIterator(); i3.hasNext();) {
					Element element = (Element) i3.next();
					System.out.println(element.getName() );
		
					
				}
			}
		}
	}

	
}
