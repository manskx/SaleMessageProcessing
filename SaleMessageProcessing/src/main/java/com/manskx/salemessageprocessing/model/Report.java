package com.manskx.salemessageprocessing.model;

import java.util.Map;

import com.manskx.salemessageprocessing.IO.MessageWriter;
/**
 * 
 * @author mansk </br>
 *         This interface defines Report. If you want to add new report type
 *         you must implement these methods
 */
public interface Report {
	/**
	 * 
	 * @param messageWriter output method
	 */
	public void setOutputMessageWriter(MessageWriter messageWriter);
	
	/**
	 * 
	 * @param listProducts
	 * @param messageCount indicator for (when the report is being generated ex: at message 5)
	 */
	public void Process(Map<String, Product> listProducts, int messageCount);
}
