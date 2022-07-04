package FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ReadingFileUsingBufferReader {

	public static void main(String[] args) throws IOException {
		String fileName ="src/main/resources/file.txt";
		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while((st=br.readLine())!=null) {
			System.out.println(st);
		}
		

	}

}
