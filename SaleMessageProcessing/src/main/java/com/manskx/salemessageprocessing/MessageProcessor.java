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
import com.manskx.salemessageprocessing.model.MessageTypeThree;
import com.manskx.salemessageprocessing.model.MessageTypeTwo;
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

	/**
	 * This method initializes Messages and its type </br>
	 * <b> NOTE: Don't forget to add new message types if you want to add new
	 * message type. </b>
	 */
	private void initalizeMessages() {
		listMessages = new ArrayList<Message>();
		Message messageTypeOne = new MessageTypeOne();
		Message messageTypeTwo = new MessageTypeTwo();
		Message messageTypeThree = new MessageTypeThree();

		listMessages.add(messageTypeOne);
		listMessages.add(messageTypeTwo);
		listMessages.add(messageTypeThree);
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
		// check if reach max number of messages
		if ((messageCount == Configuration.Max)) {
			reportProcessor.processFinalReport(Configuration.Max);
		}

	}

	public ReportProcessor getReportProcessor() {
		return reportProcessor;
	}

	public void setReportProcessor(ReportProcessor reportProcessor) {
		this.reportProcessor = reportProcessor;
	}

	public MessageReader getMessageReader() {
		return messageReader;
	}

	public void setMessageReader(MessageReader messageReader) {
		this.messageReader = messageReader;
	}

	public MessageWriter getMessgeWriter() {
		return messgeWriter;
	}

	public void setMessgeWriter(MessageWriter messgeWriter) {
		this.messgeWriter = messgeWriter;
	}
}
