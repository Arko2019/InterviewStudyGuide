package com.java.java8feature;

// Diamond Problem in interface
public class DefaultMethodsInterface implements RBIBank,CSBBank {

	public static void main(String[] args) {
		DefaultMethodsInterface defaultMethodsInterface=new DefaultMethodsInterface();
		defaultMethodsInterface.depositMoneyToRBI(10000);
		defaultMethodsInterface.depositMoneyToCSB(40000);
		defaultMethodsInterface.transferMoney(200);

	}

	// Same default method need to be over ridden and using super as showed below
	@Override
	public void transferMoney(int amount) {
		
		CSBBank.super.transferMoney(amount);
	}

}

interface RBIBank{
	
	default void transferMoney(int amount) {
		System.out.println("RBI Bank Transfer Amount::"+amount);
	}
	default void depositMoneyToRBI(int amount) {
		System.out.println("RBI Bank Deposit Amount::"+amount);
	}
	
}

interface CSBBank{
	default void transferMoney(int amount) {
		System.out.println("CSB Bank Transfer Amount::"+amount);
	}
	default void depositMoneyToCSB(int amount) {
		System.out.println("CSB Bank Deposit Amount::"+amount);
	}
}
