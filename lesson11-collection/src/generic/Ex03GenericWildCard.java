package generic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Ex03GenericWildCard {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Double> decimals = Arrays.asList(5d, 55d, 555d);
		List<String> strings = Arrays.asList("as");

		printf(numbers);
		printf(decimals);
		test(numbers, strings);
		test("asb", 123);
		test2(a -> "ádfasf");
		printf2(decimals);
	}

	// List<Object> is not parent of List<Integer>
	private static <T extends Number> void printf(List<T> elements) {
		for (T element : elements)
			System.out.print(element + " ");
		System.out.println();
	}

	private static <T> void test(T e, T e1) {
	}

	private static void test2(Function<?, ?> s1) {

	}

	private static void printf2(List<? super Double> elements) {
		for (Object element : elements)
			System.out.println(element + " ");
	}
}