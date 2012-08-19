package com.vathanakmao.testproj.springtest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Vathanak Mao
 * @since 2012-01-04
 */
@XmlRootElement(name = "employee")
public class Employee {

	private Long id;

	@NotBlank
	private String name;

	public Employee() {
	}

	public Employee(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

}
