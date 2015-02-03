/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.nick.dwsms.models;

import org.joda.time.LocalDateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nickf
 */
public class MessageDatabaseTest {

	public MessageDatabaseTest() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of add method, of class MessageDatabase.
	 */
	@Test
	public void testAdd() throws Exception {
		System.out.println("add");
		TxtMessage msg = new TxtMessage();
		msg.body = "test1";
		msg.from = "from";
		msg.to = "test1";
		msg.send = LocalDateTime.now();
		MessageDatabase instance = new MessageDatabase(3);
		assertEquals(0, instance.size());
		instance.add(msg);
		assertEquals(1, instance.size());
		assertEquals(msg, instance.pop(LocalDateTime.now().plusDays(100)));
	}

	/**
	 * Test of pop method, of class MessageDatabase.
	 */
	@Test
	public void testPop() throws Exception {
		System.out.println("pop");
		TxtMessage msg = new TxtMessage();
		msg.body = "test1";
		msg.from = "from";
		msg.to = "test1";
		msg.send = LocalDateTime.now();
		MessageDatabase instance = new MessageDatabase(3);
		assertEquals(0, instance.size());
		instance.add(msg);
		assertEquals(1, instance.size());
		assertEquals(msg, instance.pop(LocalDateTime.now().plusDays(100)));
	}

	/**
	 * Test of size method, of class MessageDatabase.
	 */
	@Test
	public void testSize() throws Exception {
		System.out.println("add");
		TxtMessage msg = new TxtMessage();
		msg.body = "test1";
		msg.from = "from";
		msg.to = "test1";
		msg.send = LocalDateTime.now();
		MessageDatabase instance = new MessageDatabase(3);
		assertEquals(0, instance.size());
		instance.add(msg);
		assertEquals(1, instance.size());
		assertEquals(msg, instance.pop(LocalDateTime.now().plusDays(100)));
	}

	/**
	 * Test of clear method, of class MessageDatabase.
	 */
	@Test
	public void testClear() throws Exception {
		System.out.println("clear");
		TxtMessage msg = new TxtMessage();
		msg.body = "test1";
		msg.from = "from";
		msg.to = "test1";
		msg.send = LocalDateTime.now();
		MessageDatabase instance = new MessageDatabase(3);
		assertEquals(0, instance.size());
		instance.add(msg);
		assertEquals(1, instance.size());
		instance.clear();
		assertEquals(0, instance.size());
	}

}
