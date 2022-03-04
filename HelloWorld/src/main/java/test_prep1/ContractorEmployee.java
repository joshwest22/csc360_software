package test_prep1;

public class ContractorEmployee extends Employee
{

	public ContractorEmployee(String name, double hourly_rate, int hours_worked)
	{
		super(name, hourly_rate, hours_worked);
		//set the PayBehavior to the appropriate employee type
		PayBehavior PayBehaviorContractor = new PayBehaviorContractor();
		this.setPay_behavior(PayBehaviorContractor);
	}

}
