package com.manskx.salemessageprocessing.model;

import java.util.List;
import java.util.Map;

import com.manskx.salemessageprocessing.utils.*;

public class MessageTypeOne implements Message {
	private final String MessageTypeOne_REGEX = "(\\w+)\\sat\\s(\\d+)p$";

	public boolean ifValidMessage(String messageLine) {
		boolean isValid = Regex.isRegexMatch(MessageTypeOne_REGEX, messageLine);
		return isValid;
	}

	public boolean Process(String Message, Map<String, Product> ListProducts, int messageCount) {
		List<String> tokens = Regex.getRegexTokens(this.MessageTypeOne_REGEX, Message);
		String productName = tokens.get(1);
		if (!ListProducts.containsKey(productName))
			ListProducts.put(productName, new Product());
		Product product = ListProducts.get(productName);
		int saleValue = Integer.parseInt(tokens.get(2));
		product.addSaleToProduct(new Sale(saleValue));

		return true;
	}

}
