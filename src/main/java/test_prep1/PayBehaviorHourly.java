package test_prep1;

public class PayBehaviorHourly implements PayBehavior
{

	@Override
	public String toString()
	{
		return "PayBehaviorHourly";
	}

	public double calcWeeklyPay(double hourly_rate, int hours_worked) //This gives the wrong number for some reason
	{
		double pay = 0;
		if (hours_worked <= 40)
		{
			pay = hourly_rate * hours_worked;
		}
		else
		{
			//pay normal rate up to 40 hours
			pay += hourly_rate * 40;
			//System.out.println("pay "+pay);
			//pay remaining hours with 1.5 times normal rate
			double overtime = hourly_rate * 1.5;
			double extra_hours = hours_worked % 40;
			//System.out.println("hourly_rate 1.5X "+overtime);
			//System.out.println("extra hours worked "+extra_hours);
			pay = pay + overtime * extra_hours;
		}
		return pay;
	}

}
