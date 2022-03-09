package concord;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest
{
	URL url ;
	@BeforeEach
	void setUp() throws Exception
	{
	}

	@Test
	void testUser()
	{
		try
		{
			url = new URL("http://google.com");
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User john = new User("johnny129", "john", "johnboss921!", 11, url, "witty comment", false,null);
		assertEquals(john.getUsername(),"johnny129");
		assertEquals(john.getRealname(),"john");
		assertEquals(john.getPassword(),"johnboss921!");
		assertEquals(john.getUserID(),11);
		assertEquals(john.getUserPic(),url);
		assertEquals(john.getUserBio(),"witty comment");
		assertEquals(john.getOnlineStatus(),false);
		
	}

	@Test
	void testGetUsername()
	{
		try
		{
			url = new URL("http://google.com");
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User john = new User("johnny129", "john", "johnboss921!", 11, url, "witty comment", false,null);
		assertEquals(john.getUsername(),"johnny129");
	}

	@Test
	void testSetUsername()
	{
		try
		{
			url = new URL("http://google.com");
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User john = new User("johnny129", "john", "johnboss921!", 11, url, "witty comment", false,null);
		john.setUsername("johnny130");
		assertEquals(john.getUsername(),"johnny130");
	}
	
	@Test 
	void testBlockUser(User blockee)
	{
		User jim = new User("jimmy129", "jim", "jimbo10", 10, url, "slim jim", false,null);
		User satan = new User("d3vil", "lucifer", "badboy99", 666, url, "angry comment", false,null);
		ArrayList<User> blockList = new ArrayList<User>();
		blockList.add(satan);
		jim.blockUser(satan);
		assertEquals(jim.getBlockedUsers(),blockList); //check if blocked list matches
	}
	
	@Test 
	void testUnblockUser(User blockee)
	{
		User john = new User("jimmy129", "jim", "jimbo10", 10, url, "slim jim", false,null);
		User satan = new User("d3vil", "lucifer", "badboy99", 666, url, "angry comment", false,null);
		ArrayList<User> blockList = new ArrayList<User>();
		blockList.add(satan);
		john.blockUser(satan);
		assertEquals(john.getBlockedUsers(),blockList); //check if blocked list matches
		//unblock
		john.unblockUser(satan);
		blockList.remove(satan);
		assertEquals(john.getBlockedUsers(),blockList);
	}

}
