package concord;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ChannelTest
{
	Group group = new Group(653,"testingGroup");
	ArrayList<Message> msgLog = new ArrayList<Message>();
	Channel channel = new Channel("main", group, false, null, msgLog);
	@BeforeAll
	static void setUp() throws Exception
	{
		
	}

	/*
	 * @Test void testChannelStringGroupBooleanArrayListOfUserArrayListOfMessage() {
	 * fail("Not yet implemented"); }
	 * 
	 * @Test void testChannelString() { fail("Not yet implemented"); }
	 */

	@Test
	void testSendNewMessage()
	{
		User lexie = new User("boss12", "lexie", "lexierulz7", 247, null, "im a boss", false, null);
		ArrayList<Message> mLog = new ArrayList<Message>();
		Message m = new Message("hi",lexie);
		mLog.add(m);
		channel.sendNewMessage(m);
		assertEquals(mLog, channel.getMessageLog());
	}

	/*
	 * @Test void testDisplayAllMessages() { //show that messageLog has some size
	 * //show that messageLog has a shorter size after user blocked //or tack on a
	 * msg that says blocked for now }
	 */


	@Test
	void testLockChannel()
	{
		channel.setIsLocked(false);
		assertEquals(false,channel.getIsLocked());
		channel.lockChannel();
		assertEquals(true,channel.getIsLocked());
	}

}
