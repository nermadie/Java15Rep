package list;

import java.util.ArrayList;
import java.util.List;

public class Ex02ArrayListsWithSingleType {
	public static void main(String[] args) {
		// > Java 1.5 --> auto(boxing, unboxing)
		int a = 10;
		Integer b = a;
		a = b;
		// this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA
		List<Integer> numbers = new ArrayList();
		int x = 5;
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(x);
		// catch error at compile, better than raw type
//		numbers.add("4");
		System.out.println("size: " + numbers.size());
	}
}
