package concord;

public class Role
{
	private String roleName;
	private Group group;
	private Boolean canKick;
	private Boolean canLockChannel;
	private Boolean canAssignRole;
	private Boolean canCreateChannel;
	
	public Role(String roleName, Group group, Boolean canKick, Boolean canLockChannel, Boolean canAssignRole,
			Boolean canCreateChannel)
	{
		super();
		this.roleName = roleName;
		this.group = group;
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
		return group;
	}
	public void setGroup(Group group)
	{
		this.group = group;
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
			group.removeUser(user);
			String kickMsg = "User has been kicked.";
			return kickMsg;
		}
		else
		{
			String kickMsg = "You do not have permission to kick users.";
			return kickMsg;
		}
	}
	public String lockChannel(Channel channel)
	{
		channel.setIsLocked(true);
		//TODO update allowed users
		/*
		 * ArrayList<User> uesrList = new ArrayList<User>(); for (entry :
		 * group.registeredUsers) { userList.add(entry); }
		 * channel.setAllowedUsers(userList);
		 */
		String lockMsg = "Channel has been locked.";
		return lockMsg;
	}
	public String sendMessage(Message m, Channel channel)
	{
		//pass along the message to the channel
		channel.sendNewMessage(m);
		String sentVerification = "Message "+m.getText()+" sent.";
		return sentVerification;
	}
	public String leaveGroup(User user)
	{
		// user should only be the user calling this
		group.removeUser(user);
		String leftNotice = user.getUsername() + " left the group.";
		return  leftNotice;
	}
	public String assignRole(User user, Role role)
	{
		group.getRegisteredUsers().put(user,role);
		String roleMsg = "Role "+role+" has been assigned to "+user;
		return roleMsg;
	}
	public String createChannel(String channelName)
	{
		String channelCreatedMsg = "Channel "+channelName+" was created.";
		return channelCreatedMsg;
	}
}
