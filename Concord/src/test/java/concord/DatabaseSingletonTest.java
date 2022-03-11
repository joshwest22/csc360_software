package concord;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.lang.Integer;
class DatabaseSingletonTest
{
	static URL url;
	static User overlord;
	static User josh;
	static User satan;
	static Role basic;
	static HashMap<Integer,User> users;
	@BeforeAll
	static void setUp() throws Exception
	{
		url = new URL("http://google.com");
		josh = new User("jdubble","josh","password",42,url,"I like butterflies",false);
		overlord = new User("OVLawd","owen","overwatch22",555,url,"As above...",false);
		satan = new User("d3vil","lucifer","hellonearth",666,url,"I hate butterflies",false);
		users = new HashMap<Integer,User>();
		users.put(josh.getUserID(), josh);
		users.put(overlord.getUserID(), overlord);
		users.put(satan.getUserID(), satan);
	}

	@Test
	void testCreateUser() throws MalformedURLException
	{
		ArrayList<Integer> blockedList = new ArrayList<Integer>();
		blockedList.add(satan.getUserID());
		josh.setBlockedUsers(blockedList );
		assertEquals(josh.getUsername(),"jdubble");
		assertEquals(josh.getRealname(),"josh");
		assertEquals(josh.getPassword(),"password");
		assertEquals(josh.getUserID(),42);
		assertEquals(josh.getUserPic(),url);
		assertEquals(josh.getUserBio(),"I like butterflies");
		assertEquals(josh.getOnlineStatus(),false);
		assertEquals(josh.getBlockedUserIDs(),blockedList);
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

//	@Test
//	void testMessageReceived()
//	{
//		messageReceived(channelName, msg, userID, groupID);
//	}

	@Test
	void testViewChannel()
	{
		//make new group
		
		Group chgroup = new Group(48,"testCreateChannelGroup");
		Role admin = new Role("admin",chgroup , true, true, true, true);
		chgroup.registeredUsers.put(overlord,admin);
		chgroup.addNewUser(overlord, josh, admin);
		chgroup.addNewUser(overlord,satan, admin);
		//have satan send msgs
		chgroup.createChannel("channel1", chgroup);
		Message m = new Message("Hell is freezing over.",666);
		admin.sendMessage(m,chgroup.getChannels().get(0));
		//test messageReceived
		//chgroup.channels.get(0).displayAllMessages(userID);
		//check length of msg log
		Channel channel1 = chgroup.getChannels().get(0);
		int channelSize = channel1.getMessageLog().size();
		assertEquals(channelSize,1);
		//block satan
		josh.blockUser(satan.getUserID());
		//show length doesnt change
		Message secondMsg = new Message("Hell is really hot.",666);
		admin.sendMessage(secondMsg, channel1); //should not send bc blocked
		assertEquals(channel1.getMessageLog().size(),2);
		assertEquals(josh.getBlockedUserIDs().get(0),satan.getUserID());
	}

}
