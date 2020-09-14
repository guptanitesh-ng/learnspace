import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Initcap {

	public static void main(String[] args) {

		if (args == null || args.length != 1)
			throw new IllegalArgumentException();

		File dir = new File(args[0]);
		if (!dir.isDirectory() || !dir.exists())
			throw new IllegalArgumentException("No such directory " + dir.getPath());

		File[] files = dir.listFiles();
		for (File file : files) {
			try (BufferedReader reader = new BufferedReader(new FileReader(file));
					PrintWriter writer = new PrintWriter(new File(dir, file.getName() + "_output.txt"))) {
				String inputLine;
				while ((inputLine = reader.readLine()) != null) {
					char[] inputLineChar = inputLine.toCharArray();
					for (int i = 0; i < inputLineChar.length; i++) {
						int c = inputLineChar[i];
						if (i == 0 && (c >= 97 && c <= 122)) {
							inputLineChar[i] = (char) ((int) c - 32);
						} else if (c == 32) {
							c = inputLineChar[i + 1];
							if (c >= 97 && c <= 122)
								inputLineChar[i + 1] = (char) ((int) c - 32);
						}
					}
					writer.println(inputLineChar);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
