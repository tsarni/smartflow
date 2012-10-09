package org.smartflow;

public abstract class Resources {
	
	public static final String HTML_START =
			"<html>" +
			
			"<head>"+
			"<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js\" type=\"text/javascript\" charset=\"utf-8\"></script>" +
			"<title>Smart Kitchen Workflow Engine</title>" +
			"<script src=\"client.js\"  type=\"text/javascript\" charset=\"utf-8\">" +
		    "</script>" +
		    "</head>" +
			"<body>" +
		    "<div align=\"center\" id=\"holder\">";
		    
	
	public static final String HTML_END =
			
			"</div><div id=\"timer\" /></body>" +
			"</html>";
	
	public static final String HTML_WORKFLOW_BUTTONS =
			"<table><tr>" +
			"<td><FORM ACTION=\"PREVIOUS\" METHOD=POST>" +
			"<input type=\"submit\" value=\"Previous\"></FORM></td>" +
			"<td><FORM ACTION=\"NEXT\" METHOD=POST>" +
			"<input type=\"submit\" value=\"Next\"></FORM></td>" +
			"</tr></table>";
	
	public static final String HTML_START_SCREEN =
		
			"<table><tr>" +
			"<td><button onclick=\"callPrevious()\">Previous</button></td>" +
			"<td><button onclick=\"callNext()\">Next</button></td>" +
			"</tr></table>";

			
			
	
	public static final String RESPONSE_WELCOME_MESSAGE = "<b>Workflow engine server test </b><BR>";
	
	public static final String RESPONSE_CLIENT_REQUEST_MESSAGE = "The HTTP Client request is ....<BR>";
	
	public static final String ERROR_404_MESSAGE = "<b>ERROR 404: The requested resource not found</b>";
	
}
