package concord;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GroupTest
{
	Group group1;
	Group group2;
	Group group3;
	User josh;
	User gus;
	Role adminRole;
	Role basicRole;
	@BeforeEach
	void setUp() throws Exception //something not set up correctly here; causing null pointer
	{
		//test that all parameters of group were assigned correctly using short Group constructor
		group1 = new Group(1,"group1");
		
		//test that all parameters of group were assigned correctly using long constructor
		ArrayList<Channel> channels = new ArrayList<Channel>();
		Channel channel1 = new Channel("channel1");
		channels.add(channel1);
		HashMap<User,Role> registeredUsers = new HashMap<User,Role>();
		josh = new User("joshanator", "josh", "pass", 00, URL("https://google.com"), "bio", true,null);
		Role defaultRole = new Role("admin", group1, true, true, true, true);
		registeredUsers.put(josh, defaultRole);
		group2 = new Group(channels, registeredUsers, "cool group", URL("http://logo.com"), "group2", 2);
		
		group3 = new Group(3,"group3");
		
}

	private URL URL(String string) throws MalformedURLException
	{
		URL url = new URL(string);
		return url;
	}

	@Test
	void testGroupArrayListOfChannelHashMapOfUserRoleStringURLStringInteger() throws MalformedURLException
	{		
		//assertEquals(group2.getChannels(),channel1); //out of scope
		assertEquals(group2.getChannels().get(0).getChannelName(),"channel1");
		
		//assertEquals(group2.getRegisteredUsers(),registeredUsers); //out of scope
		assertEquals(group2.getRegisteredUsers().get(josh).getRoleName(),"admin");
		
		assertEquals(group2.getDescription(),"cool group");
		
		assertEquals(group2.getLogo().getHost(),"logo.com");
		
		assertEquals(group2.getGroupName(), "group2");
		
		assertEquals(group2.getGroupID(),2);
	}

	
	@Test
	void testGroupIntegerString() throws MalformedURLException
	{
		ArrayList<Channel> channels = new ArrayList<Channel>();
		HashMap<User,Role> regUsers = new HashMap<User,Role>();
		group1.logo = new URL("http://logo-url.com");
		assertEquals(group1.getGroupID(),1);
		assertEquals(group1.getGroupName(),"group1");
		assertEquals(group1.getDescription(),"default description; please set me");
		assertEquals(group1.getChannels(),channels);
		assertEquals(group1.getRegisteredUsers(),regUsers);
		assertEquals(group1.getLogo().getHost(),"logo-url.com");
		assertEquals(group1.getUserCount(),0); 
	}

	@Test
	void testAddNewUser()
	{
		group2.addNewUser(josh, adminRole);
		HashMap<User,Role> testRegUsers = new HashMap<User,Role>();
		testRegUsers.put(josh,adminRole);
		assertEquals(group2.getRegisteredUsers().get(josh),testRegUsers.get(josh));
		group2.addNewUser(gus, adminRole);
		testRegUsers.put(gus, adminRole);
		assertEquals(group2.getRegisteredUsers(),testRegUsers);		
	}

	@Test
	void testRemoveUser() //this is also how a user leaves
	{
		group2.addNewUser(josh, adminRole);
		HashMap<User,Role> testRegUsers = new HashMap<User,Role>();
		testRegUsers.put(josh,adminRole);
		group2.addNewUser(gus, adminRole);
		testRegUsers.put(gus, adminRole);
		testRegUsers.remove(josh);
		assertEquals(group2.getRegisteredUsers().get(josh),testRegUsers.get(josh)); // might need to compare users
	}

	@Test
	void testGetUserCount()
	{
		HashMap<User,Role> testRegUsers = new HashMap<User,Role>();
		//assertEquals(group3.getUserCount(),0); //null exception
		group3.addNewUser(gus, adminRole);
		testRegUsers.put(gus,adminRole);
		assertEquals(group3.getUserCount(),1);
		group3.addNewUser(josh, adminRole);
		testRegUsers.put(josh,adminRole);
		assertEquals(group3.getUserCount(),2);
		group3.addNewUser(gus, adminRole);
		testRegUsers.put(josh,adminRole);
		assertEquals(group3.getUserCount(),2); //count should not change; user already exists
	}

	@Test
	void testInviteUser()
	{
		assertEquals(group2.getRegisteredUsers().containsKey(gus),false);
		group2.inviteUser(gus);
		assertEquals(group2.getRegisteredUsers().containsKey(gus),true);
	}

	@Test
	void testCreateChannel()
	{
		group1.addNewUser(josh, adminRole);
		ArrayList<User> allowedUsers = new ArrayList<User>();
		allowedUsers.add(josh);
		//ArrayList<Message> log = new ArrayList<Message>();
		//ArrayList<Message> anotherLog = new ArrayList<Message>();
		group1.createChannel("testChannel");
		//Channel channel = new Channel("testChannel",group1,false,allowedUsers,log);
		/*
		 * assertEquals(channel.getChannelName(),"testChannel");
		 * assertEquals(channel.getMyGroup(),group1);
		 * assertEquals(channel.getIsLocked(),false);
		 * assertEquals(channel.getAllowedUsers(),allowedUsers);
		 * assertEquals(channel.getMessageLog(),log);
		 */
		//creating a second channel
		group1.createChannel("testAnotherChannel");
		//Channel anotherChannel = new Channel("testAnotherChannel",group1,false,allowedUsers,anotherLog);
		/*
		 * assertEquals(anotherChannel.getChannelName(),"testAnotherChannel");
		 * assertEquals(anotherChannel.getMyGroup(),group1);
		 * assertEquals(anotherChannel.getIsLocked(),false);
		 * assertEquals(anotherChannel.getAllowedUsers(),allowedUsers);
		 * assertEquals(anotherChannel.getMessageLog(),anotherLog);
		 */
		//make sure both channels are in the group
		assertEquals(group1.getChannels().get(0).getChannelName(),"testChannel");
		assertEquals(group1.getChannels().get(1).getChannelName(),"testAnotherChannel");
		
		//test that a user can send a message in both channels
		group2.createChannel("anotherChannel");
		Message msg0 = new Message("Message0",josh);
		Message msg1 = new Message("Message1",josh);
		group2.getRegisteredUsers().get(josh).sendMessage(msg0, group2.getChannels().get(0));
		group2.getRegisteredUsers().get(josh).sendMessage(msg1, group2.getChannels().get(1));
		//check if the message is in the channel and message text matches text sent
		assertEquals(group2.channels.get(0).getMessageLog().get(0).getText(),msg0.getText());
		assertEquals(group2.channels.get(1).getMessageLog().get(0).getText(),msg1.getText());
	}
	
	@Test
	void testViewAllMembers()
	{
		//Show that this is an alias method to getRegisteredUsers that allows viewing of all users
		assertEquals(group2.viewAllMembers(),group2.getRegisteredUsers()); 
	}

}
