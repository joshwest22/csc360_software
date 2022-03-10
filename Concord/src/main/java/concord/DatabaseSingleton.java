package concord;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseSingleton
{
	HashMap<Integer, Group> groups;
	HashMap<Integer, Integer> users;
	
	public void createUser(String username, String realname, String password, Integer userID, URL userPic, String userBio, Boolean onlineStatus)
	{
		//create User and add to users HashMap
		Integer user = new Integer(username,realname,password,userID,userPic,userBio,onlineStatus,null);
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
					  if (!users.get(userID).getBlockedUsers().contains(m.sentBy))
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
	
}
