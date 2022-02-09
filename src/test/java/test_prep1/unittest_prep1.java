package test_prep1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class unittest_prep1
{
	ContractorEmployee contract_worker;
	HourlyEmployee hourly_worker;
	SalaryEmployee salary_worker;
	@BeforeEach
	void setUp() throws Exception
	{
//		PayBehaviorContractor contractual = new PayBehaviorContractor();
//		PayBehaviorHourly hourly = new PayBehaviorHourly();
//		PayBehaviorSalary salary = new PayBehaviorSalary();
		contract_worker = new ContractorEmployee("Bobby T",30.00,42);
		hourly_worker = new HourlyEmployee("Horace W",25.00,42);
		salary_worker = new SalaryEmployee("Sally S",35.00,42);
	}

	@Test
	void test()
	{
		//Verify each employee type is created correctly
//		System.out.println(contract_worker);
//		System.out.println(hourly_worker);
//		System.out.println(salary_worker);
		
		//Verify each employee's setHours_Worked works
		contract_worker.setHours_worked(30);
		assertEquals(contract_worker.getHours_worked(),30);
		hourly_worker.setHours_worked(30);
		assertEquals(hourly_worker.getHours_worked(),30);
		salary_worker.setHours_worked(30);
		assertEquals(salary_worker.getHours_worked(),30);
		
		//Reset hours worked
		contract_worker.setHours_worked(42);
		hourly_worker.setHours_worked(42);
		salary_worker.setHours_worked(42);
		
		//Verify ability to pay all workers
		double[] paytest = new double[] {1260.00,1037.5,1400.00};//anticipated values
		assertEquals(payAll(contract_worker,hourly_worker,salary_worker),paytest); //compares 2 arrays
		
	}

	//This would be run in main()
	private double[] payAll(Employee contract_worker, Employee hourly_worker, Employee salary_worker)
	{
		double c = contract_worker.calcPay(contract_worker.getHourly_rate(),contract_worker.getHours_worked());
		double h = hourly_worker.calcPay(hourly_worker.getHourly_rate(),hourly_worker.getHours_worked());
		double s = salary_worker.calcPay(salary_worker.getHourly_rate(),salary_worker.getHours_worked());
		double[] payroll = new double[] {c,h,s};
		return payroll;
	}

}
