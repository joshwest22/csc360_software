package concord;

import java.net.MalformedURLException;
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
	
	//basic role with no permissions except sendMessage
	Role basic = new Role("basic",this,false,false,false,false);
	
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
	//alternate constructor
	public Group(Integer groupID, String groupName)
	{
		this.channels = new ArrayList<Channel>();
		this.registeredUsers = new HashMap<User, Role>();
		this.description = "default description; please set me";
		try
		{
			this.logo = new URL("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAQwAAAC8CAMAAAC672BgAAABGlBMVEX///9YrjnF1vPr6+vk5OSdnZ3D1POvsLHI2fTt9P7l6O/k7fzu7u7n7/rV4vd6eXx+h3tul2DKzNBgpUjc6PvS4fn5+fmWlpfR3vOJiYqgoKH1+P3CytewsrbV2d+RkZLV1dXA1Oxcr0Hy+fDExMW3t7i70uSyztabxq55unKoycaorbW8xNN8v2P6/fmqq6vKz9nI0uO7vsPV3u2zzdmnycOaxqyiyLqOv5mBuoN8uXmHvYxhrUtqs1pztWi30dKRxI611rnb6eeMxXu4267R6Mmo1Jjh8NzG47tzu1nF39HO4eiGxHCjz5yo0LGrvLuVo5mataKNn4yMr4qDo359rnV2r2rG1sCEl4GTvIWrtKeTqYt6nG69x7rFCBnUAAAEX0lEQVR4nO3a61/aVhzHcTUgsFy6UUjC1QAJNy1RRFAuYgdIrdZZq1u7dv//v7HfOQmFeNserPpazvf9pC8hD5LP63eSE+3aGgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADAf0OPPE1S9Jc+xeejGNEnxZKSLkwOJZp13dgjXDcbswUaDooRaycf0Y5FXce2IqLUoBhO8qdHJJ0oDY4jzEqhGO2imniQWqQYbkyc2WAxdlVVle+hD4sFNjdW0k5akgg1eAxZTj1AlncLUdeWJMuh26gIs6EYFIOuXGNYABZG837apxixpKJHbLZSBHiosBh5uvw0k5L5rcL7SUtp+YLBYigRy7IpR+hvoxSjkNdS6XScrl9OsI9yspdGM/PbhsseJbpiOa5tKcpLn+0P9j0GGwU1xz7KqawGxWExso5Fm3LLjtH2y7JCPhpeDM1bIzkeQ8/l1NQihpH19qJRgzYcTshHg95N/BjeWHhyqraIYfCXF/5PNiq93Ik+By8Ge5Am7sfY2yksuTQdYsRQ/SXiYzHiadPc390tLiSdrBgxaCz0FeyBEo/HTTPFN6KEnrjFtiAxUv41L8h0A2U1/G2YtzcXJcY9vAUtFL4t5VtzeVeAGFve0yT+IHrImKa/U6cYW+GPsZ03H4vhB+E7srwQMQp5M/1EDL8IvagIEMPY5jE2nsJi7LVjbth3oF6M+D/EiKe1/WIyGfZ3k38Vg0ZDk9Xwv7X6MVavvMQFYqS1wHY9pFiMHRZjc4FiVJlSaXP5WVoO7tfD6U4MPhadGulUSxubi0TxVOKlT/Q5BGKUStXO+KDXq3e79XrvoFnzxoPdMMI/FmvLGHwAqp1m7/Co32+Q/tHgsN7sUI0NU1YFWCNEWolR6jTrg+Nh2TMcHR9RjWopnvJLhP4XwlJmEaNarfW6g/6ovO5hNQbd3njf/9WoLkUiIa8hZba8GKUajUV/NFy0WPeG4+Ttr/4zNWI5Yd+Bfo9RbdYPl2OxGI7hZDr3DtQjdjTs7yZeDJPWSHfQGA0DLdbPLibTWYUdlsslim0jI0aMWrNHt87hncF4czqbV1rssJwq5wuCxDgf9w4bo+BYlMtnk3d8LFqtVkLWdrbFiLE35vfOYIuzyel0zsaiNZ+9fX/O/ogiQoz2+Xuai7tr5GJKa4QdUpl9OLkcm2JMhvvb+PJoVC4H54LuF3wsKpXZtHE86J2LMRlXHy9PGsG5KL+ZnL7ja4RSnE5Go/5h7+BqS4AY15+OGnc2GHTr9B8j8+nFGW3QR/0Pn64FiJH5fHP7+/HrFaMzf6ulK9IfX/hXx7cDMWL8/Pnm5tsvS7dfTv2tlmTZf37lX327+Xp9lQl9jFcZyhFw9de8wteIHnGM5Xd0XPhj3GPY/vuYbrmZ1S8yryIve7I/mi7ds/xffXTPCAr5KzwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAwP/a38wtqoLPT/bDAAAAAElFTkSuQmCC");
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.groupID = groupID;
		this.groupName = groupName;
		
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
	
	
	public void addNewUser(User adder, User addee, Role role)
	{
		//adds user to registeredUsers as key and role as value
		if (registeredUsers.get(adder).getCanAssignRole() == true)
		{
			registeredUsers.put(addee,registeredUsers.get(addee));
		}
		
	}
	public void removeUser(User user)
	{
		registeredUsers.remove(user); 
	}
	public Integer getUserCount() 
	{
		return registeredUsers.size();
	}
	public void inviteUser(User inviter, User invitee, Role role)
	{
		//Directly add user with basic permissions/role
		this.addNewUser(inviter, invitee, role);
	}
	public void createChannel(String channelName, Group myGroup)
	{
		Channel newChannel = new Channel(channelName, myGroup);
		channels.add(newChannel);
	}
	public HashMap<User,Role> viewAllMembers()
	{
		//allows users to see all members of a server; alias for getRegisteredUsers()
		return registeredUsers;
	}
}
