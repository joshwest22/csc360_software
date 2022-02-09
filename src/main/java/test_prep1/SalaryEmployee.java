package test_prep1;

public class SalaryEmployee extends Employee
{

	public SalaryEmployee(String name, double hourly_rate, int hours_worked)
	{
		super(name, hourly_rate, hours_worked);
		//set the PayBehavior to the appropriate employee type
		PayBehavior PayBehaviorSalary = new PayBehaviorSalary();
		this.setPay_behavior(PayBehaviorSalary);
	}

}
