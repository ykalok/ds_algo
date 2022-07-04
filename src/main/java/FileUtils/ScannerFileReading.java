package FileUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFileReading {

	public static void main(String[] args) {
		String fileName ="src/main/resources/file.txt";
		try {
			System.setIn(new FileInputStream(fileName));
			Scanner sc = new Scanner(System.in);
			int T= sc.nextInt();
			System.out.println("test: "+ T);
			for(int i=0;i<T;i++) {
				int r =sc.nextInt();
				int k=sc.nextInt();
				System.out.println("r: "+ r+" "+ "k: "+k);
				for(int j=0;j<r;j++) {
					String x=sc.next();
					System.out.println("value: "+x);
				}
					
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
