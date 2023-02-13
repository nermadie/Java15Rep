package view;

import java.util.Arrays;
import java.util.Comparator;

import bean.ItemDetail;
import model.DataModel;

public class Ex06ArraySortWithItemDetailV2 {
	public static void main(String[] args) {
		ItemDetail[] items = DataModel.getItemDetailsWithNull();
		Arrays.sort(items, Comparator.nullsFirst(Comparator.comparing(ItemDetail::getStoreId, Comparator.reverseOrder())
				.thenComparing(ItemDetail::getItemId)));
	}
}
