package fr.mamadou.tenniskata;

import fr.mamadou.tenniskata.game.Game;
import fr.mamadou.tenniskata.game.Player;
import fr.mamadou.tenniskata.printer.IScorePrinter;
import fr.mamadou.tenniskata.printer.ScorePrinter;
import fr.mamadou.tenniskata.scorecalculator.IScoreCalculator;
import fr.mamadou.tenniskata.scorecalculator.ScoreCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {

    private Player firstPlayer;
    private Player secondPlayer;
    private Game game;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        firstPlayer = new Player("Player A");
        secondPlayer = new Player("Player B");
        IScoreCalculator scoreCalculator = new ScoreCalculator();
        IScorePrinter scorePrinter = new ScorePrinter();
        game = new Game(firstPlayer, secondPlayer, scoreCalculator, scorePrinter);

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
     void game_should_start_with_score_of_0_0() {
        game.play("");

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
     void testPlayerAFirstScoreIs15() {
        String expectedScore = "Player A : 15 / Player B : 0"+"\n";
        // WHEN
        game.play("A");

        //THEN
        assertEquals(expectedScore, outContent.toString());
    }

    @Test
    void testPlayerASecondScoreIs30() {
        //GIVEN
        String expectedScore = new StringBuilder()
                .append("Player A : 15 / Player B : 0"+"\n")
                .append("Player A : 30 / Player B : 0"+"\n")
                .toString();

        // WHEN
        game.play("AA");

        //THEN
        assertEquals(expectedScore, outContent.toString());
    }

    @Test
    void testPlayerAThirdScoreIs40() {
        //GIVEN
        String expectedScore = new StringBuilder()
                .append("Player A : 15 / Player B : 0"+"\n")
                .append("Player A : 30 / Player B : 0"+"\n")
                .append("Player A : 40 / Player B : 0"+"\n")
                .toString();

        //WHEN
        game.play("AAA");

        //THEN
        assertEquals(expectedScore, outContent.toString());
    }

    @Test
    void testPlayerAWonTheGame() {
        //GIVEN
        String expectedScore = new StringBuilder()
                .append("Player A : 15 / Player B : 0"+"\n")
                .append("Player A : 30 / Player B : 0"+"\n")
                .append("Player A : 40 / Player B : 0"+"\n")
                .append("Player A wins the game"+"\n")
                .toString();

        //WHEN
        game.play("AAAA");

        //THEN
        assertEquals(expectedScore, outContent.toString());
    }

    @Test
    void testPlayerAWithAdvantage() {
        //GIVEN
        String expectedScore = new StringBuilder()
                .append("Player A : 15 / Player B : 0"+"\n")
                .append("Player A : 30 / Player B : 0"+"\n")
                .append("Player A : 40 / Player B : 0"+"\n")
                .append("Player A : 40 / Player B : 15"+"\n")
                .append("Player A : 40 / Player B : 30"+"\n")
                .append("deuce"+"\n")
                .append("Advantage for Player A"+"\n")
                .toString();

        // WHEN
        game.play("AAABBBA");

        //THEN
        assertEquals(expectedScore, outContent.toString());    }

    @Test
    void testPlayerAWinAfterTheAdvantage() {
        //GIVEN
        String expectedScore = new StringBuilder()
                .append("Player A : 15 / Player B : 0"+"\n")
                .append("Player A : 30 / Player B : 0"+"\n")
                .append("Player A : 40 / Player B : 0"+"\n")
                .append("Player A : 40 / Player B : 15"+"\n")
                .append("Player A : 40 / Player B : 30"+"\n")
                .append("deuce"+"\n")
                .append("Advantage for Player A"+"\n")
                .append("Player A wins the game"+"\n")
                .toString();

        // WHEN
        game.play("AAABBBAA");

        //THEN
        assertEquals(expectedScore, outContent.toString());
    }

    @Test
    void testDeuce() {
        //GIVEN
        String expectedScore = new StringBuilder()
                .append("Player A : 15 / Player B : 0"+"\n")
                .append("Player A : 15 / Player B : 15"+"\n")
                .append("Player A : 15 / Player B : 30"+"\n")
                .append("Player A : 30 / Player B : 30"+"\n")
                .append("Player A : 30 / Player B : 40"+"\n")
                .append("deuce"+"\n")
                .toString();

        // WHEN
        game.play("ABBABA");

        //THEN
        assertEquals(expectedScore, outContent.toString());
    }

    @Test
    void testPlayerAWithTheAdvantage_PlayerBScoresAndReturnsToDeuce() {
        //GIVEN
        String expectedScore = new StringBuilder()
                .append("Player A : 15 / Player B : 0"+"\n")
                .append("Player A : 30 / Player B : 0"+"\n")
                .append("Player A : 40 / Player B : 0"+"\n")
                .append("Player A : 40 / Player B : 15"+"\n")
                .append("Player A : 40 / Player B : 30"+"\n")
                .append("deuce"+"\n")
                .append("Advantage for Player A"+"\n")
                .append("deuce"+"\n")
                .toString();

        // WHEN
        game.play("AAABBBAB");

        //THEN
        assertEquals(expectedScore, outContent.toString());
    }

    @Test
    void gameShouldThrowIllegalArgumentExceptionWhenUnexpectedCharacterIsUsed() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->  game.play("AC"));

        String expectedMessage = "Unexpected value: C";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
