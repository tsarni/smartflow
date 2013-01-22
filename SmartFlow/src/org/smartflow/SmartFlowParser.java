package org.smartflow;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


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
						
						if(ACTIVITY.attributeValue("Id") != null) {
							
							Activity activity = new Activity();
							activity.setId(ACTIVITY.attributeValue("Id"));
							if (ACTIVITY.attributeValue("Name") != null) activity.setName(ACTIVITY.attributeValue("Name"));
							if (ACTIVITY.element("Description") != null) activity.setDescription(ACTIVITY.elementText("Description"));
							
							if(ACTIVITY.element("Event") != null) {
								
								if(ACTIVITY.element("Event").element("StartEvent") != null) {
									activity.isStartActivity = true;
									WorkflowEngine.getInstance().setStartId(ACTIVITY.attributeValue("Id"));
								}
								
								if(ACTIVITY.element("Event").element("EndEvent") != null) {
									activity.isEndActivity = true;
								}
							}
							
							if(ACTIVITY.element("ExtendedAttributes") != null) {
								
								for (int e = 0; e < ACTIVITY.element("ExtendedAttributes").elements().size(); e++) {
									Element el = (Element) ACTIVITY.element("ExtendedAttributes").elements().get(e);
									if (el.attributeValue("Name").equals("object_image")) {
										activity.setImagePath(el.attributeValue("Value"));
									}
									if (el.attributeValue("Name").equals("utensil_image")) {
										Utensil utensil = new Utensil();
										utensil.setImagePath(el.attributeValue("Value"));
										activity.attachUtensil(utensil);
									}
									if (el.attributeValue("Name").equals("duration")) {
										activity.setDuration(Integer.parseInt(el.attributeValue("Value")));
									}
									if (el.attributeValue("Name").equals("camera")) {
										activity.setCamera(Integer.parseInt(el.attributeValue("Value")));
									}
								}

							}
							
							WorkflowEngine.getInstance().storeActivity(activity);
							//activity.setDescription(ACTIVITY.attributeValue("Description"));
							
						}
						
						
						

					}

				}
				
				for (Iterator<?> i6 = WORKFLOWPROCESS.elementIterator("Transitions"); i6.hasNext();) {
					Element TRANSITIONS = (Element) i6.next();
					
					for (Iterator<?> i7 = TRANSITIONS.elementIterator(); i7.hasNext();) {
						Element TRANSITION = (Element) i7.next();
						
						WorkflowEngine.getInstance().storeTransition(TRANSITION.attributeValue("From"), TRANSITION.attributeValue("To"));
					}

				}
			}
		}
	}
}
