package interview;

import java.util.Optional;

public class OptionalAllInOne {
	public static void main(String[] args) {
		Optional<String>str1=Optional.of("Hello");
		System.out.println("Optional Of:"+str1.get());
		
		Optional<String>str2=Optional.ofNullable(null);
		System.out.println("Optional ofNullable:"+str2);
		
		Optional<String>str3=Optional.ofNullable("Hii");
		System.out.println("Optional ofNullable:"+str3);
		
		Optional<String>str4=Optional.ofNullable("Testing");
		System.out.println("Optional ofNullable:"+str4.get());
		
		str4.ifPresent(str->System.out.println("In If Present:"+str.toUpperCase()));
		
		// If present else if not present it will give default value
		System.out.println(str2.orElse("India"));
		
		// Pending few more methods
	}
}
