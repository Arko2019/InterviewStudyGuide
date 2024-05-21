package com.java.java8feature.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreateJava8Stream {

	public static void main(String[] args) {

		Stream<Integer>intStream1=Stream.of(1,2,3,4,5);
		intStream1.forEach(k->System.out.print(k+" "));
		System.out.println();
		
		Integer[]arr=new Integer[] {10,20,30,40};
		Stream<Integer>arrStream=Stream.of(arr);
		arrStream.forEach(k->System.out.print(k+" "));
		System.out.println();
		
		Stream<Integer>arrStream3=Arrays.stream(arr);
		arrStream3.map(m->m+2).forEach(k->System.out.print(k+" "));
		
	}

}
