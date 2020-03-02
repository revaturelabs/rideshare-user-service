package repositoryTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.entities.Employee;
import com.revature.repositories.EmployeeRepo;

import org.springframework.boot.test.context.SpringBootTest;


class EmployeeRepoTests {

	@Autowired
	EmployeeRepo er;
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	
	@Test  
	void getByUsername(){
		String username = "LGoodfellow";
		Employee employee = er.findByUsername(username);
		System.out.println(employee);
			
	}

}
