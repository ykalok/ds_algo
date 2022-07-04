package FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingEntireFileWithoutLoop {
	public static void main(String[] args) throws FileNotFoundException {
		String fileName ="src/main/resources/file.txt";
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		sc.useDelimiter("\\Z");
		System.out.println(sc.next());
	}

}
