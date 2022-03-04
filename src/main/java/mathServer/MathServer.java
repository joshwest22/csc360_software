package mathServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MathServer extends UnicastRemoteObject implements MathServerInterface
{
	private static final long serialVersionUID = -2;
	
	protected MathServer() throws RemoteException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addNumbers(int a, int b) throws RemoteException
	{
		// adds numbers
		return a+b;
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
