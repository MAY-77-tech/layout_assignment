

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReading {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		 //readFile();
		 //readWithFilter();
		//readWithLineNumber();
		copyFile();
	
	}

	static void copyFile() throws IOException
	{
		Path source=Paths.get("test.txt");
		Path destination=Paths.get("copylines.txt");
		//Files.copy(source, destination);
		Files.copy(source, destination,StandardCopyOption.REPLACE_EXISTING);
		System.out.println("success");
		
	}
	static void readWithLineNumber() throws IOException {
		// Line numbering begins at 0
		LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("test.txt"));
		
		String line = null;
		while ((line = lineNumberReader.readLine()) != null)
		{
			System.out.println("line " + lineNumberReader.getLineNumber() + " : " + line);
		}
		lineNumberReader.close();
	}

	static void readWithFilter() {
		Path filePath = Paths.get("test.txt");
		try (Stream<String> lines = Files.lines(filePath)) {
			List<String> filterLines = lines.filter(s -> s.contains("password")).collect(Collectors.toList());
			filterLines.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void readFile() {
		Path filePath = Paths.get("test.txt");
		try (Stream<String> lines = Files.lines(filePath)) {
			lines.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
