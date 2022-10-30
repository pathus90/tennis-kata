package fr.mamadou.tenniskata;

import fr.mamadou.tenniskata.game.Game;
import fr.mamadou.tenniskata.game.Player;
import fr.mamadou.tenniskata.printer.IScorePrinter;
import fr.mamadou.tenniskata.printer.ScorePrinter;
import fr.mamadou.tenniskata.scorecalculator.IScoreCalculator;
import fr.mamadou.tenniskata.scorecalculator.ScoreCalculator;

/**
 * @author mamadou on 28/10/2022
 * This class is a quick start demo which show how to use Tenis API in order to display the score after each won ball.
 */
public class QuickStart {
    public static void main(String[] args) {
        IScorePrinter scorePrinter = new ScorePrinter();
        IScoreCalculator scoreCalculator = new ScoreCalculator();

        Player p1 = new Player("Player A");
        Player p2 = new Player("Player B");

        Game game = new Game(p1, p2, scoreCalculator, scorePrinter);
        game.play("ABABAA");

    }
}