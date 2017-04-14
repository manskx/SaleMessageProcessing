package com.manskx.salemessageprocessing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.manskx.salemessageprocessing.IO.MessageReader;
import com.manskx.salemessageprocessing.IO.MessageWriter;

public class MessageProcessingApplicationTest {
	private MessageProcessor messageProcessor;
	private ReportProcessor reportProcessor;

	private MessageReader testMessageReader;
	private MessageWriter testMessgeWriter;
	private List<String> inputList;
	private List<String> outputList;

	@Before
	public void setUp() {
		inputList = new ArrayList<String>();
		outputList = new ArrayList<String>();
		testMessageReader = new TestMessageReader(inputList);
		testMessgeWriter = new TestMessageWriter();
		reportProcessor = new ReportProcessor(testMessgeWriter);
		messageProcessor = new MessageProcessor(testMessageReader, testMessgeWriter, reportProcessor);
	}

	@Test
	public void MessageProcessingApplicationTest1() {
		inputList.clear();
		inputList.add("apple at 10p");
		inputList.add("apple at 10p");
		inputList.add("apple at 10p");
		inputList.add("apple at 10p");
		inputList.add("apple at 10p");
		inputList.add("apple at 10p");
		inputList.add("apple at 10p");
		inputList.add("apple at 10p");
		inputList.add("apple at 10p");
		inputList.add("apple at 10p");
		outputList.clear();
		outputList.add("SaleAfter: 10");
		outputList.add("Product: apple  Value: 100 Sales:10");
		messageProcessor.startProcessing();
		assertEquals(((TestMessageWriter) testMessgeWriter).getLines(), outputList);
	}

	@Test(expected = IllegalArgumentException.class)
	public void MessageProcessingApplicationTest2() {
		inputList.clear();
		inputList.add("applesss10p");
		inputList.add("20 sales of oranges at 41p each");
		inputList.add("Multiply 20p apples");
		inputList.add("orange at 10p");
		inputList.add("20 sales of oranges at 10p each");
		inputList.add("Multiply 20p apples");
		inputList.add("Subtract 20p oranges");
		inputList.add("Subtract 20p oranges");
		inputList.add("Multiply 20p apples");
		inputList.add("Add 20p apples");
		outputList.clear();
		outputList.add("SaleDataAfter: 10");
		outputList.add("Product: apple  Value: 80020 Sales:1");
		outputList.add("Product: orange  Value: 20 Sales:41");
		messageProcessor.startProcessing();
	}

}
