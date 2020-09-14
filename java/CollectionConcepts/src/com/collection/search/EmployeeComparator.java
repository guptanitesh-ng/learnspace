/**
 * 
 */
package com.collection.search;

import java.util.Comparator;

/**
 * @author 150088
 *
 */
public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		/*if (emp1 == emp2) {
			return 0;
		}*/
		int compareResult = emp1.getSurname().compareToIgnoreCase(emp2.getSurname());
		if (compareResult == 0) {
			compareResult = emp1.getName().compareToIgnoreCase(emp2.getName());
		}
		return compareResult;
	}

}
