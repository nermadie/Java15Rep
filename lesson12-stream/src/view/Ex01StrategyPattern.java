package view;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import bean.Apple;
import model.DataModel;

public class Ex01StrategyPattern {
	public static void main(String[] args) {
		List<Apple> inventory = DataModel.getApples();
		List<Apple> redApples = findApples(inventory, a -> "red".equals(a.getColor()));
		// Method Reference
		redApples.forEach(System.out::println);

		List<Apple> heavyApples = findApples(inventory, a -> a.getWeight() > 300);
		heavyApples.forEach(System.out::println);
	}

	// Functional Interface: signature --> (T) -> boolean
	private static List<Apple> findApples(List<Apple> inventory, Predicate<Apple> predicate) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (predicate.test(apple))
				result.add(apple);
		}
		return result;
	}

	// Tim apple theo color
	private static List<Apple> findApples(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (color.equals(apple.getColor()))
				result.add(apple);
		}
		return result;
	}

	// Tim apple theo weight
	private static List<Apple> findApples(List<Apple> inventory, int weight) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > weight)
				result.add(apple);
		}
		return result;
	}
}
