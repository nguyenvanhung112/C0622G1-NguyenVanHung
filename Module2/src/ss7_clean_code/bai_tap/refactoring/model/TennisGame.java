package ss7_clean_code.bai_tap.refactoring.model;

public class TennisGame {
    private static final int LOVE = 0;
    private static final int FIFTEEN = 1;
    private static final int THIRTY = 2;
    private static final int FORTY = 3;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String score = "";
        int tempScore = 0;
        boolean isEqual = player1Score == player2Score;
        boolean isAvantage = player1Score >= 4 || player2Score >= 4;
        if (isEqual) {
            switch (player1Score) {
                case LOVE:
                    return "Love-All";
                case FIFTEEN:
                    return "Fifteen-All";
                case THIRTY:
                    return "Thirty-All";
                case FORTY:
                    return "Forty-All";
                default:
                    return "Deuce-All";

            }
        } else if (isAvantage) {
            int minusResult = player1Score - player2Score;
            if (minusResult == 1) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = player1Score;
                else {
                    score += "-";
                    tempScore = player2Score;
                }
                switch (tempScore) {
                    case LOVE:
                        return "Love";
                    case FIFTEEN:
                        return  "Fifteen";
                    case THIRTY:
                        return "Thirty";
                    case FORTY:
                         return "Forty";
                }
            }
        }
        return score;
    }
}


