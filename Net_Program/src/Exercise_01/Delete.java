package Exercise_01;

import java.io.File;

public class Delete {

	public static boolean delete(String path) {
		File file = new File(path);
		if (!file.exists())
			return true;

		File[] files = file.listFiles();
		if (files != null)
			for (File f : files) {
				delete(f.getAbsolutePath());
			}
		return true;

	}

	public static void main(String[] args) {
		String path = "D:\\Test";
		System.out.println(delete(path));
	}

}
