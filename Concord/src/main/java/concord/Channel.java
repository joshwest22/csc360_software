package concord;

import java.util.ArrayList;

public class Channel
{
	String channelName;
	Group myGroup;
	Boolean isLocked = false;
	ArrayList<User> allowedUsers;
	ArrayList<Message> messageLog;
	
	public Channel(String channelName, Group myGroup, Boolean isLocked, ArrayList<User> allowedUsers,
			ArrayList<Message> messageLog)
	{
		this.channelName = channelName;
		this.myGroup = myGroup;
		this.isLocked = isLocked;
		this.allowedUsers = allowedUsers;
		this.messageLog = messageLog;
	}

	public String getChannelName()
	{
		return channelName;
	}

	public void setChannelName(String channelName)
	{
		this.channelName = channelName;
	}

	public Group getMyGroup()
	{
		return myGroup;
	}

	public void setMyGroup(Group myGroup)
	{
		this.myGroup = myGroup;
	}

	public Boolean getIsLocked()
	{
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked)
	{
		this.isLocked = isLocked;
	}

	public ArrayList<User> getAllowedUsers()
	{
		return allowedUsers;
	}

	public void setAllowedUsers(ArrayList<User> allowedUsers)
	{
		this.allowedUsers = allowedUsers;
	}

	public ArrayList<Message> getMessageLog()
	{
		return messageLog;
	}

	public void setMessageLog(ArrayList<Message> messageLog)
	{
		this.messageLog = messageLog;
	}
	
	public void sendNewMessage(Message m)
	{
		// TO DO
	}
	public ArrayList<Message> displayAllMessages()
	{
		// TO DO
		ArrayList<Message> allMsgs =
		null;
		return allMsgs;
	}
	public void lockChannel(Channel channel)
	{
		// TO DO
	}
}


