package lcs.lottery;

import lcs.lottery.entity.Participant;
import lcs.lottery.service.LotteryGameService;
import lcs.lottery.util.ParticipantUtils;

import java.util.List;

public class LCSLottery {

    public static void main(String[] args) {
        if (args.length == 2) {
            String fileName = args[0];
            String wCombination = args[1];

            List<Participant> participants = ParticipantUtils.readParticipants(fileName);

            LotteryGameService game = new LotteryGameService(wCombination, participants);
            game.printResults();
        } else {
            System.err.println("Please provide correct input arguments. <Input file name> <Winning combination>");
        }
    }
}
