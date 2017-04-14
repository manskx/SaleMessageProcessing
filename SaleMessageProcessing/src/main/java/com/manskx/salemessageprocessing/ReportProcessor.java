package com.manskx.salemessageprocessing;

import java.util.Map;

import com.manskx.salemessageprocessing.IO.MessageWriter;
import com.manskx.salemessageprocessing.model.IntervalReport;
import com.manskx.salemessageprocessing.model.Product;
import com.manskx.salemessageprocessing.model.Report;

public class ReportProcessor {

	private Report intervalReport;
	// List products
	private Map<String, Product> listProducts;
	private MessageWriter messageWriter;

	public ReportProcessor(MessageWriter messageWriter) {
		this.messageWriter = messageWriter;
		intervalReport = new IntervalReport();
		intervalReport.setOutputMessageWriter(messageWriter);

	}

}
