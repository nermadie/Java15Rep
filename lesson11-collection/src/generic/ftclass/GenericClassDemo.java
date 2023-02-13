package generic.ftclass;

public class GenericClassDemo {
	public static void main(String[] args) {
		IList<Integer> numbers = new CustomList<>();

		numbers.add(2);
		numbers.add(5);
		numbers.add(8);

		System.out.println("size: " + numbers.size());
		numbers.iterate(number -> System.out.println(number + " "));
		System.out.println("Capacity: " + numbers.getCapacity());
		numbers.add(2);
		numbers.add(5);
		numbers.add(8);
		System.out.println("Capacity: " + numbers.getCapacity());
		System.out.println("Size: " + numbers.size());
		// do not support forEach
		// do not support iterate
	}
}
