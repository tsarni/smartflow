package org.smartflow;

import java.util.ArrayList;
import java.util.List;

public class MessageHandler {
	List<MessageListener> registeredListeners = new ArrayList<MessageListener>();

	public void registerListener(MessageListener toAdd) {
		registeredListeners.add(toAdd);
	}

	public void messageReceived() {
		
		for (MessageListener client : registeredListeners) {
			client.messageReceived();
		}
	}

}
