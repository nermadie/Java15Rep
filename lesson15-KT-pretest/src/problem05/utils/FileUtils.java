package problem05.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.List;

public class FileUtils {
	private FileUtils() {
	}

	public static Object readObject(File file) {
		Object object = null;
		if (file.exists()) {
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			try {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);

				object = ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				FileUtils.close(ois, fis);
			}
		}
		return object;
	}

	public static void close(AutoCloseable... autoCloseables) {
		Arrays.stream(autoCloseables).forEach(t -> {
			try {
				t.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> readObjects(File file) {
		return (List<T>) readObject(file);
	}
}
