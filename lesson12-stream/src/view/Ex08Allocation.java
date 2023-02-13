package view;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import bean.Store;
import model.DataModel;

public class Ex08Allocation {
	public static void main(String[] args) {
		List<Store> stores = DataModel.getStores();
		// 1. Get all stores which have stock previous day greater than 15
		stores.stream().filter(store -> store.getNonNullStockPreviousDay().compareTo(bd(15)) == 1)
				.forEach(System.out::println);
		System.out.println("===");
		// 2. Get all stores which have stock previous day greater than expected sales
		// today
		// and sort them store id descending
		stores.stream()
				.filter(store -> store.getNonNullStockPreviousDay().compareTo(store.getNonNullExpectedSales()) == 1)
				.forEach(System.out::println);
		System.out.println("===");
		// 3. Get stores have no reference store and return list of store ids
		stores.stream().filter(store -> store.getReferenceStoreId() == null).map(Store::getStoreId)
				.forEach(System.out::println);
		System.out.println("===");
		// 4. Distinct stores by stock previous day 1 2 2 3 -- distinct -- 1 2 3
		stores.stream().map(Store::getStockPreviousDay).distinct().forEach(System.out::println);
		stores.stream().filter(distinctBy(Store::getStockPreviousDay)).forEach(System.out::println);
		System.out.println("===");
		// 5. Get first 2 stores with max expected sales
		stores.stream().filter(store -> store.getExpectedSales() != null)
				.sorted(Comparator.comparing(Store::getExpectedSales).reversed()).limit(2).forEach(System.out::println);
		System.out.println("===");
		// 6. Get list of reference stores
		stores.stream().map(Store::getReferenceStoreId).filter(Objects::nonNull).forEach(System.out::println);
		System.out.println("===");
		// 7. Is there any store has no expected sales
		System.out.println("Is there any store has no expected sales? "
				+ stores.stream().anyMatch(store -> store.getExpectedSales() == null));
		System.out.println("===");
		/*
		 * 8. Calculate and return list of store's expected sales which has no expected
		 * sales - store has not expected sales but // + has reference store which
		 * maintained expected sales --> use expected sales of reference store // + has
		 * reference store which no maintained expected sales --> use average of store's
		 * expected sales with it's own(reference store not count)
		 * 
		 * // + has no reference store --> use average of store's expected sales with
		 * it's own(reference store not count)
		 */
		// flatMap, primitive stream, match, optional
		// IntStream --> boxed --> Stream<Integer>
		long count = stores.stream().filter(store -> store.getExpectedSales() != null).count();
		BigDecimal average = stores.stream().filter(store -> store.getExpectedSales() != null)
				.map(Store::getExpectedSales).reduce(bd(0), (bd1, bd2) -> bd1.add(bd2))
				.divide(BigDecimal.valueOf(count));
		System.out.println(average);
		stores.stream().map(store -> {
			BigDecimal expectedSales = store.getExpectedSales();
			if (expectedSales == null) {
				Long refStoreId = store.getReferenceStoreId();
				BigDecimal expectedSaleOfRefStore = stores.stream().filter(s -> s.getStoreId() == refStoreId)
						.map(Store::getNonNullExpectedSales).findFirst().orElse(bd(0));
				if (expectedSaleOfRefStore.compareTo(bd(0)) == 0)
					return average;
				else
					return expectedSaleOfRefStore;
			} else
				return expectedSales;
		}).forEach(System.out::println);

		System.out.println("===");
		// 9. Calculate sum of expected sales today
		System.out.println("Sum of expected sales today: "
				+ stores.stream().map(Store::getNonNullExpectedSales).reduce(bd(0), (bd1, bd2) -> bd1.add(bd2)));
		System.out.println("===");
		// 10. Find store which has max stock previous day
		// if many stores have same stock previous day, use the one with smallest store
		// id
		System.out.println("Max stock previous day store: " + stores.stream().sorted(
				Comparator.comparing(Store::getNonNullStockPreviousDay).reversed().thenComparing(Store::getStoreId))
				.findFirst().orElse(null));
	}

	private static <T, R> Predicate<T> distinctBy(Function<T, R> function) {
		Set<R> storage = new HashSet<>();
		return t -> storage.add(function.apply(t));
	}

	private static BigDecimal bd(long value) {
		return BigDecimal.valueOf(value);
	}
}
