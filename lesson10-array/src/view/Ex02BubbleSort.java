package view;

import java.util.Arrays;

public class Ex02BubbleSort {
	public static void main(String[] args) {
		Integer[] numbers = { 1, 5, 11, 9, 4, 6 };
		sort(numbers);
		System.out.println(Arrays.toString(numbers));
	}

	private static void sort(Integer[] source) {
		for (int i = 0; i < source.length - 1; i++) {
			for (int j = i + 1; j < source.length; j++) {
				if (source[i] > source[j]) {
					swap(source, i, j);
				}
			}
		}
	}

	private static <T> void swap(T[] source, int i, int j) {
		T temp = source[i];
		source[i] = source[j];
		source[j] = temp;
	}
}
