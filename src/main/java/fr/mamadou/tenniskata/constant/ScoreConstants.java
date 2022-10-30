package fr.mamadou.tenniskata.constant;

import java.util.Map;

/**
 * Score tennis system constants
 */
public final class ScoreConstants {
    /***/
    public static final Map<Integer, String> POINTS = Map.of(0, "0", 1, "15", 2, "30", 3, "40");
    /** advantage score suffix message  */
    public static final String WIN_GAME = " wins the game";
    /** advantage score prefix message */
    public static final String ADVANTAGE_FOR = "Advantage for ";
    /** deuce score message*/
    public static final String DEUCE = "deuce";
    /** player score separator */
    public static final String SLASH_SEPARATOR = " / ";
    /** player scored points separator */
    public static final String COLON_SEPARATOR = " : ";
    /** 3rd ball won */
    public static final int THIRD_BALL_WON = 3;

    private ScoreConstants(){
        throw new IllegalStateException("Cannot be instantiated");
    }
}
