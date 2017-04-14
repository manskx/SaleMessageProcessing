package com.manskx.salemessageprocessing;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.manskx.salemessageprocessing.model.Message;
import com.manskx.salemessageprocessing.model.MessageTypeOne;

public class MessageTypeOneTest {
	Message messageTypeOne;

	@Before
	public void setUp() {
		messageTypeOne = new MessageTypeOne();
	}

	@Test
	public void TestValidMessageTypeOne1() {
		String messageLine = "asdsds";
		boolean valid = messageTypeOne.ifValidMessage(messageLine);
		assertEquals(valid, false);
	}

	@Test
	public void TestValidMessageTypeOne2() {
		String messageLine = "apple at 10p";
		boolean valid = messageTypeOne.ifValidMessage(messageLine);
		assertEquals(valid, true);
	}

	@Test
	public void TestValidMessageTypeOne3() {
		String messageLine = "apple at 10";
		boolean valid = messageTypeOne.ifValidMessage(messageLine);
		assertEquals(valid, false);
	}

	@Test
	public void TestValidMessageTypeOne4() {
		String messageLine = "apple   10p";
		boolean valid = messageTypeOne.ifValidMessage(messageLine);
		assertEquals(valid, false);
	}

	@Test
	public void TestValidMessageTypeOne5() {
		String messageLine = "apple at 10pp";
		boolean valid = messageTypeOne.ifValidMessage(messageLine);
		assertEquals(valid, false);
	}

	@Test
	public void TestValidMessageTypeOne6() {
		String messageLine = "orange at 10p";
		boolean valid = messageTypeOne.ifValidMessage(messageLine);
		assertEquals(valid, true);
	}

	@Test
	public void TestValidMessageTypeOne7() {
		String messageLine = "bate on 10p";
		boolean valid = messageTypeOne.ifValidMessage(messageLine);
		assertEquals(valid, false);
	}

	@Test
	public void TestValidMessageTypeOne8() {
		String messageLine = "20 sales of oranges at 41p each";
		boolean valid = messageTypeOne.ifValidMessage(messageLine);
		assertEquals(valid, false);
	}

	@Test
	public void TestValidMessageTypeOne9() {
		String messageLine = "Multiply 20p apples";
		boolean valid = messageTypeOne.ifValidMessage(messageLine);
		assertEquals(valid, false);
	}

}
