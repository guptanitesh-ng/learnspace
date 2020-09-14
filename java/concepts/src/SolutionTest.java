import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolutionExecute1() {
		File file = new File("input.txt");
		try (PrintWriter writer = new PrintWriter(file)) {
			writer.println("Server3, Language, Python, 2.7.1");
			writer.println("Server2, Language, Python, 2.6.3");
			writer.println("Server1, Language, Python, 2.8.3");
			writer.println("Server0, Language, Python, 3.0.0");
			writer.println("ServerA, Language, Java, 1.8.141");
			writer.println("ServerB, Language, Java, 1.7.64");
			writer.println("ServerC, Language, Java, 1.6.19");
			writer.println("ServerX, AS, JBOSS, 4.0.5");
			writer.println("ServerY, AS, JBOSS, 6.5.7");
			writer.println("ServerZ, AS, JBOSS, 8.0.1");
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file to write to ");
			e.printStackTrace();
		}
		Solution.main(null);
		Set<String> output = new HashSet<>();
		output.add("Server1");
		output.add("Server2");
		output.add("ServerB");
		output.add("ServerX");
		output.add("ServerY");
		output.add("Server3");
		output.add("ServerC");

		try (BufferedReader reader = new BufferedReader(new FileReader(new File("output.txt")))) {
			String outputLine;
			while ((outputLine = reader.readLine()) != null)
				assertTrue(output.contains(outputLine));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Output file not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// @Test
	public void testSolutionExecute() {
		File file = new File("input.txt");
		try (PrintWriter writer = new PrintWriter(file)) {
			writer.println("Server1, Database, MySQL, 5.5");
			writer.println("Server2, Database, MySQL, 5.1");
			writer.println("Server3, OS, Ubuntu, 10.04");
			writer.println("Server1, OS, Ubuntu, 12.04");
			writer.println("Server2, OS, Ubuntu, 12.04");
			writer.println("Server3, Language, Python, 2.6.3");
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file to write to ");
			e.printStackTrace();
		}
		Solution.main(null);
		Set<String> output = new HashSet<>();
		output.add("Server2");
		output.add("Server3");
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("output.txt")))) {
			String outputLine;
			while ((outputLine = reader.readLine()) != null)
				assertTrue(output.contains(outputLine));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Output file not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
