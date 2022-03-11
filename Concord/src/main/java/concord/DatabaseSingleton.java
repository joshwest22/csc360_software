package concord;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseSingleton
{
	HashMap<Integer, Group> groups;
	HashMap<Integer, User> users;
	
	public void createUser(String username, String realname, String password, Integer userID, URL userPic, String userBio, Boolean onlineStatus)
	{
		//create User and add to users HashMap
		User user = new User(username,realname,password,userID,userPic,userBio,onlineStatus);
		users.put(userID, user);
	}
	public void createGroup(Integer groupID, String groupName)
	{
		Group group = new Group(groupID, groupName);
		groups.put(groupID, group);
	}
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
	public void messageReceived(String channelName, String msg, Integer userID, Integer groupID)
	{
		//package message in Message and send to role and then to messageLog
		Message m = new Message(msg,userID);
		Role r = groups.get(groupID).getRegisteredUsers().get(userID);
		for(Channel ch : r.getGroup().channels)
		{
			if (ch.channelName.equals(channelName))
			{
				r.sendMessage(m, ch);
			}
		}
	}
	public ArrayList<Message> viewChannel(String channelName, Integer userID, Integer groupID)
	{
		ArrayList<Message> emptyList = new ArrayList<Message>();
		//check through all channels for the channel with channelName
		for (Channel c : groups.get(groupID).channels)
		{
			
			//call channel's displayAllMessages
			if (c.getChannelName() == channelName)
			{
				ArrayList<Message> msgLog = c.getMessageLog();
				ArrayList<Message> clearedMsgList = new ArrayList<Message>();
				  for (Message m : msgLog)
				  {
					  if (!users.get(userID).getBlockedUserIDs().contains(m.sentByUserID))
					  {
						  clearedMsgList.add(m);
					  }
				  }
				  return clearedMsgList;
			}
		}
		return emptyList;
		
		
	}
	public void blockUser(Integer blockerID, Integer blockeeID)
	{
		users.get(blockerID).blockUser(blockeeID);
	}
	public void unblockUser(Integer unblockerID, Integer unblockeeID)
	{
		users.get(unblockerID).blockUser(unblockeeID);
	}
	public void lockChannel(String channelName, User user)
	{
		
	}
	public User getUser(Integer userID)
	{
		User user = users.get(userID);
		return user;
	}
	
}
