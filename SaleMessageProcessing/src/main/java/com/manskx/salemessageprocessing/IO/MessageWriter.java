package com.manskx.salemessageprocessing.IO;

public interface MessageWriter {
	public void writeMessageLine(String messageLine);

	public void finish();

}
