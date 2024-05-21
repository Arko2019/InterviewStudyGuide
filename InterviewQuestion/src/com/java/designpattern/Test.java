package com.java.designpattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Test {

	public static void main(String[] args) {
		Map<Vehicle1,Integer>map=new HashMap<>();
		map.put(new Vehicle1(1, 2), 1);
		map.put(new Vehicle1(1, 2), 2);
		map.put(new Vehicle1(1, 2), 3);
		System.out.println(map.size());

	}

}

class Vehicle1{
	int a;
	@Override
	public int hashCode() {
		return Objects.hash(a, b);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle1 other = (Vehicle1) obj;
		return a == other.a && b == other.b;
	}
	int b;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public Vehicle1(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	
}