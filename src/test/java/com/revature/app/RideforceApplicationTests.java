//package com.revature.app;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.revature.entities.Car;
//import com.revature.entities.Configuration;
//import com.revature.entities.Employee;
//import com.revature.entities.Office;
//import com.revature.repositories.CarRepo;
//import com.revature.repositories.ConfigurationRepo;
//import com.revature.repositories.EmployeeRepo;
//import com.revature.services.OfficeService;
//
//@SpringBootTest
//class RideforceApplicationTests {
//
//	
//	@Autowired
//	CarService cs;
//	@Autowired
//	EmployeeService er;
//	@Autowired
//	ConfigurationService confs;
//	
//	@Autowired 
//	OfficeService os; 
//	
//
//	@Autowired
//	EmployeeRepo er;
//
//	@Autowired
//	CarRepo cr;
//	
//	@Autowired
//	ConfigurationRepo c;
//
//	@Autowired 
//	EmployeeService es; 
//
//// Cars	
//	@Test   // passed
//	void getCarsTest() {
//		List<Car> car = cs.getCars();
//		    for (Car c:car) {
//		    	System.out.println(c);
//		    }
//	}
//	@Test //passed
//	void getCarByIdTest() {
//		int id =1;
//		Car car = cs.getCarById(id);
//		System.out.println(car);
//	}
//	@Test //passed
//	void getCarByEmployeeIdTest() {
//		int employeeId=3;
//		Car car = cs.getCarByEmployeeId(employeeId);
//		System.out.println();
//	}
//	@Test //passed
//	void addCarTest() {
//		Employee employee = er.getEmployeeById(5);
//		Car car = new Car();
//		car.setCar_id(0);
//		car.setAvailable_seats(3);
//		car.setCar_year(2020);
//		car.setColor("Red");
//		car.setEmployee(employee);
//		car.setMake("BMW");
//		car.setModel("4");
//		cs.addCar(car);
//	}
//	@Test
//	void updateCarTest() {
//		Employee employee = er.getEmployeeById(5);
//		Car car = new Car();
//		car.setCar_id(0);
//		car.setAvailable_seats(3);
//		car.setCar_year(2019);
//		car.setColor("Red");
//		car.setEmployee(employee);
//		car.setMake("BMW");
//		car.setModel("4");
//		cs.updateCar(car);
//	}
//	@Test //passed
//	void deleteCarTest() {
//		Car car= new Car();
//		car.setCar_id(12);
//		cs.deleteCar(car);
//	}
//	
//// configuration	
//	@Test
//	void getConfigurationByLabelTest() {
//		String label ="API_KEY";
//		this.confs.getConfigurationByLabel(label);
//	}
//	
////Employee	
//	@Test    // passed
//	void getEmployeesTest() {
//		List<Employee> emp = es.getEmployees();
//	    for (Employee c:emp) {
//	    	System.out.println(c);
//	    }
//	}
//	@Test  //passed
//	void getEmployeeByIdTest() {
//		int id = 4;
//		es.getEmployeeById(id);
//	}
//	@Test  //passed
//	void getEmployeeByUsernameTest() {
//		String username="LGoodfellow";
//		es.getEmployeeByUsername(username);
//	}
//	@Test  //passed
//	void getEmployeeByRoleTest() {
//		boolean isDriver =true ;
//		es.getEmployeeByRole(isDriver);
//	}
//	@Test
//	void getEmployeeByRoleAndOfficeTest() {
//		boolean isDriver =true ;
//		Office office = os.getOfficeById(1);
//		es.getEmployeeByRoleAndOffice(isDriver, office);
//	}
//	
//	@Test //works, positive and negative tested
//	void employeeLogin() {
//
//		Employee employee = es.loginEmployee("SLob", "password");
//				System.out.println(employee);
//	}
//	
//	@Test //works 
//	void getActiveDrivers() {
//		List<Employee> employees = es.getActiveDrivers();
//		for (Employee e : employees) {
//		System.out.println(e);
//	}
//	}	
//	
//	@Test //THIS DOES NOT WORK 
//	void deleteEmployee() {
//		Employee employee = es.getEmployeeById(12); 
//		es.deleteEmployee(employee); 
//		System.out.println(employee);
//	}
//	
//	@Test //works
//	void updateEmployee() {
//		Employee employee = es.getEmployeeById(11); 
//		employee.setFirst_name("Dan");
//		employee.setLast_name("Too");
//		employee.setPhone_number("123-123-1234");
//		employee.setUsername("dtoo");
//		employee.setPassword("passmcpass");
//		employee.setEmail("abc@gmail.com");
//		employee.setUser_address("123 high street");
//		employee.setIs_accepting_rides(false);
//		employee.setIs_active(false);
//		employee.setIsDriver(false); 
//		employee.setIs_manager(false);
//		es.updateEmployee(employee);
//	}
//	
//	@Test //works
//	void addEmployee() {
//		Office office = os.getOfficeById(2); 
//		Employee employee = new Employee(0, "email", "String first_name", "String last_name", "String phone_number",
//				"String username", "String password", "String user_address", false, false,
//				false, false, office);
//		es.addEmployee(employee); 
//		System.out.println(employee);
//	}
//
////offices
//
//	@Test //works 
//	void getOffices() {
//		List<Office> offices = os.getOffices(); 
//			for (Office o : offices) {
//			System.out.println(o);
//			}
//	}
//	
//	
//	@Test // works
//	void findByUsername() {
//		String username = "LGoodfellow";
//		Employee employee = er.findByUsername(username);
//		System.out.println(employee);
//	}
//	
//	@Test // works
//	void findByIsDriver() {
//		boolean isDriver = true;
//		List<Employee> employees = er.findByIsDriver(isDriver);
//		System.out.println(employees);
//	}
//	
//	@Test // works
//	void findByIsDriverAndOffice() {
//		Office office = new Office(1,"496 High Street, Morgantown, WV 26506");
////		Office office = new Office(2,"11730 Plaza America Drive, Reston, VA 20190");
//		boolean isDriver = true;
//		List<Employee> employees = er.findByIsDriverAndOffice(isDriver, office);
//		System.out.println(employees);
//	}
//	
//	@Test // works
//	void findByEmployee() {
//		String username = "MCrilly";
//		Employee employee = er.findByUsername(username);
//		List<Car> cars = cr.findByEmployee(employee);
//		System.out.println(cars);
//	}
//	
//	@Test // works
//	void findByLabel() {
//		String label = "API_KEY";
//		Configuration config = c.findByLabel(label);
//		System.out.println(config);
//	}
//	
//	
//	
//	
//	
//	@Test
//	void deleteEmployee() { 
//		Employee employee = er.findById(11);
//		System.out.println(employee);
//		er.delete(employee);
//	}
//	
//
//	
//	
//	@Test
//	void deleteCar() {
//		Car car = cr.findById(17);
//		cr.delete(car);
//	}
//	
//	
//	
//
//	@Test  
//	void getByUsername(){
//		String username = "LGoodfellow";
//		Employee employee = er.findByUsername(username);
//		System.out.println(employee);
//			
//	}
//
//
//
//	@Test //works
//	void getOfficeById() {
//		Office office = os.getOfficeById(2); 
//		System.out.println(office);
//	
//	}
//	
//	@Test //works
//	void addOffice() {
//		Office office = new Office(0, "123 hong kong drive"); 
//		os.addOffice(office); 
//		System.out.println(office);
//	}
//	
//	@Test //works 
//	void updateOffice() {
//		Office office = os.getOfficeById(5);
//		office.setOffice_address("123 belaire dr");
//		os.updateOffice(office); 
//		System.out.println(office);
//	}
//	
//	@Test // works
//	void deleteOffice() {
//		Office office = os.getOfficeById(5);
//		os.deleteOffice(office); 
//		System.out.println(office);
//	}
//	
//	
//	
//	}
//
