package lcs.lottery.util;

import junit.framework.TestCase;
import lcs.lottery.entity.Participant;

import java.util.ArrayList;
import java.util.List;

public class ParticipantUtilsTest extends TestCase {

	private String[] fileNames;

	public void setUp() throws Exception {
		super.setUp();
		fileNames = new String[2];
		fileNames[0] = "test1.txt";
		fileNames[1] = "test2.txt";
	}

	public void testReadParticipant() throws Exception {
		List<String> ticket = new ArrayList<>();
		ticket.add("1234567890");
		Participant alison = new Participant("Alison", "Alice","Austria", ticket);
		List<Participant> participants = new ArrayList<>();
		participants.add(alison);
		assertEquals(participants,
				ParticipantUtils.readParticipants(fileNames[0]));
	}


	public void testReadOfTwoParticipants() throws Exception {
		List<String> ticket = new ArrayList<>();
		ticket.add("12345");
		Participant dan = new Participant("Daneson", "Dan Dilbert","Denmark", ticket);
		List<String> ticket2 = new ArrayList<>();
		ticket.add("54321");
		Participant dan2 = new Participant("Dilbert Daneson", "Dan","Denmark", ticket2);
		List<Participant> participants = new ArrayList<>();
		participants.add(dan);
		participants.add(dan2);
		assertEquals(participants,
				ParticipantUtils.readParticipants(fileNames[1]));

	}
}