package fr.mamadou.tenniskata.printer;

import static java.lang.System.out;

public class ScorePrinter implements IScorePrinter {

    @Override
    public void displayScore(String score) {
        out.println(score);
    }
}
