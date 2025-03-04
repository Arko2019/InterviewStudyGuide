package interview;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "vivekkadiyal";
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			list.add(input.charAt(i));
		}
		Map<Character, Long> map1 = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		List<Entry<Character, Long>> map2 = map1.entrySet().stream().filter(e -> e.getValue() == 1).toList();
		
		System.out.println(map2);
		
		List<Character> list1 = map1.entrySet().stream().filter(e -> e.getValue() == 1).map(k -> k.getKey()).toList();
		System.out.println(list1);

		Map<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < input.length(); i++) {
			if (map.containsKey(input.charAt(i))) {
				map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
			} else {
				map.put(input.charAt(i), 1);
			}
		}
		map.forEach((k, v) -> {
			if (v == 1) {
				// System.out.println(k);
			}
		});
	}

}
