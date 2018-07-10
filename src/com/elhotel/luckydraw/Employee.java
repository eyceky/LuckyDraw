package com.elhotel.luckydraw;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = -2911915507313985825L;

	private String name; // 名字
	private String dept; // 部门

	public Employee(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return dept + "-" + name;
	}
}
