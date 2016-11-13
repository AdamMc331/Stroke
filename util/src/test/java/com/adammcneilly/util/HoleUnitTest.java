package com.adammcneilly.util;

import com.adammcneilly.util.models.Hole;
import com.adammcneilly.util.models.HoleBase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Unit tests for the Hole class.
 *
 * Created by adam.mcneilly on 11/13/16.
 */
public class HoleUnitTest {
    private static final HoleBase VALID_HOLE_BASE = new HoleBase(1, 3);

    /**
     * Ensures that a hole will accept a score greater than or equal to 1 without error.
     * Tested with 1-10 just because of most common number of strokes.
     * It is 9 unnecessary loops though.
     */
    @Test
    public void testValidScore() {
        Hole hole = new Hole(VALID_HOLE_BASE);

        for(int i = 1; i <= 10; i++) {
            hole.setScore(i);
        }
    }

    /**
     * Ensures that a hole will not accept a score less than 1.
     */
    @Test
    public void testInvalidScore() {
        Hole hole = new Hole(VALID_HOLE_BASE);

        try {
            hole.setScore(0);
            fail();
        } catch(IllegalArgumentException iae) {
            // Do nothing, we expected this.
        }
    }

    /**
     * Ensures the value math works for various strokes.
     */
    @Test
    public void testGetValue() {
        Hole hole = new Hole(VALID_HOLE_BASE);

        // Hole base has par 3
        // Loop 1-10 score, and ensure value is score - par.
        for(int score = 1; score <= 10; score++) {
            hole.setScore(score);
            assertEquals(hole.getValue(), score - hole.getPar());
        }
    }
}
