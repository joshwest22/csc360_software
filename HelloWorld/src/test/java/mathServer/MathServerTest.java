package mathServer;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.junit.After;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MathServerTest
{
	static MathServer ms;
	static Registry registry;
	@BeforeAll
	static void setUp() throws Exception
	{
		ms = new MathServer(); //all tests are using same server here; beforeEach for new server each function
		registry = LocateRegistry.createRegistry(1099);
		registry.rebind("MATHS", ms);
		//debugging
		String[] names = registry.list();
		for (String name:names)
		{
			System.out.println("name: "+name);
		}
	}

	@After
	void tearDown() throws Exception
	{
		registry.unbind("MATHS");
	}

	@Test
	void test()
	{
		MathServerInterface mp;
		try
		{
			
			mp = (MathServerInterface)registry.lookup("MATHS");
			int addAnswer = mp.addNumbers(5, 10);
			assertEquals(15,addAnswer);
			int subAnswer = mp.subtractNumbers(10, 5);
			assertEquals(5,subAnswer);
		} catch (RemoteException | NotBoundException e)
		{
			e.printStackTrace();
			fail("Bad call to registry");
		}
		
	}

}
