package com.java.designpattern;

//Declare Class As fial
public final class ImmutableC {
//All members of class should be private
	private String message;

//Public constructor	
	public ImmutableC(String message) {
		this.message = message;
	}

//No setter only public getter
	public String getMessage() {
		return message;
	}
}
