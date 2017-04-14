package com.manskx.salemessageprocessing.model;

import java.util.Map;
import java.util.Map.Entry;

import com.manskx.salemessageprocessing.IO.MessageWriter;

public class FinalReport implements Report {
	private MessageWriter messageWriter;

	public void Process(Map<String, Product> listProducts, int messageCount) {
		String reportHeader = "FinalReport: " + messageCount;
		messageWriter.writeMessageLine(reportHeader);
		for (Entry<String, Product> product : listProducts.entrySet()) {
			String Line = "History of Product: " + product.getKey();
			messageWriter.writeMessageLine(Line);
			for (String history : product.getValue().getHistory()) {
				messageWriter.writeMessageLine(history);
			}
			Line = "Total For Product: " + product.getKey() + "  Value: " + product.getValue().getTotalValue()
					+ " Sales:" + product.getValue().getNumberOfSales();
			messageWriter.writeMessageLine(Line);
		}
	}

	public void setOutputMessageWriter(MessageWriter messageWriter) {
		this.messageWriter = messageWriter;
	}

}
