package concord;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Database
{
	HashMap<Integer, Group> groups;
	HashMap<Integer, User> users;
	//alternate constructor
	public Database(HashMap<Integer, Group> groups, HashMap<Integer, User> users)
	{
		this.groups = groups;
		this.users = users;
	}
	public Database()
	{
		HashMap<Integer, Group> groups = new HashMap<Integer, Group>();
		HashMap<Integer, User> users = new HashMap<Integer, User>();
		this.groups = groups;
		this.users = users;
	}
	
	public HashMap<Integer, Group> getGroups()
	{
		return groups;
	}
	public void setGroups(HashMap<Integer, Group> groups)
	{
		this.groups = groups;
	}
	public HashMap<Integer, User> getUsers()
	{
		return users;
	}
	public void setUsers(HashMap<Integer, User> users)
	{
		this.users = users;
	}
	
	public void createUser(String username, String realname, String password, Integer userID, URL userPic, String userBio, Boolean onlineStatus)
	{
		//create User and add to users HashMap
		User user = new User(username,realname,password,userID,userPic,userBio,onlineStatus);
		users.put(userID, user);
	}
	public void createGroup(Integer groupID, String groupName)
	{
		Group group = new Group(groupID, groupName);
		HashMap<User,Role> regUsers = new HashMap<User,Role>();
		group.registeredUsers = regUsers;
		groups.put(groupID, group);
	}
	public void createChannel(String channelName, Integer userID, Integer groupID)
	{
		//check user contains userID
		if (users.containsKey(userID))
		{
			//check user's role through group's registeredUsers
			Boolean allowed = this.getRole(groupID, userID).getCanCreateChannel();
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
					  //if message not sent by blocked user, add it to clearedMsgList
					  if (!getUser(userID).getBlockedUserIDs().contains(m.sentByUserID))
					  {
						  clearedMsgList.add(m);
					  }
				  }
				  return clearedMsgList;
			}
		}
		ArrayList<Message> emptyList = new ArrayList<Message>();
		return emptyList;
	}
	public void blockUser(Integer blockerID, Integer blockeeID)
	{
		users.get(blockerID).blockUser(blockeeID);
	}
	public void unblockUser(Integer unblockerID, Integer unblockeeID)
	{
		users.get(unblockerID).unblockUser(unblockeeID);
	}
//	public void lockChannel(String channelName, User user)
//	{
//		
//	}
	public User getUser(Integer userID)
	{
		User user = users.get(userID);
		return user;
	}
	public Role getRole(Integer groupID, Integer userID)
	{
		Role role = groups.get(groupID).getRegisteredUsers().get(users.get(userID));
		return role;
	}
	
}
