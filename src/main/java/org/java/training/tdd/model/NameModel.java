package org.java.training.tdd.model;

public class NameModel {
	private String name;

	public NameModel(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "NameModel [name=" + name + "]";
	}

}
