package view;

import java.util.Arrays;
import java.util.Comparator;

import bean.ItemDetail;
import model.DataModel;

public class Ex05ArraySortWithItemDetail {
	public static void main(String[] args) {
		ItemDetail[] items = DataModel.getItemDetailsWithNull();
		Arrays.sort(items, new Comparator<ItemDetail>() {

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
		System.out.println(Arrays.toString(items));
	}
}
