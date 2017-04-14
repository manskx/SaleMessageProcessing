package com.manskx.salemessageprocessing.IO;

public interface MessageReader {
	public String getNextMessageLine();

	public boolean hasNext();

	public void finish();
}
