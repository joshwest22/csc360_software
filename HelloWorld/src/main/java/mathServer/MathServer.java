package mathServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MathServer extends UnicastRemoteObject implements MathServerInterface
{
	private static final long serialVersionUID = -2;
	
	private int visits=0;
	
	public int getVisits()
	{
		return visits;
	}

	public void setVisits(int visits)
	{
		this.visits = visits;
	}

	protected MathServer() throws RemoteException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addNumbers(int a, int b) throws RemoteException
	{
		visits++;
		// adds numbers
		return a+b;
	}
	@Override
	public int subtractNumbers(int a, int b) throws RemoteException
	{
		// subtract numbers
		return a-b;
	}
	
	public static void main(String[] args)
	{
		try
		{
			MathServer M = new MathServer();
			Naming.rebind("MATHS", M);
		}
		catch (RemoteException e)
		{
			
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
