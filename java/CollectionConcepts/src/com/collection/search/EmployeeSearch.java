/**
 * 
 */
package com.collection.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 150088
 *
 */
public class EmployeeSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee firstEmployee = new Employee(1, "Peter", "Parker", "a.x@co.yup");
		Employee secondEmployee = new Employee(1, "Richard", "Button", "r.b@n.com");
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(firstEmployee);
		employees.add(secondEmployee);
		Collections.sort(employees, new EmployeeComparator());
		Employee thirdEmployee = new Employee(1, "Richard", "Button", "r.b@n.com");
		int index = Collections.binarySearch(employees, thirdEmployee, new EmployeeComparator());
		System.out.println(index);
		
		Employee fourthEmployee = new Employee(1, "Richard", "Benson", "r.b@n.com");
		index = Collections.binarySearch(employees, fourthEmployee, new EmployeeComparator());
		System.out.println(index);
		
		Employee fifthEmployee = new Employee(1, "Peter", "Parker", "a.x@co.yup");
		index = Collections.binarySearch(employees, fifthEmployee, new EmployeeComparator());
		System.out.println(index);
		
	}

}
