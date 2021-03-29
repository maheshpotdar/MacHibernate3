package com.test.app;

import com.test.entity.Address;
import com.test.entity.Employee;
import com.test.service.EmployeeService;
import com.test.service.impl.EmployeeServiceImpl;

/**
 * Hello world!
 *
 */
public class App extends Thread {

	private static EmployeeService employeeService = null;

	public App() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		super.run();
	}

	static {
		employeeService = new EmployeeServiceImpl();
	}

	public static void main(String[] args) {
		App a = new App();

		createEmployeeStarter();
		selectAllEmployee();
//		UpdateEmployee();
//		deleteEmployee();
//		fetchSingleEmployee();

	}

	private static void createEmployeeStarter() {
		Employee[] employees = CreateEmployee();
		for (Employee e : employees) {
			employeeService.CreateEmployee(e);
			try {
				Thread.sleep(2000);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
	}

	private static Employee[] CreateEmployee() {

		Employee employee1 = new Employee();
		employee1.setName("Vijay Malya");

		Employee employee2 = new Employee();
		employee2.setName("John Paull");

		// ======== Address ==========

		Address address1 = new Address();
		address1.setCityName("Kolhapur");
		address1.setStateName("Maharashtra");

		Address address2 = new Address();
		address2.setCityName("ranchi");
		address2.setStateName("Zarkhand");

		// ==============================
		employee1.setAddress(address1);
		employee2.setAddress(address2);

		Employee[] emp = new Employee[] { employee1, employee2 };

		return emp;
	}

	private static void selectAllEmployee() {
		employeeService.selectAllEmployee();
	}

	private static void UpdateEmployee() {
		Employee employee = new Employee();
		employee.setId(3);
		employee.setAddress(null);

		employeeService.UpdateEmployee(employee);
	}

	private static void deleteEmployee() {
		employeeService.deleteEmployee(4);
	}

	private static void fetchSingleEmployee() {

		employeeService.fetchSingleEmployee(new Employee(2, "", null));
	}

}
