package test_prep1;

public abstract class Employee
{
	@Override
	public String toString()
	{
		return "Employee [pay_behavior=" + pay_behavior + ", name=" + name + ", hourly_rate=" + hourly_rate
				+ ", hours_worked=" + hours_worked + "]";
	}

	protected PayBehavior pay_behavior;
	private String name;
	private double hourly_rate;
	private int hours_worked;
	
	public Employee(String name, double hourly_rate, int hours_worked)
	{
		this.setName(name);
		this.setHourly_rate(hourly_rate);
		this.setHours_worked(hours_worked);
		this.setPay_behavior(pay_behavior);
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getHourly_rate()
	{
		return hourly_rate;
	}

	public void setHourly_rate(double hourly_rate)
	{
		this.hourly_rate = hourly_rate;
	}

	public int getHours_worked()
	{
		return hours_worked;
	}

	public void setHours_worked(int hours_worked)
	{
		this.hours_worked = hours_worked;
	}

	public PayBehavior getPay_behavior()
	{
		return pay_behavior;
	}

	public void setPay_behavior(PayBehavior pay_behavior)
	{
		this.pay_behavior = pay_behavior;
	}

	public double calcPay(double hourly_rate, int hours_worked)
	{
		return pay_behavior.calcWeeklyPay(hourly_rate,hours_worked);
	}

}
