package view;

import java.util.Arrays;

public class Ex03BubbleSortWithString {
	public static void main(String[] args) {
		String[] sequences = { "Alex", "Terry", null, "Rivaldo", null, "Blue", "Zill" };
//		sort(sequences);
		sortHandleNullFirst(sequences);
		System.out.println(Arrays.toString(sequences));
		sortHandleNullLast(sequences);
		System.out.println(Arrays.toString(sequences));
	}

	private static void sortHandleNullFirst(String[] source) {
		for (int i = 0; i < source.length - 1; i++) {
			for (int j = i + 1; j < source.length; j++) {
				// B1: Xu ly null first
				if (source[i] == null)
					continue;
				else if (source[j] == null)
					swap(source, i, j);
				// B2: Sap xep tang dan cho nhung phan tu khac Null
				else if (source[i].compareTo(source[j]) > 0) {
					swap(source, i, j);
				}
			}
		}
	}

	private static void sortHandleNullLast(String[] source) {
		for (int i = 0; i < source.length - 1; i++) {
			for (int j = i + 1; j < source.length; j++) {
				// B1: Xu ly null first
				if (source[j] == null)
					continue;
				else if (source[i] == null)
					swap(source, i, j);
				// B2: Sap xep tang dan cho nhung phan tu khac Null
				else if (source[i].compareTo(source[j]) > 0) {
					swap(source, i, j);
				}
			}
		}
	}

	private static void sort(String[] source) {
		for (int i = 0; i < source.length - 1; i++) {
			for (int j = i + 1; j < source.length; j++) {
				if (source[i].compareTo(source[j]) > 0) {
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
