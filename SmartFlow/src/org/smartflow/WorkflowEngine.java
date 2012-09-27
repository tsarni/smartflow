package org.smartflow;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class WorkflowEngine {

	private static final WorkflowEngine _workflowEngine = new WorkflowEngine();
	
	private WorkflowEngine() {
		
	}
	
	public static WorkflowEngine getInstance() {
		return _workflowEngine;
	}
	
	private void parseProcess(File processFile) throws DocumentException {
		
	}
	
	
}
