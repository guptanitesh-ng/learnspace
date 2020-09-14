package com.training.spring;

import java.util.List;
import java.util.Set;

public class PropertyInjectionOptions {

	private String textType;
	
	private Employee refType;
	
	private SingletonBean singleton;
	
	private Employee innerType;
	
	private Set<Employee> setType;
	
	private List<Object> listType;

	public String getTextType() {
		return textType;
	}

	public void setTextType(String textType) {
		this.textType = textType;
	}

	public Employee getRefType() {
		return refType;
	}

	public void setRefType(Employee refType) {
		this.refType = refType;
	}

	public SingletonBean getSingleton() {
		return singleton;
	}

	public void setSingleton(SingletonBean singleton) {
		this.singleton = singleton;
	}

	public Employee getInnerType() {
		return innerType;
	}

	public void setInnerType(Employee innerType) {
		this.innerType = innerType;
	}

	public Set<Employee> getSetType() {
		return setType;
	}

	public void setSetType(Set<Employee> setType) {
		this.setType = setType;
	}

	public List<Object> getListType() {
		return listType;
	}

	public void setListType(List<Object> listType) {
		this.listType = listType;
	}
	
}
