package libraryAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {

	public static String staticJsonReader(String path) throws IOException {

		// jsonBodyAsString variable stores complete body as string
		String jsonBodyAsString = new String(Files.readAllBytes(Paths.get(path)));

		return jsonBodyAsString;
	}

}
