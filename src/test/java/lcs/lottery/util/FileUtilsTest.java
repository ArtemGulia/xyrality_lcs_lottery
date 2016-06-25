package lcs.lottery.util;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtilsTest extends TestCase {

	public void testCorrectFile() throws Exception {
		Map<String, List<String>> pMap = new HashMap<>();
		List<String> ticket = new ArrayList<>();
		ticket.add("1234567890");
		pMap.put("Alison,Alice,Austria", ticket);
		assertEquals(pMap,
				FileUtils.readFile("test1.txt"));
	}

	public void testNoFile() throws Exception {
		assertEquals(Collections.emptyMap(),
				FileUtils.readFile(null));
	}

	public void testWrongFile() throws Exception {
		assertEquals(Collections.emptyMap(),
				FileUtils.readFile("123"));
	}
}