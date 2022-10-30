package fr.mamadou.tenniskata.scorecalculator;

import fr.mamadou.tenniskata.game.Player;

/**
 * This interface is used to represent the Game with two players
 * @author Mamadou
 * @version 1.0
 */
public interface IScoreCalculator {

    /**
     * this method evaluates player scores throughout the game.
     * @param firstPlayer the first player
     * @param secondPlayer the second player
     * @return player scores
     */
    String evaluateScore (Player firstPlayer, Player secondPlayer);

    /**
     * increments the score of the player who scored a point
     * @param player the player
     */
    void playerScore(Player player);
}
