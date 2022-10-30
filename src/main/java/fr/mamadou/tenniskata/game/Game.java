package fr.mamadou.tenniskata.game;

import fr.mamadou.tenniskata.printer.IScorePrinter;
import fr.mamadou.tenniskata.scorecalculator.IScoreCalculator;

/**
 * This class is used to represent the Game with two players
 * @author Mamadou
 * @version 1.0
 */
public class Game {
    /** game first player */
    private final Player firstPlayer;
    /** game first player */
    private final Player secondPlayer;
    /** game score calculator */
    private final IScoreCalculator scoreCalculator;
    /** game score printer */
    private final IScorePrinter scorePrinter;

    /**
     * Instantiate a new Player.
     * @param firstPlayer the firstPlayer
     * @param secondPlayer the secondPlayer
     * @param scoreCalculator the score calculator
     * @param scorePrinter the score printer
     */
    public Game(Player firstPlayer, Player secondPlayer, IScoreCalculator scoreCalculator, IScorePrinter scorePrinter) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.scoreCalculator = scoreCalculator;
        this.scorePrinter = scorePrinter;
    }

    /**
     * This that will take a String as input containing the character ‘A’ or ‘B’ and
     * should print the score after each won ball.
     * @param pointsWin String as input containing the character ‘A’ or ‘B’.
     * @throws IllegalArgumentException - if the character is not recognised.
     */
    public void play(String pointsWin) {
        for (char playerWon : pointsWin.toCharArray()) {
            switch (String.valueOf(playerWon)) {
                case "A":
                    scoreCalculator.playerScore(firstPlayer);
                    break;
                case "B":
                    scoreCalculator.playerScore(secondPlayer);
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected value: " + playerWon);
            }
            String score = scoreCalculator.evaluateScore(firstPlayer, secondPlayer);
            scorePrinter.displayScore(score);
        }
    }
}
