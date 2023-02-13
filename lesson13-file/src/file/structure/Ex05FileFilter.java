package file.structure;

import java.io.File;
import java.util.Arrays;

import utils.FileUtils;

public class Ex05FileFilter {
	private static String dirPath = "storage" + File.separator + "random";

	public static void main(String[] args) {
		File dir = FileUtils.createRandomFiles(dirPath, 30, "txt", "java", "png", "mp3", "mp4", "exe");
		System.out.println("dir --> " + dir);

//		dir.listFiles(new FileFilter() {
//			
//			@Override
//			public boolean accept(File file) {
//				return file.isFile() && file.getName().endsWith(".exe");
//			}
//		});
		File[] exeFiles = dir.listFiles(file -> file.isFile() && file.getName().endsWith(".exe"));
//		Arrays.stream(exeFiles).forEach(System.out::println);
		Arrays.stream(exeFiles).forEach(File::delete);
	}
}
