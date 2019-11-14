package br.net.erponline.model.entity;

public class Vehicle {
	private String model;

	
	public Vehicle() {

	}

	public Vehicle(String model) {
		super();
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Vehicle [model=" + model + "]";
	}
}