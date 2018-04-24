import java.io.*;
import java.util.*;

public class Reader {

	public static ArrayList<Integer> readAutoMode() {
		try {
			ArrayList<Integer> result = new ArrayList<Integer>();
			FileReader reader = new FileReader("AutoMode.txt");
			BufferedReader breader = new BufferedReader(reader);
			String str;
			for(String line = breader.readLine(); line != null; line = breader.readLine()) {
				result.add(Integer.parseInt(line));
			}
			return result;
			//return new int[] {Integer.parseInt(breader.readLine()), Integer.parseInt(breader.readLine())};
		} catch (IOException e) {
			System.out.println("Textfile was not found.");
		}
		return null;
	}

	public static String readFunction() {
		try {
			FileReader reader = new FileReader("Function.txt");
			BufferedReader breader = new BufferedReader(reader);
			return breader.readLine();
		} catch (IOException e) {
			System.out.println("Textfile was not found.");
		}
		return null;
	}
}
