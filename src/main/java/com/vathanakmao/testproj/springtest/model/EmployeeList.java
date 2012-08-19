package com.vathanakmao.testproj.springtest.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vathanak Mao
 * @since 2012-01-04
 */
@XmlRootElement(name = "employees")
public class EmployeeList extends ArrayList<Employee> {
	private static final long serialVersionUID = -1592677248028186253L;

	public EmployeeList() {
	}

	public EmployeeList(List<Employee> employees) {
		for (Employee emp : employees) {
			add(emp);
		}
	}

	@XmlElement(name = "employee")
	public void setEmployees(List<Employee> employees) {
		for (Employee emp : employees) {
			add(emp);
		}
	}

	public List<Employee> getEmployees() {
		List<Employee> result = new ArrayList<Employee>();

		Iterator<Employee> it = iterator();
		while (it.hasNext()) {
			result.add(it.next());
		}

		return result;
	}

}
