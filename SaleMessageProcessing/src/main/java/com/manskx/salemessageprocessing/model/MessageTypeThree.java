package com.manskx.salemessageprocessing.model;

import java.util.List;
import java.util.Map;

import com.manskx.salemessageprocessing.model.Product.UpdateType;
import com.manskx.salemessageprocessing.utils.Regex;

/**
 * 
 * @author mansk </br>
 *         This type of messages can doing an operation to previous sales
 */
public class MessageTypeThree implements Message {
	// regex for essage format validating
	private String MessageTypeThree_REGEX = "(Add|Subtract|Multiply)\\s(\\d+)p?\\s(\\w+)s$";

	public boolean ifValidMessage(String messageLine) {
		boolean isValid = Regex.isRegexMatch(MessageTypeThree_REGEX, messageLine);
		return isValid;
	}

	public boolean Process(String Message, Map<String, Product> ListProducts, int messageCount) {

		List<String> tokens = Regex.getRegexTokens(this.MessageTypeThree_REGEX, Message);
		UpdateType updateType = Product.UpdateType.valueOf(tokens.get(1).toUpperCase());

		String productName = tokens.get(3);
		// if product not found before add it to map
		if (!ListProducts.containsKey(productName))
			ListProducts.put(productName, new Product());
		Product product = ListProducts.get(productName);

		int changeValue = Integer.parseInt(tokens.get(2));
		product.updateAllSales(updateType, changeValue);

		String historyRecordLine = "At message#" + messageCount + " " + updateType.toString() + " previous ("
				+ product.getNumberOfSales() + ") sales to: " + productName + " with value: " + changeValue;
		product.addHistoryRecord(historyRecordLine);

		return true;
	}

}
