package fr.mamadou.tenniskata.scorecalculator;

import fr.mamadou.tenniskata.game.Player;

import static fr.mamadou.tenniskata.constant.ScoreConstants.WIN_GAME;
import static fr.mamadou.tenniskata.constant.ScoreConstants.DEUCE;
import static fr.mamadou.tenniskata.constant.ScoreConstants.ADVANTAGE_FOR;
import static fr.mamadou.tenniskata.constant.ScoreConstants.SLASH_SEPARATOR;
import static fr.mamadou.tenniskata.constant.ScoreConstants.COLON_SEPARATOR;
import static fr.mamadou.tenniskata.constant.ScoreConstants.POINTS;
import static fr.mamadou.tenniskata.constant.ScoreConstants.THIRD_BALL_WON;


public class ScoreCalculator implements IScoreCalculator {

    @Override
    public String evaluateScore(Player firstPlayer, Player secondPlayer) {
        StringBuilder scoreBuilder = new StringBuilder();

        final int firstPlayerScore = firstPlayer.getScore();
        final int secondPlayerScore = secondPlayer.getScore();

        if (isWon(firstPlayerScore, secondPlayerScore)) {
            scoreBuilder.append(getPlayerNameWithMorePoints(firstPlayer, secondPlayer));
            scoreBuilder.append(WIN_GAME);
        } else if (isDeuce(firstPlayerScore, secondPlayerScore)) {
            scoreBuilder.append(DEUCE);
        } else if (isAdvantage(firstPlayerScore, secondPlayerScore)) {
            scoreBuilder.append(ADVANTAGE_FOR).append(getPlayerNameWithMorePoints(firstPlayer, secondPlayer));
        } else {
            scoreBuilder.append(firstPlayer.getName()).append(COLON_SEPARATOR).append(translatePoints(firstPlayerScore));
            scoreBuilder.append(SLASH_SEPARATOR);
            scoreBuilder.append(secondPlayer.getName()).append(COLON_SEPARATOR).append(translatePoints(secondPlayerScore));
        }
        return scoreBuilder.toString();
    }

    @Override
    public void playerScore(Player player) {
        player.setScore(player.getScore() + 1);
    }

    /**
     * checks if a player has won the game.
     * @param firstPlayerScore the first Player Score
     * @param secondPlayerScore the second Player Score
     * @return true if a player won, false otherwise
     */
    private boolean isWon(int firstPlayerScore, int secondPlayerScore) {
        return (firstPlayerScore> THIRD_BALL_WON || secondPlayerScore > THIRD_BALL_WON) && Math.abs(firstPlayerScore - secondPlayerScore) > 1;
    }

    /**
     * checks if both players have 40
     * @param firstPlayerScore the first Player Score
     * @param secondPlayerScore the second Player Score
     * @return true if both players have 40, false otherwise
     */
    private boolean isDeuce(int firstPlayerScore, int secondPlayerScore) {
        return firstPlayerScore >= THIRD_BALL_WON && firstPlayerScore == secondPlayerScore;
    }

    /**
     * checks if a player has an advantage.
     * @param firstPlayerScore the first Player Score
     * @param secondPlayerScore the second Player Score
     * @return true if a player won, false otherwise
     */
    private boolean isAdvantage(int firstPlayerScore, int secondPlayerScore) {
        return firstPlayerScore >= THIRD_BALL_WON && secondPlayerScore >= THIRD_BALL_WON && firstPlayerScore != secondPlayerScore;
    }

    /**
     * get the name of the player with more points scored.
     * @param firstPlayer the first player
     * @param secondPlayer the second player
     * @return the player name.
     */
    private String getPlayerNameWithMorePoints(Player firstPlayer, Player secondPlayer) {
        return firstPlayer.getScore() > secondPlayer.getScore()
                ? firstPlayer.getName()
                : secondPlayer.getName();
    }

    /**
     * convert scores to points
     * @param playerScore the player score
     * @return points
     */
    private String translatePoints(int playerScore) {
        return POINTS.get(playerScore);
    }
}
