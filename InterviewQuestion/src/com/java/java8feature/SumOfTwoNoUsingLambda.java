package com.java.java8feature;

public class SumOfTwoNoUsingLambda {

	public static void main(String[] args) {
		Calcuation cal=(a,b)->a+b;
		System.out.println(cal.sum(1, 2));
		cal.print();

	}

}
@FunctionalInterface
interface Calcuation{
	int sum(int a,int b);
	default void print() {
		System.out.println("In default");
	}
}
