package com.manskx.salemessageprocessing.model;

public interface Message {
	public boolean Process(String Message, int messageCount);

	public boolean ifValidMessage(String messageLine);
}
