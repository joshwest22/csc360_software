package test_prep1;

public class HourlyEmployee extends Employee
{

	public HourlyEmployee(String name, double hourly_rate, int hours_worked)
	{
		super(name, hourly_rate, hours_worked);
		//set the PayBehavior to the appropriate employee type
		PayBehavior PayBehaviorHourly = new PayBehaviorHourly();
		this.setPay_behavior(PayBehaviorHourly);
	}

}
