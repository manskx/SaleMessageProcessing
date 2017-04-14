package com.manskx.salemessageprocessing.IO;

public class ConsoleMessageWriter implements MessageWriter {

	public void writeMessageLine(String messageLine) {
		System.out.println(messageLine);
	}

	public void finish() {
		// do nothing in console
	}

}
