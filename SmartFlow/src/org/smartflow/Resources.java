package org.smartflow;

public abstract class Resources {
	
	public static final String HTML_START =
			"<html>" +
			"<head>"+
			"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"/>"	+	
			"<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js\" type=\"text/javascript\" charset=\"iso-8859-1\"></script>" +
			"<title>Smart Kitchen Workflow Engine</title>" +
			"<script src=\"client.js\"  type=\"text/javascript\" charset=\"iso-8859-1\"></script>" +
		    "</head>" +
			"<body style=\"background-color:#1F3D5C;color:#ffffff\">" +
		    "<div align=\"center\" id=\"holder\">";
		    
	
	public static final String HTML_END =
			
			"</div><div align=\"center\" id=\"timer\"/></body>" +
			"</html>";
	
	public static final String DIV_STYLE= "<table style=\"border-radius:4px;border-color:#000000;background-color:#4D778D;border-style:solid;padding:5px 5px 5px 5px;text-align:center;\"><tr><td><font size=\"16\">Apukuva</font></td></tr><tr><td>";
	public static final String DIV_CLOSE = "</tr><td></table>";
	
	public static final String HTML_WORKFLOW_BUTTONS_START =
			"<table><tr><td><button onclick=\"pollServer('PREVIOUS')\">Previous</button></td>";
	
	public static final String HTML_WORKFLOW_BUTTONS_END=
			"<td><button onclick=\"pollServer('NEXT')\">Next</button></td></tr></table>";
	
	public static final String HTML_START_BUTTON = 
			"<td><button onclick=\"pollServer('START')\">Start</button></td>";
		
	public static final String HTML_STOP_BUTTON = 
			"<td><button onclick=\"pollServer('STOP')\">Stop</button></td>";
	
	public static final String RESPONSE_WELCOME_MESSAGE = "<b>Workflow engine server test </b><BR>";
	
	public static final String RESPONSE_CLIENT_REQUEST_MESSAGE = "The HTTP Client request is ....<BR>";
	
	public static final String ERROR_404_MESSAGE = "<b>ERROR 404: The requested resource not found</b>";
	
	public static final String GUIDANCE_IMAGE_TITLE = "Apukuva";
	
	public static final String[] CAMERAS = {"C1: Keittiön pöytä","C2: Pesuallas","C3: Kaappi 1 (Ensimmäinen vasemmalta)","C4: Kaappi 2 (Toinen vasemmalta)","C5: Vetolaatikot"};
	
	
}
