package org.smartflow;

public abstract class Resources {
	
	public static final String HTML_START =
			"<html>" +
			"<head>"+
			"<LINK href=\"styles.css\" rel=\"stylesheet\" type=\"text/css\">" +
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
	
	public static final String DIV_OPEN= "<table class=\"wrapper\"><tr><td><table class=\"table_cell\"><tr><td>";
	
	public static final String DIV_CLOSE = "</td></tr></table>";

	public static final String HTML_WORKFLOW_BUTTONS_START =
			"<table class=\"table_cell\" style=\"margin-top:10px\"><tr><td><button onclick=\"pollServer('PREVIOUS')\">Previous</button></td>";
	
	public static final String HTML_WORKFLOW_BUTTONS_END=
			"<td><button onclick=\"pollServer('NEXT')\">Next</button></td></tr></table>";
	
	public static final String HTML_START_BUTTON = 
			"<td><button onclick=\"pollServer('START')\">Start</button></td>";
		
	public static final String HTML_STOP_BUTTON = 
			"<td><button onclick=\"pollServer('STOP')\">Stop</button></td>";
	
	public static final String RESPONSE_WELCOME_MESSAGE = "<b>Workflow engine server test </b><BR>";
	
	public static final String RESPONSE_CLIENT_REQUEST_MESSAGE = "The HTTP Client request is ....<BR>";
	
	public static final String ERROR_404_MESSAGE = "<b>ERROR 404: The requested resource not found</b>";
	
	public static final String UTENSIL_LABEL = "Keitti&oumlv&auml;line"; 
	
	public static final String[] CAMERAS = {"Kamera 1:" + "</br>" + " Keitti&oumln p&oumlyt&auml","Kamera 2:" + "</br>" + " Pesuallas","Kamera 3:" + "</br>" + "Kaappi 1 (Ensimm&aumlinen vasemmalta)","Kamera 4:" + "</br>" + " Kaappi 2 (Toinen vasemmalta)","Kamera 5:" + "</br>" + " Vetolaatikot"};
	
	
}
