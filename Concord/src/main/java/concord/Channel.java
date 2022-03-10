package concord;

import java.util.ArrayList;
import java.util.HashMap;

public class Channel
{
	String channelName;
	Group myGroup;
	Boolean isLocked = false;
	ArrayList<Integer> allowedUsers;
	ArrayList<Message> messageLog;
	
	public Channel(String channelName, Group myGroup, Boolean isLocked, ArrayList<Integer> allowedUsers,
			ArrayList<Message> messageLog)
	{
		this.channelName = channelName;
		this.myGroup = myGroup;
		this.isLocked = isLocked;
		this.allowedUsers = allowedUsers;
		this.messageLog = messageLog;
	}

	public Channel(String channelName, Group myGroup)
	{
		//a constructor that just assigns the channel name on creation and set everything else to defaults
		this.channelName = channelName;
		this.myGroup = myGroup;
		this.isLocked = false;
		this.allowedUsers = new ArrayList<Integer>();
		this.messageLog = new ArrayList<Message>();
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

	public ArrayList<Integer> getAllowedUsers()
	{
		return allowedUsers;
	}

	public void setAllowedUsers(ArrayList<Integer> allowedUsers)
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
		//add Message to messageLog
		messageLog.add(m);
	}
	public ArrayList<Message> displayAllMessages(HashMap<Integer, Integer> users, Integer userID)
	{
		//String strMsgs = messageLog.toString(); //leaving this in case I want to return string version of msgs
		for (Message m : this.messageLog)
		{
			for (Integer u : users.get(userID).getBlockedUsers())
			{
				if (m.getSentBy().equals(u))
				{
					m.setText("BLOCKED TEXT FOLLOWS: "+m.getText());
				}
			}				
		}
		return getMessageLog();
		
	}
	/*
	 * @Override public String toString() { return "Channel [channelName=" +
	 * channelName + ", myGroup=" + myGroup + ", isLocked=" + isLocked +
	 * ", allowedUsers=" + allowedUsers + ", messageLog=" + messageLog +
	 * ", getMessageLog()=" + getMessageLog() + ", displayAllMessages()=" +
	 * displayAllMessages() + "]"; }
	 */

	public void lockChannel(String channelName, User user)
	{
		setIsLocked(true);
		//remove blacklisted users from allowedUsers
		/*
		 * for (User u : blacklist) { allowedUsers.remove(u); }
		 */
	}
}


