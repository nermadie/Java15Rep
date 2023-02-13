package view;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import bean.Dish;
import model.DataModel;

public class Ex05StreamPreDemo {
	public static void main(String[] args) {
		List<Dish> menu = DataModel.getDishes();

		// Stream --> traversable once (Chi co the duyet 1 lan)
		System.out.println("1. Get dishes which have calories > 250g");
		List<Dish> weightCalories = menu.stream()// Stream<Dish>
				.filter(d -> d.getCalories() > 400) // Stream<Dish>
				.collect(Collectors.toList());
		weightCalories.forEach(System.out::println);

		System.out.println("===========");
		System.out.println("2. Get name of dishes");
		Set<String> nameOfDishes = menu.stream() // Stream<Dish>
				.map(Dish::getName) // Stream<String>
				.collect(Collectors.toSet());
		nameOfDishes.forEach(System.out::println);

		String names = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
		System.out.println(names);

		System.out.println("===========");
		System.out.println("3. Get name of dishes which is vegetarian food");
		// Chu y filter truoc khi map neu khong khong the filter voi Stream<String>
		Set<String> nameOfVegetDishes = menu.stream().filter(d -> d.isVegetarian()).map(Dish::getName)
				.collect(Collectors.toSet());
		nameOfVegetDishes.forEach(System.out::println);

		System.out.println("===========");
		System.out.println("4. Sort a vehicle model map");
		// Map --> Set --> List - sortbyKV --> LinkedHashMap
		// Map --> Set --> Stream - sortbyKV --> LinkedHashMap
		Map<Integer, String> modelMap = DataModel.getVehicleModelMap();
		Map<Integer, String> sortedMap = modelMap.entrySet() // Set<Entry<K, J>
				.stream() // Stream<Entry<K, J>>
				.sorted(Comparator.comparing(Entry::getValue, Comparator.reverseOrder()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		// collect(Collectors.toMap())
		// --> Key Func, Value Func
		// --> Key Func, Value Func, mergeFunc(if exist 2 key same value -> resolve)
//		Collectors
//        .toMap(p -> p[0], p -> p[1], (s, a) -> s + ", " + a));
		// --> Key Func, Value Func, mergeFunc, Supplier(Default HashMap)
//				To get a LinkedHashMap, we need to give LinkedHashMap::new into this function
		System.out.println("instance: " + sortedMap.getClass());
		sortedMap.forEach((k, v) -> System.out.println(k + " --> " + v));

	}
}
