package com.manskx.salemessageprocessing.model;

import java.util.Map;

import com.manskx.salemessageprocessing.IO.MessageWriter;

public interface Report {
	public void setOutputMessageWriter(MessageWriter messageWriter);

	public void Process(Map<String, Product> listProducts, int messageCount);
}
