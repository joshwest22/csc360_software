package concord;

import java.net.URL;
import java.util.HashMap;

public class DatabaseSingleton
{
	HashMap<Integer, Group> groups;
	HashMap<Integer, User> users;
	
	public void createUser(String username, String realname, String password, Integer userID, URL userPic, String userBio, Boolean onlineStatus)
	{
		//create User and add to users HashMap
		User user = new User(username,realname,password,userID,userPic,userBio,onlineStatus,null);
		users.put(userID, user);
	}
	public void createGroup(Integer groupID, String groupName)
	{
		Group group = new Group(groupID, groupName);
		groups.put(groupID, group);
	}
	@SuppressWarnings("unlikely-arg-type")
	public void createChannel(String channelName, Integer userID, Integer groupID)
	{
		//check user contains userID
		if (users.containsKey(userID))
		{
			//check user's role through group's registeredUsers
			Boolean allowed = groups.get(groupID).getRegisteredUsers().get(userID).getCanCreateChannel();
			if (allowed)
			{
				//call Group's createChannel()
				groups.get(groupID).createChannel(channelName, groups.get(groupID));
			}
		}
	}
	@SuppressWarnings("unlikely-arg-type")
	public void messageReceived(String channelName, String msg, Integer userID, Integer groupID)
	{
		//package message in Message and send to role and then to messageLog
		Message m = new Message(msg,users.get(userID));
		Role r = groups.get(groupID).getRegisteredUsers().get(userID);
		for(Channel ch : r.getGroup().channels)
		{
			if (ch.channelName.equals(channelName))
			{
				r.sendMessage(m, ch);
			}
		}
	}
	public void viewChannel(String channelName, Integer userID, Integer groupID)
	{
		//check through all channels for the channel with channelName
		for (Channel i : groups.get(groupID).channels)
		{
			//call channel's displayAllMessages
			if (i.getChannelName() == channelName)
			{
				i.displayAllMessages(users, userID);
			}
		}
	}
	
}
