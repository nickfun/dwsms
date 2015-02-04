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
		assertEquals(0, instance.size());
	}

	@Test
	public void testPopCorrectOrder() throws Exception {
		System.out.println("testPopCorrectOrder");
		MessageDatabase instance = new MessageDatabase(10);
		LocalDateTime now = LocalDateTime.now();
		TxtMessage m1, m2, m3, result;
		m1 = new TxtMessage();
		m2 = new TxtMessage();
		m3 = new TxtMessage();
		m1.body = "abc";
		m1.from = "def";
		m1.to = "ghi";
		m1.send = now.minusDays(1);
		m2.body = "abc";
		m2.from = "def";
		m2.to = "ghi";
		m2.send = now.minusDays(2);
		m3.body = "abc";
		m3.from = "def";
		m3.to = "ghi";
		m3.send = now.minusDays(3);
		// POP() should always return the oldest date that is older than the supplied date
		instance.add(m3);
		instance.add(m2);
		instance.add(m1);

		result = instance.pop(now);
		assertTrue(m3.equals(result));
		result = instance.pop(now);
		assertTrue(m2.equals(result));
		result = instance.pop(now);
		assertTrue(m1.equals(result));
	}

	@Test
	public void testMaxCapacity() throws Exception {
		System.out.println("testMaxCapacity");
		MessageDatabase instance = new MessageDatabase(1);
		LocalDateTime now = LocalDateTime.now();
		TxtMessage m1, m2;
		m1 = new TxtMessage();
		m2 = new TxtMessage();
		m1.body = "abc";
		m1.from = "def";
		m1.to = "ghi";
		m1.send = now.minusDays(1);
		m2.body = "abc";
		m2.from = "def";
		m2.to = "ghi";
		m2.send = now.minusDays(2);
		boolean bWasThrown = false;
		instance.add(m2);
		try {
			instance.add(m1);
		} catch (Exception ex) {
			System.out.println("Catch!!!");
			bWasThrown = true;
		}
		assertTrue(bWasThrown);
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

	@Test
	public void testReturnsNullWhenNothingOld() throws Exception {
		System.out.println("testReturnsNullWhenNothingOld");
		TxtMessage msg = new TxtMessage();
		msg.body = "test1";
		msg.from = "from";
		msg.to = "test1";
		msg.send = LocalDateTime.now().plusDays(3);
		MessageDatabase instance = new MessageDatabase(3);
		instance.add(msg);
		TxtMessage result = instance.pop(LocalDateTime.now());
		assertTrue(result == null);
		assertEquals(1, instance.size());
	}

	@Test
	public void testDbOrder() throws Exception {
		System.out.println("testDbOrder");
		MessageDatabase db = new MessageDatabase(4);
		TxtMessage m1 = new TxtMessage();
		m1.send = LocalDateTime.now();
		TxtMessage m2 = new TxtMessage();
		m2.send = LocalDateTime.now().minusHours(3);
		TxtMessage m3 = new TxtMessage();
		m3.send = LocalDateTime.now().minusHours(5);

		db.add(m3);
		db.add(m2);

		TxtMessage top = db.pop(LocalDateTime.now());
		assertTrue(top != null);
		assertEquals(m3, top);
	}

}
