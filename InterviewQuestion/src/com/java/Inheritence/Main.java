package com.java.Inheritence;

public class Main extends A{

	public static void main(String[] args) {
		A a = new B();
		a.print();
		a.printStatic();
		System.out.println("--------------");
		A a1 = new B();
		a1.print();
		a1.printStatic();
		
	}
	public static void printStatic() {
		System.out.println(" Main print Static");
	}
}

class A {
	A() {
		System.out.println("A Constructor");
	}

	public void print() {
		System.out.println(" A print");
	}

	public static void printStatic() {
		System.out.println(" A print Static");
	}
}

class B extends A {
	B() {
		System.out.println("B Constructor");
	}

	public void print() {
		System.out.println(" B print");
	}

	public static void printStatic() {
		System.out.println(" B print Static");
	}
}