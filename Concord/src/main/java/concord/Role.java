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
		String kickMsg = "User has been kicked.";
		//Add if statement or try catch if kick fails due to permissions
		return kickMsg;
	}
	public String lockChannel(Channel channel)
	{
		String lockMsg = "Channel has been locked.";
		return lockMsg;
	}
	public String sendMessage(Message m, Channel channel)
	{
		String sentVerification = "Message sent.";
		return sentVerification;
	}
	public String leaveGroup(User user)
	{
		String leftNotice = user + " left the group.";
		return  leftNotice;
	}
	public String assignRole(User user, Role role)
	{
		String roleMsg = "Role "+role+" has been assigned to "+user;
		return roleMsg;
	}
	public String createChannel(String channelName)
	{
		String channelCreatedMsg = "Channel "+channelName+" was created.";
		return channelCreatedMsg;
	}
}
