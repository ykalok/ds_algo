package FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ReadFileIntoList {
	
	public static void main(String[] args) throws IOException {
		String fileName ="src/main/resources/file.txt";
		List<String> data =readFileInList(fileName);
		Iterator<String> itr = data.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	private static List<String> readFileInList(String fileName) {
		List<String> list = Collections.emptyList();
		try {
			list=Files.readAllLines(Paths.get(fileName),StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
