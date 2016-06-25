package lcs.lottery.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtils {
	public static final String COMMA = ",";
	private static Charset charset = Charset.forName("UTF-8");

	/**
	 * Method for reading file
	 *
	 * @param fileName - file to read
	 * @return Map of information parsed from the file
	 */
	public static Map<String, List<String>> readFile(String fileName) {
		if (fileName == null || fileName.isEmpty()) {
			return Collections.emptyMap();
		}
		Map<String, List<String>> pMap = new HashMap<>();

		try {
			Path path = Paths.get(fileName);
			try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
				String line = null;

				//Helper map for easier parsing of line into Participant Entity
				while ((line = reader.readLine()) != null) {
					parseTheLine(line, pMap);
				}

			} catch (IOException ex) {
				System.err.format("IOException, fileName = %s%n : %s%n", fileName, ex);
			}
		} catch (InvalidPathException ex) {
			System.err.format("InvalidPathException, fileName = %s%n : %s%n", fileName, ex);
		}
		return pMap;
	}

	/**
	 * Helper method for parsing previously read line with participant information and storing it into provided map
	 *
	 * @param line - Parameter to parse with participant information
	 * @param pMap - Map, where will be stored information
	 */
	private static void parseTheLine(String line, Map<String, List<String>> pMap) {
		if (pMap == null) {
			pMap = new HashMap<>();
		}

		String pInformation = line.substring(0, line.lastIndexOf(COMMA));
		String combination = line.substring(line.lastIndexOf(COMMA) + 1, line.length());

		if (pMap.containsKey(pInformation)) {
			List<String> combinations = pMap.get(pInformation);
			combinations.add(combination);
		} else {
			List<String> combinations = new ArrayList<>();
			combinations.add(combination);
			pMap.put(pInformation, combinations);
		}
	}
}
