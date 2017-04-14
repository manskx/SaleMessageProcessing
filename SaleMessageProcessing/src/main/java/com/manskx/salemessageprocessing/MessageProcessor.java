package com.manskx.salemessageprocessing;

import java.util.List;

import com.manskx.salemessageprocessing.IO.MessageReader;
import com.manskx.salemessageprocessing.IO.MessageWriter;
import com.manskx.salemessageprocessing.config.Configuration;
import com.manskx.salemessageprocessing.model.Message;

public class MessageProcessor {

	// List Messages
	private List<Message> listMessages;

	private MessageReader messageReader;
	private MessageWriter messgeWriter;

	public void startProcessing() {
		int messageCount = 0;
		while ((messageCount < Configuration.Max) && messageReader.hasNext()) {
			String messageLine = messageReader.getNextMessageLine();
			messageCount++;
			boolean validMessage = false;
			for (Message message : listMessages) {

				// process
			}

		}

	}
}
