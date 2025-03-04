package interview;

import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Set;

public class FindFirstElementInString {

	public static void main(String[] args) {
		 String input = "Feel the need";
		 Set<Integer>set=new HashSet<>();
	OptionalInt opt=input.chars().filter(k->!set.add(k)).findFirst();
		System.out.println((char)opt.getAsInt());
		 
	}

}
