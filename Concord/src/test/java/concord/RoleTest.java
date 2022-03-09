package concord;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RoleTest
{
	static Role basic;
	static Role admin;
	static Group testGroup;
	static User noob;
	static User expert;
	static URL pfp;
	static Channel channel;
	static ArrayList<Message> msgLog;
	@BeforeAll
	static void setUp() throws Exception
	{
		testGroup = new Group (42,"testGroup");
		pfp = new URL("http://google.images");
		basic = new Role("basic",testGroup,false,false,false,false);
		admin = new Role("admin",testGroup,true,true,true,true);
		noob = new User("n008", "noob", "123", 63, pfp, "I'm new here", false, null);
		expert = new User("Hexpert","Hector Spurt","asdfJkhlu124~",1337,pfp,"I run this place",false,null);
		testGroup.addNewUser(noob, basic);
		testGroup.addNewUser(expert, admin);
		channel = new Channel("testChannel", testGroup);
		msgLog = new ArrayList<Message>();
		channel.setMessageLog(msgLog);
	}

	@Test
	void testRole()
	{
		assertEquals("admin",admin.getRoleName());
		assertEquals(testGroup,admin.getGroup());
		assertEquals(true,admin.getCanKick());
		assertEquals(true,admin.getCanLockChannel());
		assertEquals(true,admin.getCanAssignRole());
		assertEquals(true,admin.getCanCreateChannel());
	}

	@Test
	void testKickUser()
	{
		assertEquals(basic.kickUser(expert),"You do not have permission to kick users.");
		assertEquals(admin.kickUser(noob),"User has been kicked.");
	}

	@Test
	void testLockChannel()
	{
		
		channel.setIsLocked(false);
		assertEquals(false,channel.getIsLocked());
		channel.lockChannel();
		assertEquals(true,channel.getIsLocked());
	}

	@Test
	void testSendMessage()
	{
		Message m = new Message("hello", noob);
		basic.sendMessage(m, channel);
		assertEquals("hello",channel.messageLog.get(0).getText());
	}

	@Test
	void testLeaveGroup()
	{
		//leaving is allowed for any user of any permission, but if a user calls it for themselves
		assertEquals(basic.leaveGroup(noob),"n008 left the group.");
		assertEquals(admin.leaveGroup(expert),"Hexpert left the group.");
	}

	@Test
	void testAssignRole()
	{
		User bill = new User("bigbill", "william", "741aaa", 70, pfp, "I am Bill. Hear me roar.", false, null);
		testGroup.addNewUser(bill, basic);
		assertEquals("basic",testGroup.getRegisteredUsers().get(bill).getRoleName());
		admin.assignRole(bill, admin);
		assertEquals("admin",testGroup.getRegisteredUsers().get(bill).getRoleName());
	}

}
