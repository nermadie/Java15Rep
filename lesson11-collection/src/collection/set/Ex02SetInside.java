package collection.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import bean.Employee;

public class Ex02SetInside {
	public static void main(String[] args) {
		// sort desc by name, asc by salary
//		Comparator<Employee> cmp = new Comparator<>() {
//			@Override
//			public int compare(Employee e1, Employee e2) {
//				int sortByName = e1.getName().compareTo(e2.getName());
//				if (sortByName < 0)
//					return 1;
//				if (sortByName == 0)
//					return Double.compare(e1.getSalary(), e2.getSalary());
//				return -1;
//			}
//		};
		Set<Employee> company = new TreeSet<>(
				Comparator.comparing(Employee::getName, Comparator.reverseOrder()).thenComparing(Employee::getSalary));
		company.add(new Employee(1, "E1", 100d));
		company.add(new Employee(2, "E2", 200d));
		company.add(new Employee(3, "E3", 300d));
		company.add(new Employee(4, "E3", 200d));

		// sort desc by name, asc by salary
//		List<Employee> list = new ArrayList<>(company);
//		list.sort(
//				Comparator.comparing(Employee::getName, Comparator.reverseOrder()).thenComparing(Employee::getSalary));
		System.out.println("size: " + company.size());
		printf(company);
	}

	private static <E> void printf(Set<E> set) {
		for (E e : set)
			System.out.println(e);
	}
}
