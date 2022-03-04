package concord;

import java.net.URL;

public class User
{
	private String username;
	private String realname;
	private String password;
	private Integer userID;
	private URL userPic;
	private String userBio;
	private Boolean onlineStatus;
	
	public User(String username, String realname, String password, Integer userID, URL userPic, String userBio,
			Boolean onlineStatus)
	{
		super();
		this.username = username;
		this.realname = realname;
		this.password = password;
		this.userID = userID;
		this.userPic = userPic;
		this.userBio = userBio;
		this.onlineStatus = onlineStatus;
	}
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getRealname()
	{
		return realname;
	}
	public void setRealname(String realname)
	{
		this.realname = realname;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public Integer getUserID()
	{
		return userID;
	}
	public void setUserID(Integer userID)
	{
		this.userID = userID;
	}
	public URL getUserPic()
	{
		return userPic;
	}
	public void setUserPic(URL userPic)
	{
		this.userPic = userPic;
	}
	public String getUserBio()
	{
		return userBio;
	}
	public void setUserBio(String userBio)
	{
		this.userBio = userBio;
	}
	public Boolean getOnlineStatus()
	{
		return onlineStatus;
	}
	public void setOnlineStatus(Boolean onlineStatus)
	{
		this.onlineStatus = onlineStatus;
	}
	
}
