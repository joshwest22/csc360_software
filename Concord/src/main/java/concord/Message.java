package concord;

import java.sql.Timestamp;
import java.time.Instant;

public class Message
{
	String text;
	Timestamp timestamp;
	Boolean isPinned = false;
	User sentBy;
	Message inReplyTo;
	
	public Message(String text, Timestamp timestamp, Boolean isPinned, User sentBy, Message inReplyTo)
	{
		this.text = text;
		this.timestamp = timestamp;
		this.isPinned = isPinned;
		this.sentBy = sentBy;
		this.inReplyTo = inReplyTo;
	}
	//alternate constructor
	public Message(String msg, User user)
	{
		this.text = msg;
		this.timestamp = Timestamp.from(Instant.now());
		this.sentBy = user;
		this.isPinned = false;
		this.inReplyTo = null;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public Timestamp getTimestamp()
	{
		return timestamp;
	}
	
	public void setTimestamp(Timestamp timestamp)
	{
		this.timestamp = timestamp;
	}
	
	public Boolean getIsPinned()
	{
		return isPinned;
	}

	public void setIsPinned(Boolean isPinned)
	{
		this.isPinned = isPinned;
	}

	public User getSentBy()
	{
		return sentBy;
	}

	public void setSentBy(User sentBY)
	{
		this.sentBy = sentBY;
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
		if (inReplyTo != null)
		{
			//TODO This is UI
		}
	}
}
