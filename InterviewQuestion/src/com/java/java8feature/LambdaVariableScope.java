package com.java.java8feature;

public class LambdaVariableScope {
	int id;
	static String name;

	public static void main(String[] args) {
		int dep = 10;
		LambdaVariableScope l = new LambdaVariableScope();
		Interface1 i = () -> {
			l.id = 20;
			l.name = "Arko";
			//dep=90; Local variable dep defined in an enclosing scope must be final or effectively final
			System.out.println(l.id);
			System.out.println(l.name);
			System.out.println(dep);
		};
		i.show();
		System.out.println("Main:" + l.name);
		System.out.println("main:" + l.id);
	}

}

interface Interface1 {
	void show();
}