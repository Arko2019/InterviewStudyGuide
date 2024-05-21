package com.java.designpattern;

public class FactoryDesignPattern {

	public static void main(String[] args) {
		VehicleFactory factory=new VehicleFactory();
		Vehicle bmw=factory.getVehice("BMW");
		bmw.type();

	}

}

class VehicleFactory{
	Vehicle getVehice(String name) {
		if(name=="BMW") {
			return new BMW();
		}else if(name=="Swift") {
			return new SwiftDesire();
		}
		return null;
	} 
}

abstract class Vehicle{
	abstract void type();
}

class BMW extends Vehicle{
	BMW(){
		
	}

	@Override
	void type() {
		System.out.println("BMW ");		
	}
}

class SwiftDesire extends Vehicle{
	SwiftDesire(){
		
	}

	@Override
	void type() {
		System.out.println("SwiftDesire ");		
	}
}