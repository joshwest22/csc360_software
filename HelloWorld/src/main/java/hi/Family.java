package hi;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Family
{
	ArrayList<Person> famList = new ArrayList<Person>();
	
	public Family()
	{
		
	}
	
	public void addPerson(Person p)
	{
		famList.add(p);
	}
	
	public void storeToDisk()
	{
		XMLEncoder encoder=null;
		try
		{
			encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Family.xml")));
		}
		catch(FileNotFoundException fileNotFound)
		{
			System.out.println("ERROR: While Creating or Opening the File dvd.xml");
		}
		encoder.writeObject(this);
		encoder.close();
	}

	public ArrayList<Person> getFam()
	{
		return famList;
	}

	public void setFam(ArrayList<Person> fam)
	{
		this.famList = fam;
	}
	public static Family loadFromDisk()
	{
		XMLDecoder decoder=null;
		try {
			decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("Family.xml")));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File dvd.xml not found");
		}
		Family f = (Family) decoder.readObject();
		return f;
		
	}
	
	public boolean equals(Family that)
	{
		if (famList.size() != that.famList.size())
		{
			return false;
		}
		for (Person p : famList) 
		{
			if (!that.contains(p))
			{
				return false;
			}
		}
		return true;
	}

	public boolean contains(Person member)
	{
		for (Person p: famList)
		{
			if (p.equals(member))
			{
				return true;
			}
		}
		return false;
	}
}
