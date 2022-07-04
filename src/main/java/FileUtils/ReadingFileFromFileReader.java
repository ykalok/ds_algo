package FileUtils;

import java.io.FileReader;
import java.io.IOException;

public class ReadingFileFromFileReader {
	public static void main(String[] args) throws IOException {
		String fileName ="src/main/resources/file.txt";
		FileReader fr = new FileReader(fileName);
		int i;
		while((i=fr.read())!=-1) {
			System.out.print((char)i);
		}
	}
	

}
