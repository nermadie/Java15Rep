package de3.problem02.bean;

public class OptimumSleepTime {
	private String subject;
	private Integer age;
	private Double minSleepTime;

	public OptimumSleepTime() {
	}

	public OptimumSleepTime(String subject, Integer age, Double minSleepTime) {
		this.subject = subject;
		this.age = age;
		this.minSleepTime = minSleepTime;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getMinSleepTime() {
		return minSleepTime;
	}

	public void setMinSleepTime(Double minSleepTime) {
		this.minSleepTime = minSleepTime;
	}

	@Override
	public String toString() {
		return "OptimumSleepTime [subject=" + subject + ", age=" + age + ", minSleepTime=" + minSleepTime + "]";
	}
}
