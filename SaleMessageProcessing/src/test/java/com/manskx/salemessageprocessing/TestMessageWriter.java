package com.manskx.salemessageprocessing;

import java.util.ArrayList;
import java.util.List;

import com.manskx.salemessageprocessing.IO.MessageWriter;

public class TestMessageWriter implements MessageWriter {
	private List<String> lines;

	public TestMessageWriter() {
		this.lines = new ArrayList<String>();
	}

	public void writeMessageLine(String messageLine) {
		lines.add(messageLine);
	}

	public List<String> getLines() {
		return lines;
	}

	public void setLines(List<String> lines) {
		this.lines = lines;
	}

	public void finish() {
		// TODO Auto-generated method stub

	}

}
