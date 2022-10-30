package fr.mamadou.tenniskata.printer;

/**
 * this interface allows you to display the scores of the players
 * @Author Mamadou
 */
public interface IScorePrinter {

    /**
     * this method print the score after each won ball.
     * @param score score to print
     */
    void displayScore(String score);
}
