package de3.problem03;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Ex03AnagramApp {
	public static void main(String[] args) {
		String originStr = "Tom Marvolo Riddle";
		String compareStr = "I am Lord Voldemort";
		System.out.println(isAnagram(originStr, compareStr));
	}

	private static boolean isAnagram(String originStr, String compareStr) {
		Map<String, Integer> oriMap = getMapAppearedChar(originStr.toLowerCase());
		Map<String, Integer> comMap = getMapAppearedChar(compareStr.toLowerCase());
		Set<Entry<String, Integer>> oriEntrySet = oriMap.entrySet();
		Set<Entry<String, Integer>> comEntrySet = comMap.entrySet();
		if (oriEntrySet.size() != comEntrySet.size())
			return false;
		for (Entry entry : oriEntrySet) {
			String charTemp = (String) entry.getKey();
			if (comMap.containsKey(charTemp)) {
				if (!(comMap.get(charTemp) == entry.getValue()))
					return false;
			} else
				return false;
		}
		return true;
	}

	private static Map<String, Integer> getMapAppearedChar(String input) {
		Map<String, Integer> result = new TreeMap<>();
		for (int i = 0; i < input.length(); i++) {
			String charTemp = input.substring(i, i + 1);
			if (charTemp.matches("[a-z]")) {
				if (result.containsKey(charTemp))
					result.put(charTemp, result.get(charTemp) + 1);
				else
					result.put(charTemp, 1);
			}
		}
		return result;
	}
}
