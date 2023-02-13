package view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

import bean.ItemDetail;
import model.DataModel;

public class Ex08ArraysSortWithItemDetailV3 {
	public static void main(String[] args) {
		ItemDetail[] items = DataModel.getItemDetails();

		Arrays.sort(items);
		System.out.println("1st sorted items: " + Arrays.toString(items));

		Arrays.sort(items, Comparator.comparing(Function.identity()));
		// Refer --> 2nd way(Comparator)
		// + Reduce code in T class
		// + Catch error at compile
		// + Comparator supports multiple soring function concurrently
	}
}
