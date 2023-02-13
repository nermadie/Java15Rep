package de3.problem02.view;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import de3.problem02.bean.OptimumSleepTime;
import de3.problem02.model.DataModel;

public class Ex02SleepHelperApp {
	private static final String PATTERN = "HH:mm";

	public static void main(String[] args) {
		Integer age = 22;
		LocalTime sleepedTime = LocalTime.of(1, 15);
		LocalTime startSleepingTime = LocalTime.of(23, 0);
		List<OptimumSleepTime> ostTable = DataModel.getOptimumSleepTime();
		LocalTime wakeUpTime = getWakeUpTime(ostTable, age, sleepedTime, startSleepingTime);

		DateTimeFormatter df = DateTimeFormatter.ofPattern(PATTERN);
		System.out.println(df.format(wakeUpTime));
	}

	private static LocalTime getWakeUpTime(List<OptimumSleepTime> ostTable, Integer age, LocalTime sleepedTime,
			LocalTime startSleepingTime) {
		LocalTime result = startSleepingTime;
		List<Double> listTime = ostTable.stream().filter(ost -> ost.getAge() <= age)
				.map(OptimumSleepTime::getMinSleepTime).collect(Collectors.toList());
		Double ostTime = listTime.get(listTime.size() - 1);
		LocalTime ostLocalTime = LocalTime.of(ostTime.intValue(),
				(int) (30 * (Math.round(ostTime) - ostTime.intValue())));
		result = result.minusSeconds(sleepedTime.toSecondOfDay()).plusSeconds(ostLocalTime.toSecondOfDay());
		return result;
	}
}
