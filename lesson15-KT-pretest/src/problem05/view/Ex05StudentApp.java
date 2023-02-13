package problem05.view;

import java.io.File;
import java.util.List;

import problem05.bean.Student;
import problem05.utils.FileUtils;

public class Ex05StudentApp {
	private static final String pathname = String.join(File.separator, "data", "student.txt");

	public static void main(String[] args) {
		File file = new File(pathname);
		List<Student> students = FileUtils.readObjects(file);
		students.forEach(System.out::println);
	}
}
