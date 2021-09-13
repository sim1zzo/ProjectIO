package com.sim1zzo.pma.springExample;

public class Car {
	Engine e;
	Door d;
	Tire t;
	
	
	public Car(Engine e, Door d, Tire t) {
		super();
		this.e = e;
		this.d = d;
		this.t = t;
	}
	
	public void printCarDetails() {
		System.out.println(this.e + " " + this.d);
	}
	
	

}
