package test_prep1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
		Company company = new Company();
		Employee[] emp_arr = {contract_worker, hourly_worker, salary_worker};
		ArrayList<Double> paytest = new ArrayList<Double>() ;//anticipated values {1260.00,1075.00,1400.00}
		paytest.add(1260.00);
		paytest.add(1075.00);
		paytest.add(1400.00);
		assertEquals(company.payAll(emp_arr),paytest); //compares 2 ArrayList<Double>
		
	}

}
