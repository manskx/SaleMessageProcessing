package com.manskx.salemessageprocessing;

import java.util.ArrayList;
import java.util.Map;

import com.manskx.salemessageprocessing.IO.MessageWriter;
import com.manskx.salemessageprocessing.config.Configuration;
import com.manskx.salemessageprocessing.model.FinalReport;
import com.manskx.salemessageprocessing.model.IntervalReport;
import com.manskx.salemessageprocessing.model.Message;
import com.manskx.salemessageprocessing.model.MessageTypeOne;
import com.manskx.salemessageprocessing.model.MessageTypeThree;
import com.manskx.salemessageprocessing.model.MessageTypeTwo;
import com.manskx.salemessageprocessing.model.Product;
import com.manskx.salemessageprocessing.model.Report;

public class ReportProcessor {

	private Report intervalReport;
	private Report finalReport;

	// List products
	private Map<String, Product> listProducts;
	private MessageWriter messageWriter;

	public ReportProcessor(MessageWriter messageWriter) {
		this.messageWriter = messageWriter;
		initalizeReports();
	}

	private void initalizeReports() {
		intervalReport = new IntervalReport();
		intervalReport.setOutputMessageWriter(this.messageWriter);
		finalReport = new FinalReport();
		finalReport.setOutputMessageWriter(this.messageWriter);
	}

	public void processIntervalReports(int count) {
		if (count % Configuration.REPORT_INTERVAL == 0) {
			intervalReport.Process(listProducts, count);
		}
	}

	public void processFinalReport(int maxCount) {
		finalReport.Process(listProducts, maxCount);
	}

	public Report getIntervalReport() {
		return intervalReport;
	}

	public void setIntervalReport(Report intervalReport) {
		this.intervalReport = intervalReport;
	}

	public Map<String, Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(Map<String, Product> listProducts) {
		this.listProducts = listProducts;
	}

}
