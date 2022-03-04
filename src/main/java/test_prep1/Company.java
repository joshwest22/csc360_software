package test_prep1;
import java.util.ArrayList;

public class Company
{
	
	public ArrayList<Double> payAll(Employee[] emp_arr)
	{
		ArrayList<Double> payroll= new ArrayList<Double> (); //append emp to this
		
		for (Employee emp : emp_arr)
		{
			double pay_rate = emp.calcPay(emp.getHourly_rate(), emp.getHours_worked());
			payroll.add(pay_rate); //add to array; arr empty and trying to assign 1st index
		}
		System.out.println("All employees on payroll have been paid.");
		return payroll;
	}

}
