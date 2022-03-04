package concord;

public class Message
{
	String text;
	Boolean isPinned = false;
	User sentBY;
	Message inReplyTo;
	
	public Message(String text, Boolean isPinned, User sentBY, Message inReplyTo)
	{
		this.text = text;
		this.isPinned = isPinned;
		this.sentBY = sentBY;
		this.inReplyTo = inReplyTo;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public Boolean getIsPinned()
	{
		return isPinned;
	}

	public void setIsPinned(Boolean isPinned)
	{
		this.isPinned = isPinned;
	}

	public User getSentBY()
	{
		return sentBY;
	}

	public void setSentBY(User sentBY)
	{
		this.sentBY = sentBY;
	}

	public Message getInReplyTo()
	{
		return inReplyTo;
	}

	public void setInReplyTo(Message inReplyTo)
	{
		this.inReplyTo = inReplyTo;
	}
	
	
	public void isReply()
	{
		// TO DO
	}
	public void isPinned()
	{
		// TO DO
	}
}
