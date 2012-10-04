package org.smartflow;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.Attributes;

public class SmartFlowParser {
	
	
	
	public SmartFlowParser() {
	}
	
	public void parseXpdlFile(String _filename) throws DocumentException {
		
		File xmlFile = new File(_filename);
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(xmlFile);
		Element PACKAGE = document.getRootElement();
			 
		System.out.println("Root Element: " + PACKAGE.getName());
			 
		for (Iterator<?> i1 = PACKAGE.elementIterator("WorkflowProcesses"); i1.hasNext();) {
			
			Element WORKFLOWPROCESSES = (Element) i1.next();
		
			for (Iterator<?> i2 = WORKFLOWPROCESSES.elementIterator("WorkflowProcess");i2.hasNext();) {
				
				Element WORKFLOWPROCESS = (Element) i2.next();
				
				for (Iterator<?> i3 = WORKFLOWPROCESS.elementIterator("Activities"); i3.hasNext();) {
					Element ACTIVITIES = (Element) i3.next();
					
					for (Iterator<?> i4 = ACTIVITIES.elementIterator(); i4.hasNext();) {
						Element ACTIVITY = (Element) i4.next();
						for (Iterator<?> i5 = ACTIVITY.attributeIterator(); i5.hasNext();) {
							Attributes  attrs = (Attributes) i5.next();
							System.out.println(attrs.getValue("Name"));
						}	
					}

				}
			}
		}
	}
}
