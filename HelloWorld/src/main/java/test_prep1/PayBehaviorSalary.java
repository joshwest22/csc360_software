package test_prep1;

public class PayBehaviorSalary implements PayBehavior
{

	@Override
	public String toString()
	{
		return "PayBehaviorSalary";
	}

	public double calcWeeklyPay(double hourly_rate, int hours_worked)
	{
		double pay = hourly_rate * 40; //pay is the same regardless of hours worked
		return pay;
	}

}
