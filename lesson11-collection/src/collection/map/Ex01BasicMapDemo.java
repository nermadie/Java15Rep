package collection.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

// Lưu trữ, quản lý danh sách ký hiệu biển số xe
// từng tỉnh thành ở Việt Nam
// --> Ký hiệu biển số, thành phố tưởng ứng
// 		-> 92, Quảng Nam 
// 		-> 43, Đà Nẵng
// 		-> 75, Thừa Thiên Huế
// 		-> 74, Quảng Trị
// 		-> 73, Quảng Bình
//--> Map --> HashMap, LinkedHashMap, TreeMap
//	HashMap: Không duy trì thứ tự các phần tử đưa vào
// 	LinkedHashMap: Duy trì thứ tự các phần tử đưa vào
//	TreeMap: Tự động sắp xếp theo KEY -> KEY yêu cầu con của Comparable<K>
public class Ex01BasicMapDemo {
	public static void main(String[] args) {
		Map<Integer, String> model = new TreeMap<>((k1, k2) -> k2 - k1);
		model = new TreeMap<>(Comparator.reverseOrder());
		model.put(92, "Quảng Nam");
		model.put(43, "Đà Nẵng");
		model.put(75, "Thừa Thiên Huế");
		model.put(74, "Quảng Trị");
		model.put(73, "Quảng Bình");
//		model.put(43, "DN");
//		model.putIfAbsent(43, "DN");
		model.remove(43);

		System.out.println("model size --> " + model.size());
		if (model.containsKey(43))
			System.out.println("key 43 --> " + model.get(43));
		printf(model);
	}

	private static void printf(Map<Integer, String> map) {
		Set<Entry<Integer, String>> entries = map.entrySet();
		for (Entry<Integer, String> entry : entries)
			System.out.println(entry.getKey() + "--> " + entry.getValue());

	}
}
