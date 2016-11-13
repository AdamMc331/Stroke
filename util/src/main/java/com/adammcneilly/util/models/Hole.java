package com.adammcneilly.util.models;

/**
 * Represents a hole that the user can play.
 *
 * Created by adam.mcneilly on 11/13/16.
 */
public class Hole {
    /**
     * The number of the hole on the course - between 1 and 18.
     */
    private int number;

    /**
     * The number of strokes the user took to complete this hole.
     */
    private int score;

    /**
     * Sets the number of this hole.
     * @param number The number of the hole on the course, must be between 1 and 18 (inclusive).
     */
    public void setNumber(int number) {
        if(number < 1 || number > 18) {
            throw new IllegalArgumentException("Invalid hole number.");
        }

        this.number = number;
    }

    /**
     * Sets the number of strokes required to complete this hole.
     * @param score The number of strokes taken. Cannot be less than 1.
     */
    public void setScore(int score) {
        if(score < 1) {
            throw new IllegalArgumentException("Invalid hole score.");
        }

        this.score = score;
    }

    public int getNumber() {
        return number;
    }

    public int getScore() {
        return score;
    }
}
