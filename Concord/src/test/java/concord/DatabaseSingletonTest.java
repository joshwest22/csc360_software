package concord;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatabaseSingletonTest
{
	URL url;
	User josh;
	User satan;
	@BeforeEach
	void setUp() throws Exception
	{
		url = new URL("http://google.com");
		User josh = new User("jdubble","josh","password",42,url,"I like butterflies",false,null);
		User satan = new User("d3vil","lucifer","hellonearth",666,url,"I hate butterflies",false,null);
	}

	@Test
	void testCreateUser() throws MalformedURLException
	{
		ArrayList<User> blockedList = new ArrayList<User>();
		blockedList.add(satan);
		josh.setBlockedUsers(blockedList );
		assertEquals(josh.getUsername(),"jdubble");
		assertEquals(josh.getRealname(),"josh");
		assertEquals(josh.getPassword(),"password");
		assertEquals(josh.getUserID(),42);
		assertEquals(josh.getUserPic(),url);
		assertEquals(josh.getUserBio(),"I like butterflies");
		assertEquals(josh.getOnlineStatus(),false);
		assertEquals(josh.getBlockedUsers(),blockedList);
	}

	@Test
	void testCreateGroup()
	{
		Group group5 = new Group(5, "testCreateGroup");
		assertEquals(group5.getGroupID(),5);
		assertEquals(group5.getGroupName(),"testCreateGroup");
	}

	@Test
	void testCreateChannel()
	{
		Group chgroup = new Group(47,"testCreateChannelGroup");
		chgroup.createChannel("testChannel",chgroup);
		Channel ch = chgroup.getChannels().get(0);
		assertEquals(ch.getChannelName(),"testChannel");
		//confirm that 2 channels can be created in one group
		chgroup.createChannel("testChannel1",chgroup);
		Channel chan = chgroup.getChannels().get(1);
		assertEquals(chan.getChannelName(),"testChannel1");
	}

	@Test
	void testMessageReceived()
	{
		messageReceived(channelName, msg, userID, groupID);
	}

	@Test
	void testViewChannel(String channelName, Integer userID,Integer groupID)
	{
		//make new group
		//have enemy send msgs
		//check lenght of msg log
		//block enemy
		//show length changes		
	}

}
