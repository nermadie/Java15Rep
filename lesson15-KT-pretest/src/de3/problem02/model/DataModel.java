package de3.problem02.model;

import java.util.Arrays;
import java.util.List;

import de3.problem02.bean.OptimumSleepTime;

public class DataModel {
	private DataModel() {
	}

	public static List<OptimumSleepTime> getOptimumSleepTime() {
		List<OptimumSleepTime> result = Arrays.asList(new OptimumSleepTime("Baby", 1, 20.),
				new OptimumSleepTime("Little Child", 4, 11.), new OptimumSleepTime("Teenager", 14, 9.),
				new OptimumSleepTime("Youth&Adult", 18, 8.), new OptimumSleepTime("Baby", 65, 7.5));
		return result;
	}
}
