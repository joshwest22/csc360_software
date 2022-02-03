package hi;

public class UnderAgeException extends Exception
{

	/**
	 * 
	 */
	public UnderAgeException()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UnderAgeException(String message, Throwable cause)
	{
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public UnderAgeException(String message)
	{
		super("Parent is too young!");
		
	}

	private static final long serialVersionUID = 4554479932935169519L;

}
