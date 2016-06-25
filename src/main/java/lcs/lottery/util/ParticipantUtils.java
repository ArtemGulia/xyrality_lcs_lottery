package lcs.lottery.util;

import lcs.lottery.entity.Participant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParticipantUtils {

	/**
	 * Method fore reading list of Participants from the file.
	 * For reading file using FileUtils
	 * @param fileName - fileName of the file with participants
	 * @return List of participants
	 */
	public static List<Participant> readParticipants(String fileName) {
		Map<String, List<String>> pMap = FileUtils.readFile(fileName);

		List<Participant> participants = new ArrayList<>();

		if (!pMap.isEmpty()) {
			for (Map.Entry<String, List<String>> pEntry : pMap.entrySet()) {
				participants.add(getEntity(pEntry));
			}
		}
		return participants;
	}

	private static Participant getEntity(Map.Entry<String, List<String>> pEntry) {
		String[] pInfo = pEntry.getKey().split(FileUtils.COMMA);
		return fillEntity(pInfo, pEntry.getValue());
	}

	private static Participant fillEntity(String[] pInfo, List<String> tickets) {
		return new Participant(pInfo[0], pInfo[1], pInfo[2], tickets);
	}
}
