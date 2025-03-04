package interview;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExceptionHandling {

	public static void main(String[] args) {
		ExceptionHandling exceptionHandling = new ExceptionHandling();
		int data = exceptionHandling.show();
		System.out.println(data);
//exceptionHandling.addRecord();
	}

	int show() {
		try {
			int a = 0;
			int n = 3 / a;
		} catch (Exception ex) {
			System.out.println("Catch");
			return 0;
		} finally {
			System.out.println("finally");
			return 1;
		}
	}

	void addRecord() {
		try {
			List<Integer> list = Arrays.asList(1, 2, 3, 4);
			Iterator<Integer> it = list.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
				list.add(5);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
