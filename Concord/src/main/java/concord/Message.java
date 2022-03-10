package concord;

import java.sql.Timestamp;
import java.time.Instant;

public class Message
{
	String text;
	Timestamp timestamp;
	Boolean isPinned = false;
	Integer sentBy;
	Message inReplyTo;
	
	public Message(String text, Timestamp timestamp, Boolean isPinned, Integer sentBy, Message inReplyTo)
	{
		this.text = text;
		this.timestamp = timestamp;
		this.isPinned = isPinned;
		this.sentBy = sentBy;
		this.inReplyTo = inReplyTo;
	}
	//alternate constructor
	public Message(String msg, Integer user)
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

	public Integer getSentBy()
	{
		return sentBy;
	}

	public void setSentBy(Integer sentBY)
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
