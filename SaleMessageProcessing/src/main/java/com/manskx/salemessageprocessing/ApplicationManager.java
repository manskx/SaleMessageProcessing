package com.manskx.salemessageprocessing;

import com.manskx.salemessageprocessing.IO.ConsoleMessageReader;
import com.manskx.salemessageprocessing.IO.ConsoleMessageWriter;
import com.manskx.salemessageprocessing.IO.MessageReader;
import com.manskx.salemessageprocessing.IO.MessageWriter;

/**
 * 
 * @author mansk </br>
 *         This class is the manager of application components and it is
 *         responsible for
 *         <li>define input/output methods (console/ file ...)</li>
 *         <li>define message / report processors</li> </br>
 *         <b>Note: This class is singleton</b>
 */
public class ApplicationManager {
	private MessageProcessor messageProcessor;
	private ReportProcessor reportProcessor;
	private static ApplicationManager instance;

	private MessageReader consoleMessageReader;
	private MessageWriter consoleMessgeWriter;

	private ApplicationManager() {
		consoleMessageReader = new ConsoleMessageReader();
		consoleMessgeWriter = new ConsoleMessageWriter();
		reportProcessor = new ReportProcessor(consoleMessgeWriter);
		messageProcessor = new MessageProcessor(consoleMessageReader, consoleMessgeWriter, reportProcessor);
	}

	// one instance singleton
	public static ApplicationManager getInstance() {
		if (instance == null) {
			instance = new ApplicationManager();
		}
		return instance;
	}

	public void start() {
		messageProcessor.startProcessing();
	}

}
