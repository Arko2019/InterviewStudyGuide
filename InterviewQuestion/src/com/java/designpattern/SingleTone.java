package com.java.designpattern;

public class SingleTone {

	private static SingleTone instance;
	private int data;

	private SingleTone(int data) {
		this.data = data;
	}

	public static SingleTone getInstance(int data) {
		if (instance == null) {
			synchronized (SingleTone.class) {
				if (instance == null) {
					instance = new SingleTone(data);
				}
			}

		}

		return instance;
	}

}
