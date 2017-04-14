package com.manskx.salemessageprocessing.model;

import java.util.Map;

public interface Message {
	public boolean Process(String Message, Map<String, Product> ListProducts, int messageCount);

	public boolean ifValidMessage(String messageLine);
}
