package fr.mamadou.tenniskata.game;

/**
 * Represents a player.
 * @author Mamadou
 * @version 1.0
 */
public class Player {
    /** player name */
    private final String name;
    /** player score */
    private int score;

    /**
     * construct player with name
     * @param name
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * get player name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * get player score
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * set player score
     * @param score score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
}
