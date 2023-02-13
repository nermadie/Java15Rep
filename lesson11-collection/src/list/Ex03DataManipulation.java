package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex03DataManipulation {
	public static void main(String[] args) {
		// add, remove, get, set, contains, size, iterate
		List<String> elements = new ArrayList();

		elements.add("A");
		elements.add("B");
		elements.add("C");
		elements.add("D");

//		elements.remove(1);
//		elements.remove("C");
//		elements.removeIf(str -> str == "A");
		iterate(elements);

		// contains
		System.out.println("is exists: " + elements.contains("X"));
		System.out.println("size: " + elements.size());
		elements.forEach(System.out::println);
	}

	private static void iterate(List<String> elements) {
		// iterator
		Iterator<String> each = elements.iterator();
		while (each.hasNext()) {
			String element = each.next();
			System.out.println(element);
//			elements.remove(element);//ConcurrentModificationException
			each.remove();
		}
	}
}
