package FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadTextAsString {
	public static void main(String[] args) throws IOException {
		String fileName ="src/main/resources/file.txt";
		String data =readFileAsString(fileName);
		System.out.println(data);
	}

	private static String readFileAsString(String fileName) throws IOException {
		// TODO Auto-generated method stub
		String data="";
		data = new String(Files.readAllBytes(Paths.get(fileName)));
		return data;
	}


}
