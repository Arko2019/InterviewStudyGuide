package com.java.java8feature;

public class FunctionalInterfaceInheritence implements C {
	public FunctionalInterfaceInheritence() {
		super();
	}

	public static void main(String[] args) {
		C c = new FunctionalInterfaceInheritence();
//c.printStatic(); it will throw Compile time error
// For interface we cannot call static method through object reference. We need to	call by class itSelf	

		C.printStatic();
		c.show();
		c.print();
		c.printFax();

	}

	@Override
	public void show() {
		System.out.println("Main Show");

	}

	public void print() {

		System.out.println(" Main print");
	}

	public static void printStatic() {

		System.out.println(" Main print Static");
	}
}

@FunctionalInterface
interface A {
	void show();

	public static void printStatic() {
		System.out.println(" A print Static");
	}

	default void printFax() {
		System.out.println("Default A print Fax");
	}
}

@FunctionalInterface
interface B extends A {
	void show();

	default void print() {
		System.out.println("Default B");
	}

	public static void printStatic() {
		System.out.println(" B print Static");
	}
}

interface C extends B {
	void show();

	public static void printStatic() {
		System.out.println(" C print Static");
	}
}