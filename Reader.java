import java.io.*;

public class Reader {

	public static int[] readAutoMode() {
		try {
			FileReader reader = new FileReader("AutoMode.txt");
			BufferedReader breader = new BufferedReader(reader);
			return new int[] {Integer.parseInt(breader.readLine()), Integer.parseInt(breader.readLine())};
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
