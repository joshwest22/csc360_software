package concord;

public class Role
{
	private String roleName;
	private Group myGroup;
	private Boolean canKick;
	private Boolean canLockChannel;
	private Boolean canAssignRole;
	private Boolean canCreateChannel;
	
	public Role(String roleName, Group group, Boolean canKick, Boolean canLockChannel, Boolean canAssignRole,
			Boolean canCreateChannel)
	{
		super();
		this.roleName = roleName;
		this.myGroup = group;
		this.canKick = canKick;
		this.canLockChannel = canLockChannel;
		this.canAssignRole = canAssignRole;
		this.canCreateChannel = canCreateChannel;
	}
	
	public String getRoleName()
	{
		return roleName;
	}
	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}
	public Group getGroup()
	{
		return myGroup;
	}
	public void setGroup(Group group)
	{
		this.myGroup = group;
	}
	public Boolean getCanKick()
	{
		return canKick;
	}
	public void setCanKick(Boolean canKick)
	{
		this.canKick = canKick;
	}
	public Boolean getCanLockChannel()
	{
		return canLockChannel;
	}
	public void setCanLockChannel(Boolean canLockChannel)
	{
		this.canLockChannel = canLockChannel;
	}
	public Boolean getCanAssignRole()
	{
		return canAssignRole;
	}
	public void setCanAssignRole(Boolean canAssignRole)
	{
		this.canAssignRole = canAssignRole;
	}
	public Boolean getCanCreateChannel()
	{
		return canCreateChannel;
	}
	public void setCanCreateChannel(Boolean canCreateChannel)
	{
		this.canCreateChannel = canCreateChannel;
	}
	
	
	public String kickUser(User user)
	{
		//check permissions
		if (canKick)
		{
			//Call Group removeUser(user)
			myGroup.removeUser(user);
			String kickMsg = "User has been kicked.";
			return kickMsg;
		}
		else
		{
			String kickMsg = "You do not have permission to kick users.";
			return kickMsg;
		}
	}
	public String lockChannel(String channelName, Integer userID)
	{
		//for every channel
		for (Channel c : myGroup.channels)
		{
			//make sure this is correct channel
			if (c.getChannelName() == channelName)
			{
				c.setIsLocked(true); 
				//reset allowed users
				c.allowedUsers.clear();
				//only have user that locked channel in allowedList
				c.getAllowedUsers().add(userID);
				String lockMsg = "Channel has been locked.";
				return lockMsg;
			}
		}
		//channel was not found
		return "Channel name not found.";
	}
	public String sendMessage(Message m, Channel channel)
	{
		//pass along the message to the channel
		channel.sendNewMessage(m);
		String sentVerification = "Message "+m.getText()+" sent.";
		return sentVerification;
	}
	public String leaveGroup(User user, Integer groupID)
	{
		// user should only be the user calling this
		myGroup.removeUser(user);
		String leftNotice = user.getUsername() + " left the group.";
		return  leftNotice;
	}
	public String assignRole(User user, Role role)
	{
		myGroup.getRegisteredUsers().put(user,role);
		String roleMsg = "Role "+role+" has been assigned to "+user;
		return roleMsg;
	}
	public String createChannel(String channelName)
	{
		String channelCreatedMsg = "Channel "+channelName+" was created.";
		return channelCreatedMsg;
	}
	//Might need a view channel
}
