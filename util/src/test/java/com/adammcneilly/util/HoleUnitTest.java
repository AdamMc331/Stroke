package com.adammcneilly.util;

import com.adammcneilly.util.models.Hole;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests against the Hole model.
 */
public class HoleUnitTest {
    /**
     * Ensures that a hole will accept any number 1-18 without error.
     */
    @Test
    public void validNumber() {
        Hole hole = new Hole();

        for(int i = 1; i <= 18; i++) {
            hole.setNumber(i);
        }
    }

    /**
     * Ensures that a hole will not accept any number outside the range of 1-18.
     */
    @Test
    public void testInvalidNumber() {
        Hole hole = new Hole();

        // Hole 0
        try {
            hole.setNumber(0);
            fail();
        } catch(IllegalArgumentException iae) {
            // Do nothing, we expected this.
        }

        // Hole 19
        try {
            hole.setNumber(19);
            fail();
        } catch(IllegalArgumentException iae) {
            // Do nothing, we expected this.
        }
    }

    /**
     * Ensures that a hole will accept a score greater than or equal to 1 without error.
     * Tested with 1-10 just because of most common number of strokes.
     * It is 9 unnecessary loops though.
     */
    @Test
    public void testValidScore() {
        Hole hole = new Hole();

        for(int i = 1; i <= 10; i++) {
            hole.setScore(i);
        }
    }

    /**
     * Ensures that a hole will not accept a score less than 1.
     */
    @Test
    public void testInvalidScore() {
        Hole hole = new Hole();

        try {
            hole.setScore(0);
            fail();
        } catch(IllegalArgumentException iae) {
            // Do nothing, we expected this.
        }
    }
}