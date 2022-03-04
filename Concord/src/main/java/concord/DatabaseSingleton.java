package concord;

import java.util.HashMap;

public class DatabaseSingleton
{
	HashMap<Integer, Group> groups;
	HashMap<Integer, User> uesrs;
	
	public void createUser()
	{
		//TO DO
	}
	public void createGroup(Integer userID, String groupName)
	{
		//TO DO
	}
	public void createChannel(String channelName, Integer userID, Integer groupID)
	{
		//TO DO
	}
	public void messageReceived(String channelName, String msg, Integer userID, Integer groupID)
	{
		//TO DO
	}
	public void viewChannel(String channelName, Integer userID, Integer groupID)
	{
		//TO DO
	}
	
}
