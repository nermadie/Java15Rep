package view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class Ex07ArraysSortWithString {
	public static void main(String[] args) {
		String[] sequences = { "a", "c", "b", "x", "z", "k" };

		// Arrays.sort() --> Auto DESC
		Arrays.sort(sequences);
		System.out.println("1st sorted sequences: " + Arrays.toString(sequences));
		Arrays.sort(sequences, (o1, o2) -> o2.compareTo(o1));
		System.out.println("2nd sorted sequences: " + Arrays.toString(sequences));

		// str-->str ==> Function.identity()
		Arrays.sort(sequences, Comparator.comparing(str -> str));
//		static <T> Function<T, T> identity() {
//	        return t -> t;
//	    }
		Arrays.sort(sequences, Comparator.comparing(Function.identity(), Comparator.reverseOrder()));
		System.out.println("3rd sorted sequences: " + Arrays.toString(sequences));

		sequences = new String[] { null, "a", "c", "b", null, "x", "z", "k" };
		Arrays.sort(sequences, Comparator.nullsFirst(Comparator.comparing(Function.identity())));
		Arrays.sort(sequences, Comparator.nullsFirst(Comparator.reverseOrder()));
		System.out.println("4th sorted sequences: " + Arrays.toString(sequences));
	}
}
