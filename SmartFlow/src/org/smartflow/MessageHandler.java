package org.smartflow;

import java.util.ArrayList;
import java.util.List;

import org.smartflow.server.HttpServer;

public class MessageHandler {
	
	private static final MessageHandler _messageHandler = new MessageHandler();
	private List<MessageReceiver> registeredReceivers= new ArrayList<MessageReceiver>();
	private List<MessageSender> registeredSenders= new ArrayList<MessageSender>();


	private MessageHandler() {
		
	}
	
	public static MessageHandler getInstance () {
		return _messageHandler;
	}
	
	public void registerReceiver(MessageReceiver receiver) {
		this.registeredReceivers.add(receiver);
	}
	
	public void registerSender(MessageSender sender ) {
		this.registeredSenders.add(sender);
	}
	
	public void messageReceived() {
		
		for (MessageReceiver client : this.registeredReceivers) {
			client.messageReceived();
		}
	}
	
	public void sendMessage(String msg) {
		
		for (MessageSender sender : this.registeredSenders) {
			sender.sendMessage(msg);
		}
	}

}
