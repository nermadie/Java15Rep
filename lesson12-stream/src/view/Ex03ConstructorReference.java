package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import bean.Trader;

public class Ex03ConstructorReference {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Terry", "Ricardo", "Toure");
		List<String> cities = Arrays.asList("Milan", "London", "NewYork");
		// Convert names, cities --> traders
		List<Trader> traders = map(names, cities, new BiFunction<String, String, Trader>() {
			@Override
			public Trader apply(String t, String u) {
				return new Trader(t, u);
			}
		});
		traders = map(names, cities, (t, u) -> new Trader(t, u));
		traders = map(names, cities, Ex03ConstructorReference::mapping);
		traders = map(names, cities, Trader::new);
		traders.forEach(System.out::println);
	}
	// Trader:: new 2 parameters --> BiFunction
	// Trader:: new 1 parameters --> Function
	// Trader:: new 0 parameters --> Supplier

	public static Trader mapping(String t, String u) {
		return new Trader(t, u);
	}

	private static <T, U> List<Trader> map(List<T> ts, List<U> us, BiFunction<T, U, Trader> bf) {
		// strategy: (E, T) -> Trader
		List<Trader> traders = new ArrayList<>();
		for (int i = 0; i < ts.size(); i++) {
//			Trader trader = new Trader(names.get(i), cities.get(i));
			Trader trader = bf.apply(ts.get(i), us.get(i));
			traders.add(trader);
		}
		return traders;
	}
}
