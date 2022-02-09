package test_prep1;

public class Main
{
	//Example test cases; Fix these
	private static double[] payAll(Employee[] emp_arr)
	{
		double[] payroll= new double[] {}; //append emp to this
		int count = 0;
		for (Employee emp : emp_arr)
		{
			double pay_rate = emp.calcPay(emp.getHourly_rate(), emp.getHours_worked());
			payroll[count] = pay_rate;
			count+=1;
		}
		System.out.println("All employees on payroll have been paid.");
		return payroll;
	}
	public static void Main(String[] args)
	{
		//PayBehavior contractual = new PayBehaviorContractor();
		//PayBehavior hourly = new PayBehaviorHourly();
		//PayBehavior salary = new PayBehaviorSalary();
		Employee bob = new ContractorEmployee("Bob Builder",30.00,42);//$1260/week
		Employee martin = new HourlyEmployee("Martin Tall",25.00,42);//$1075/week
		Employee jessica = new SalaryEmployee("Jessica Builder",35.00,42); //$1400/week
		
		//Pay all employees
		Employee[] payroll = new Employee[] {bob, martin, jessica};
		payAll(payroll);
		
		

	}

}
