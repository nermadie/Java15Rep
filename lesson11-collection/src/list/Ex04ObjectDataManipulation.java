package list;

import java.util.Arrays;
import java.util.List;

import bean.Item;

public class Ex04ObjectDataManipulation {
	public static void main(String[] args) {
		List<Item> items = getItems();
		// contains, remove
		Item itemX = new Item(1, "Item 1", 100, 1);
		items.remove(itemX);
		System.out.println(items);
	}

	private static List<Item> getItems() {
		// java.util.ArrayList --> Dynamic size
		// java.util.Arrays.ArrayList --> Fixed size
		return Arrays.asList(new Item(1, "Item 1", 100, 1), new Item(2, "Item 2", 200, 1),
				new Item(3, "Item 3", 300, 2), new Item(4, "Item 4", 400, 2));
	}
}
