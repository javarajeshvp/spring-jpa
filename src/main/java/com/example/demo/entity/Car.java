package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.examples.demo.util.Output;

@Entity
public class Car {
	@Id
	private String vin;
	private String model;

	public Car() {
		Output.print("Car Object Created");
	}



	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void run() {
		Output.print("Running Car [vin=" + vin + ", model=" + model + "]");
	}



	@Override
	public String toString() {
		return "Car [vin=" + vin + ", model=" + model + "]";
	}

}
