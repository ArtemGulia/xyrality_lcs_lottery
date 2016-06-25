package lcs.lottery.service;

import lcs.lottery.entity.Participant;

import java.util.Collections;
import java.util.List;

public class LotteryGameService {
	private String winCombination; // Winning combination for current service
	private List<Participant> participants; //Participants of this Lottery service

	public LotteryGameService(String winCombination, List<Participant> participants) {
		this.winCombination = winCombination;
		this.participants = participants;
	}


	/**
	 * Calculating and printing the results of the Lottery service
	 */
	public void printResults() {
		calculateResults();
		//Sorting Participants by last name ascending, then first name ascending, then country ascending.
		Collections.sort(participants);
		for (Participant participant : participants) {
			if (participant.getCredits() > 0) {
				System.out.println(participant);
			}
		}

	}

	private void calculateResults() {
		if (winCombination != null && participants != null && !participants.isEmpty()) {
			for (Participant participant : participants) {
				for (String ticket : participant.getTickets()) {
					participant.addCredit(checkTicketNumber(ticket));
				}
			}
		}
	}

	/**
	 * Method checking the winning combination and participant ticket.
	 *
	 * @param participantTicket ticket to check
	 * @return length of LCS
	 */	public int checkTicketNumber(String participantTicket) {
		if (participantTicket == null || participantTicket.length() == 0) {
			return 0;
		}

		int wLength = winCombination.length();
		int tLength = participantTicket.length();
		int[][] lcs = new int[wLength + 1][tLength + 1];

		// compute length of LCS and all sub-problems
		for (int i = 0; i < wLength; i++) {
			for (int j = 0; j < tLength; j++) {
				// If last characters of prefixes match, add one to former value.
				if (winCombination.charAt(i) == participantTicket.charAt(j)) {
					lcs[i + 1][j + 1] = lcs[i][j] + 1;
				} else {// Otherwise, take the maximum of the two adjacent cases.
					lcs[i + 1][j + 1] = Math.max(lcs[i + 1][j], lcs[i][j + 1]);
				}
			}
		}

		return lcs[wLength][tLength];
	}
}
