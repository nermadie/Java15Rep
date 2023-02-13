package view;

import java.util.Arrays;

public class Ex01Crud {
	public static void main(String[] args) {
		int[] numbers = { 1, 9, 5, 36, 12, 33 };
		int[] addedArray = add(numbers, 3, 99);
		System.out.println("AddedArray: " + Arrays.toString(addedArray));

		int[] removedArray = remove(numbers, 2);
		System.out.println("RemovedArray: " + Arrays.toString(removedArray));
	}

	private static int[] add(int[] elements, int position, int newValue) {
		int[] target = new int[elements.length + 1];
		for (int i = 0; i < position; i++)
			target[i] = elements[i];
		target[position] = newValue;
		for (int i = position; i < elements.length; i++)
			target[i + 1] = elements[i];
		return target;
	}

	private static int[] remove(int[] elements, int position) {
		int[] target = new int[elements.length - 1];
		for (int i = 0; i < position; i++)
			target[i] = elements[i];
		for (int i = position + 1; i < elements.length; i++)
			target[i - 1] = elements[i];
		return target;
	}
}
