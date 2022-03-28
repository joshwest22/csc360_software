package hi;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FamilyTest
{

	Family f;
	Person R;
	Person J;
	Person M;
	Person Y;
	@BeforeEach
	void setUp() throws Exception
	{
		f= new Family();
		R = new Person("Romeo", "Mon", 15);
		J = new Person("Juliet","Cap",13);
		M = new Person("Count","Dukoo",54);
		Y = new Person("Yo","Da",973);
		f.addPerson(J);
		f.addPerson(M);
		f.addPerson(R);
		f.addPerson(Y);		
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void test()
	{
		f.storeToDisk();
		Family diskF = Family.loadFromDisk();
		
		assertTrue(f.equals(diskF));
	}

}
