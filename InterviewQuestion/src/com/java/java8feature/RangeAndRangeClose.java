package com.java.java8feature;

import java.util.stream.IntStream;

public class RangeAndRangeClose {

	public static void main(String[] args) {
		IntStream range = IntStream.range(1, 10);
		range.forEach(l->System.out.print(l+" "));
		System.out.println();
		IntStream rangeClose = IntStream.rangeClosed(1, 10);
		rangeClose.forEach(l->System.out.print(l+" "));
	}

}
