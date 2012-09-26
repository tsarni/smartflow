package org.smartflow.server;


import java.io.*;
import java.net.*;
import java.util.*;

import org.smartflow.Resources;
import org.smartflow.Settings;

public class SmartHttpServer extends Thread {

private static final SmartHttpServer SmartHttpServerInstance = new SmartHttpServer();

private Socket clientSocket;
private ServerSocket serverSocket;

private BufferedReader socketReader;
private DataOutputStream outputStream;



private SmartHttpServer() {
	
	try {
		this.serverSocket = new ServerSocket (Settings.SERVER_PORT, 10, InetAddress.getByName(Settings.LOCAL_HOST));
		this.setClient(serverSocket.accept());
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


public static SmartHttpServer getInstance() {
    return SmartHttpServerInstance;
}

public void setClient(Socket client) {
	this.clientSocket = client;
}

public Socket getClient() {
	return this.clientSocket;
}

public void run() {

	try {

		System.out.println( "The Client "+
		clientSocket.getInetAddress() + ":" + clientSocket.getPort() + " is connected");

		socketReader = new BufferedReader(new InputStreamReader (clientSocket.getInputStream()));
		outputStream = new DataOutputStream(clientSocket.getOutputStream());

		String clientRequest = socketReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(clientRequest);
		String httpMethod = tokenizer.nextToken();
		String httpQueryString = tokenizer.nextToken();

		StringBuffer serverResponse = new StringBuffer();
		serverResponse.append(Resources.RESPONSE_WELCOME_MESSAGE);
		serverResponse.append(Resources.RESPONSE_CLIENT_REQUEST_MESSAGE);

		System.out.println("The HTTP request string is ....");
		
		while (socketReader.ready())	{

			// Read the HTTP complete HTTP Query
			serverResponse.append(clientRequest + "<BR>");
			System.out.println(clientRequest);
			clientRequest = socketReader.readLine();
		}

		if (httpMethod.equals("GET")) {
			
			if (httpQueryString.equals("/")) {
				// The default home page
				sendResponse(200, serverResponse.toString(), false);
			} else {
				//This is interpreted as a file name
				String fileName = httpQueryString.replaceFirst("/", "");
				fileName = URLDecoder.decode(fileName);
				if (new File(fileName).isFile()){
					sendResponse(200, fileName, true);
				}
				else {
					sendResponse(404, Resources.ERROR_404_MESSAGE, false);
				}
			}
			
		} else { 
			sendResponse(404, Resources.ERROR_404_MESSAGE, false);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void sendResponse (int statusCode, String responseString, boolean isFile) throws Exception {

	String statusLine = null;
	String serverdetails = Settings.SERVER_DETAILS;
	String contentLengthLine = null;
	String fileName = null;
	String contentTypeLine = "Content-Type: text/html" + "\r\n";
	FileInputStream fin = null;

	if (statusCode == 200)
		statusLine = "HTTP/1.1 200 OK" + "\r\n";
	else
		statusLine = "HTTP/1.1 404 Not Found" + "\r\n";

	if (isFile) {
		fileName = responseString;
		fin = new FileInputStream(fileName);
		contentLengthLine = "Content-Length: " + Integer.toString(fin.available()) + "\r\n";
		if (!fileName.endsWith(".htm") && !fileName.endsWith(".html"))
			contentTypeLine = "Content-Type: \r\n";
	} else {
		responseString = Resources.HTML_START + responseString + Resources.HTML_END;
		contentLengthLine = "Content-Length: " + responseString.length() + "\r\n";
	}

	outputStream.writeBytes(statusLine);
	outputStream.writeBytes(serverdetails);
	outputStream.writeBytes(contentTypeLine);
	outputStream.writeBytes(contentLengthLine);
	outputStream.writeBytes("Connection: close\r\n");
	outputStream.writeBytes("\r\n");

	if (isFile) sendFile(fin, outputStream);
	else outputStream.writeBytes(responseString);

	//outputStream.close();
}

public void sendFile (FileInputStream fin, DataOutputStream out) throws Exception {
	
	byte[] buffer = new byte[1024] ;
	int bytesRead;

	while ((bytesRead = fin.read(buffer)) != -1 ) {
		out.write(buffer, 0, bytesRead);
	}

	//fin.close();
}



}

