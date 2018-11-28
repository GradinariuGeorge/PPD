package listThreads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Logger {

	static String logFile = "logs.log";
	static {
		Path file = Paths.get(logFile);
		try {
			Files.write(file, new ArrayList<>(), Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized static void log(String logLine) {

		Path file = Paths.get(logFile);
		try {
			List<String> lines = Files.readAllLines(file);
			lines.add(logLine);
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
