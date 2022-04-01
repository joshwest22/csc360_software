package concord;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements RMIObserver, Serializable
{

	protected Client() throws RemoteException
	{
		
	}

	private static final long serialVersionUID = -6394155878301235563L;
	
	String name = "fred";
	
	@Override
	public void notifyFinished()
	{
		System.out.println(name+" was called");
	}

}
