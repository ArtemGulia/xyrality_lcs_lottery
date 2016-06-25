# xyrality_lcs_lottery
LCS Lottery

The LCS lottery lets people enter with a ticket number into a lottery. 
A winning number is drawn and every person gets credits in the amount of the longest common subsequence (LCS) 
with their own ticket number.
The LCS is the longest (not necessarily contiguous) shared subsequence in two strings.
For example the strings 1234567890 and 13153137531 share the LCS of 1357:

A= 1 2 3 4 5 6 7 8 9 0
B= 1 3 1 5 3 1 3 7 5 3 1
LCS= 1 3 5 7

Given a winning ticket number, every participant wins x credits for a ticket with an
LCS of length x with the winning number. If a participant has multiple tickets that win credits, 
they win the sum of credits for all their tickets.

An example: Winning number: 456000123, input file as given above

Alison,Alice,Austria,1234567890 -> LCS 4560, 4 credits
Bert,Bertram,Belgium,0987654321 -> LCS 63 (or 53, 43, 03, ...), 2 credits
Alison,Alice,Austria,9988776650 -> LCS 50 (or 60), 2 credits
Carlson,Cynthia,China,1111999911 -> LCS 1, 1 credit
Carlson,Cynthia,Chile,1122334455 -> LCS 123, 3 credits
Daneson,Dan Dilbert,Denmark,4680468023 -> LCS 460023, 6 credits
Dilbert Daneson,Dan,Denmark,0000000000 -> LCS 000, 3 credits
Eggbert,Eric,Estonia,9988778899 -> none, 0 credits

Output result:
Alison,Alice,Austria,6
Bert,Bertram,Belgium,2
Carlson,Cynthia,Chile,3
Carlson,Cynthia,China,1
Daneson,Dan Dilbert,Denmark,6
Dilbert Daneson,Dan,Denmark,3
