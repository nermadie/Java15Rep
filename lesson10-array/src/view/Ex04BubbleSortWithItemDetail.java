package view;

import bean.ItemDetail;
import model.DataModel;
import utils.CompareObjectHelper;

public class Ex04BubbleSortWithItemDetail {
	public static void main(String[] args) {
		ItemDetail[] items = DataModel.getItemDetails();

		// ASC by store
		// DESC by itemId of same storeId
		sort(items, new CompareObjectHelper() {
			@Override
			public int compare(ItemDetail i1, ItemDetail i2) {
				int storeId1 = i1.getItemId();
				int storeId2 = i2.getItemId();
				if (storeId1 != storeId2)
					return i1.getStoreId() - i2.getStoreId();
				return i2.getItemId() - i1.getItemId();
			}
		});
		for (ItemDetail item : items)
			System.out.println(item);

		items = DataModel.getItemDetailsWithNull();

		// null first
		// ASC by store
		// DESC by itemId of same storeId
		System.out.println("=============");
		sort(items, new CompareObjectHelper() {
			@Override
			public int compare(ItemDetail i1, ItemDetail i2) {
				if (i1 == null)
					return -1;
				if (i2 == null)
					return 1;
				int storeId1 = i1.getItemId();
				int storeId2 = i2.getItemId();
				if (storeId1 != storeId2)
					return i1.getStoreId() - i2.getStoreId();
				return i2.getItemId() - i1.getItemId();
			}
		});
		for (ItemDetail item : items)
			System.out.println(item);
	}

	private static void sort(ItemDetail[] elements, CompareObjectHelper helper) {
		for (int round = 0; round < elements.length; round++)
			for (int i = 0; i < elements.length - round - 1; i++)
				if (helper.compare(elements[i], elements[i + 1]) > 0)
					swap(elements, i, i + 1);
	}

	private static <T> void swap(T[] source, int i, int j) {
		T temp = source[i];
		source[i] = source[j];
		source[j] = temp;
	}
}
