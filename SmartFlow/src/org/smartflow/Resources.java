package org.smartflow;

public abstract class Resources {
	
	public static final String HTML_START =
			"<html>" +
			
			"<head>"+
			"<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js\" type=\"text/javascript\" charset=\"utf-8\"></script>" +
			"<title>Smart Kitchen Workflow Engine</title>" +
			"<script type=\"text/javascript\" charset=\"utf-8\">" +
		    "function make_call()"+
		    "{"+
		     	
  
  			"document.write.textout = httpGet(\"get.html\");"+

		      "setTimeout(function(){"+ 
		        "make_call();" +
		      "}, 5000);" +
		    "}" +

//		    "$(document).ready(function() {" +
//		      "make_call();" +
//		    "});"+
		    
		    "function httpGet(theUrl) {"+
		    	"var xmlHttp = null;"+
		    	"xmlHttp = new XMLHttpRequest();" +
		    	
//				"xmlhttp.onreadystatechange = function () {"+
//					"alert(\"got some stuff back:\"+xmlHttp.responseText);" +
//				"};" +
		    
		    	"xmlHttp.open( \"GET\", theUrl, true );"+
		    	// "xmlHttp.onreadystatechange = useHttpResponse();" +
		    	"xmlHttp.send( null );" +
		    	//"alert(\"got some stuff back:\"+xmlHttp.responseText);" +
		    	
		    	"return xmlHttp.responseText;" +
		    "}" +
		    
		    "function useHttpResponse() {" +
		    	"alert(\"got some stuff back:\"+xmlHttp.responseText);" +
		    	 // "if (http.readyState == 4) {"+
		    	    //"var textout = http.responseText;" +
		    	    //"document.write.textout;" +
		    	  //"}"+
		    "}" +
		    "</script>" +
		    "<head>" +
			"<body>" +
		    "<div align=\"center\">";
		    
	
	public static final String HTML_END =
			"<table><tr>" +
			"<td><FORM ACTION=\"PREVIOUS\" METHOD=POST>" +
			"<input type=\"submit\" value=\"Previous\"></FORM></td>" +
			"<td><FORM ACTION=\"NEXT\" METHOD=POST>" +
			"<input type=\"submit\" value=\"Next\"></FORM></td>" +
			"</tr></table>" +
			"</div></body>" +
			"</html>";
	
	public static final String RESPONSE_WELCOME_MESSAGE = "<b> This is the HTTP Server Home Page.... </b><BR>";
	
	public static final String RESPONSE_CLIENT_REQUEST_MESSAGE = "The HTTP Client request is ....<BR>";
	
	public static final String ERROR_404_MESSAGE = "<b>ERROR 404: The requested resource not found</b>";
	
}
