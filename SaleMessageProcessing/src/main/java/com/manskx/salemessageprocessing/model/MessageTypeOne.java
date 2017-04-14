package com.manskx.salemessageprocessing.model;

import java.util.regex.Matcher;

import com.manskx.salemessageprocessing.utils.*;

public class MessageTypeOne implements Message {
	private static String MessageTypeOne_REGEX = "(\\w+)\\sat\\s(\\d+)p$";

	public boolean Process(String Message, int messageCount) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ifValidMessage(String messageLine) {
		boolean isValid = Regex.isRegexMatch(MessageTypeOne_REGEX, messageLine);
		return isValid;
	}

}
