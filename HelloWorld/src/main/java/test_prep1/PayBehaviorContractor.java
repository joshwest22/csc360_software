package test_prep1;

public class PayBehaviorContractor implements PayBehavior
{

	@Override
	public String toString()
	{
		return "PayBehaviorContractor";
	}

	public double calcWeeklyPay(double hourly_rate, int hours_worked)
	{
		double pay = hourly_rate * hours_worked; 
		return pay;
	}

}
