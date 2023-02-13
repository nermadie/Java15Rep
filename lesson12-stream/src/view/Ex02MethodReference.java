package view;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import bean.Trader;
import model.DataModel;

public class Ex02MethodReference {
	public static void main(String[] args) {
		List<Trader> traders = DataModel.getTraders();
		Set<String> cities = map(traders, trader -> trader.getCity());
		cities = map(traders, Trader::getCity);
		cities = map(traders, Ex02MethodReference::getCity);
		cities.forEach(System.out::println);
	}

//	   --> Non-static: Method reference ==> T::getF
//			Require getF is a function in class T 
//	   --> Static: method reference ==> X|T::any
//			X|T
//		public static R any(T t) {
//				return t.getF();
//		}
	private static String getCity(Trader trader) {
		return trader.getCity();
	}

	private static <R> Set<R> map(List<Trader> traders, Function<Trader, R> f) {
		Set<R> result = new HashSet<>();
		for (Trader trader : traders) {
			result.add(f.apply(trader));
		}
		return result;
	}
}
