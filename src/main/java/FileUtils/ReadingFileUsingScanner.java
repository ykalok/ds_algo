package FileUtils;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ReadingFileUsingScanner {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		String fileName="src/main/resources/file.txt";
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()){
			System.out.println(sc.nextLine());
			
		}
	}

	
	

}
