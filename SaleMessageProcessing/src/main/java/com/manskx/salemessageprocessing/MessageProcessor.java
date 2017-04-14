package com.manskx.salemessageprocessing;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.manskx.salemessageprocessing.IO.MessageReader;
import com.manskx.salemessageprocessing.IO.MessageWriter;
import com.manskx.salemessageprocessing.config.Configuration;
import com.manskx.salemessageprocessing.model.Message;
import com.manskx.salemessageprocessing.model.MessageTypeOne;
import com.manskx.salemessageprocessing.model.Product;

public class MessageProcessor {
	// reports
	private ReportProcessor reportProcessor;
	// List Messages
	private List<Message> listMessages;

	private MessageReader messageReader;
	private MessageWriter messgeWriter;
	// List products
	private Map<String, Product> listProducts;

	public MessageProcessor(MessageReader messageReader, MessageWriter messgeWriter, ReportProcessor reportProcessor) {
		initalizeMessages();
		this.messageReader = messageReader;
		this.messgeWriter = messgeWriter;
		this.reportProcessor = reportProcessor;
		listProducts = new LinkedHashMap<String, Product>();
		this.reportProcessor.setListProducts(listProducts);
	}

	private void initalizeMessages() {
		listMessages = new ArrayList<Message>();
		Message messageTypeOne = new MessageTypeOne();

		listMessages.add(messageTypeOne);

	}

	public void startProcessing() {
		int messageCount = 0;
		while ((messageCount < Configuration.Max) && messageReader.hasNext()) {
			String messageLine = messageReader.getNextMessageLine();
			messageCount++;
			boolean validMessage = false;
			for (Message message : listMessages) {
				if (message.ifValidMessage(messageLine))
					if (message.Process(messageLine, listProducts, messageCount)) {
						validMessage = true;
						break;
					}
			}
			// if not found valid message -- throw exception
			if (!validMessage)
				throw new IllegalArgumentException("Message Type not supported");
			reportProcessor.processIntervalReports(messageCount);
		}

	}
}
