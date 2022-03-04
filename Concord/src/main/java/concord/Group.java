package concord;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Group
{
	ArrayList<Channel> channels;
	HashMap<User,Role> registeredUsers;
	String description;
	URL logo;
	String groupName;
	Integer groupID;
	
	public Group(ArrayList<Channel> channels, HashMap<User, Role> registeredUsers, String description, URL logo,
			String groupName, Integer groupID)
	{
		this.channels = channels;
		this.registeredUsers = registeredUsers;
		this.description = description;
		this.logo = logo;
		this.groupName = groupName;
		this.groupID = groupID;
	}

	public ArrayList<Channel> getChannels()
	{
		return channels;
	}

	public void setChannels(ArrayList<Channel> channels)
	{
		this.channels = channels;
	}

	public HashMap<User, Role> getRegisteredUsers()
	{
		return registeredUsers;
	}

	public void setRegisteredUsers(HashMap<User, Role> registeredUsers)
	{
		this.registeredUsers = registeredUsers;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public URL getLogo()
	{
		return logo;
	}

	public void setLogo(URL logo)
	{
		this.logo = logo;
	}

	public String getGroupName()
	{
		return groupName;
	}

	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}

	public Integer getGroupID()
	{
		return groupID;
	}

	public void setGroupID(Integer groupID)
	{
		this.groupID = groupID;
	}
	
	
	public void addNewUser()
	{
		// TODO
	}
	public void removeUser()
	{
		// TODO
	}
	public void getUserCount()
	{
		// TODO
	}
	public void inviteUser()
	{
		// TODO
	}
	public void createChannel(String channelName)
	{
		// TODO
	}
}
