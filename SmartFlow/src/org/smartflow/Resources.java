package org.smartflow;

public abstract class Resources {
	
	public static final String HTML_START =
			"<html>" +
			"<title>Smart Kitchen Workflow Engine</title>" +
			"<body>";

	public static final String HTML_END =
			"</body>" +
			"</html>";
	
	public static final String RESPONSE_WELCOME_MESSAGE = "<b> This is the HTTP Server Home Page.... </b><BR>";
	
	public static final String RESPONSE_CLIENT_REQUEST_MESSAGE = "The HTTP Client request is ....<BR>";
	
	public static final String ERROR_404_MESSAGE = "<b>ERROR 404: The requested resource not found</b>";
	
}
