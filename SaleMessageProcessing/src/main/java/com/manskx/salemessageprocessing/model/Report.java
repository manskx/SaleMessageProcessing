package com.manskx.salemessageprocessing.model;


import com.manskx.salemessageprocessing.IO.MessageWriter;

public interface Report {
	public void setOutputMessageWriter(MessageWriter messageWriter);

	public void Process(int messageCount);
}
