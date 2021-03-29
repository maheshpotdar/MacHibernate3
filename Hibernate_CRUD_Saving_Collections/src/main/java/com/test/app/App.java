package com.test.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.test.entity.Country;
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
		employee1.setAddress("England");

		//======== 3 PASSPORTS ==========
		Country country1 = new Country();
		country1.setContinent("WEST");
		country1.setCountryName("England");
		country1.setCounryID(100);

		Country country2 = new Country();
		country2.setContinent("EAST");
		country2.setCountryName("INDIA");
		country2.setCounryID(200);
		
		Country country3 = new Country();
		country3.setContinent("NORTH");
		country3.setCountryName("BERMUDA");
		country3.setCounryID(300);
		
		Set<Country> countrys = new TreeSet<Country>(); 
		countrys.add(country1);
		countrys.add(country2);
		countrys.add(country3);
		
		//==============================
		
		List<Country> lsts= countrys.stream().collect(Collectors.toList());
		
		employee1.setCountry(lsts);

		Employee employee2 = new Employee();
		employee2.setName("Raghurajan");
		employee2.setAddress("INDIA");
		
		
		List<Country> countries=new ArrayList<Country>();
		countries.add(country2);
		countries.add(country3);
		
		employee2.setCountry(countries);
		
		Employee[] emp = new Employee[] { employee1, employee2 };

		return emp;
	}

	private static void selectAllEmployee() {
		employeeService.selectAllEmployee();
	}

	private static void UpdateEmployee() {
		Employee employee = new Employee();
		employee.setId(3);
		employee.setAddress("Shree Lanka");

		employeeService.UpdateEmployee(employee);
	}

	private static void deleteEmployee() {
		employeeService.deleteEmployee(4);
	}

	private static void fetchSingleEmployee() {

		employeeService.fetchSingleEmployee(new Employee(2, "", "", null));
	}

}
