package com.adammcneilly.util;

import com.adammcneilly.util.models.HoleBase;

import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Unit tests against the Hole model.
 */
public class HoleBaseUnitTest {
    private static final int VALID_NUMBER = 1;
    private static final int VALID_PAR = 3;

    /**
     * Ensures that a hole will accept any number 1-18 without error.
     */
    @Test
    public void validNumber() {
        for(int number = 1; number <= 18; number++) {
            new HoleBase(number, VALID_PAR);
        }
    }

    /**
     * Ensures that a hole will not accept any number outside the range of 1-18.
     */
    @Test
    public void testInvalidNumber() {
        // Hole 0
        try {
            new HoleBase(0, VALID_PAR);
            fail();
        } catch(IllegalArgumentException iae) {
            // Do nothing, we expected this.
        }

        // Hole 19
        try {
            new HoleBase(19, VALID_PAR);
            fail();
        } catch(IllegalArgumentException iae) {
            // Do nothing, we expected this.
        }
    }

    /**
     * Ensures that a hole will accept any par 3-5 without error.
     */
    @Test
    public void validPar() {
        for(int par = 3; par <= 5; par++) {
            new HoleBase(VALID_NUMBER, par);
        }
    }

    /**
     * Ensures that a hole will not accept any par outside 3-5.
     */
    @Test
    public void testInvalidPar() {
        try {
            new HoleBase(VALID_NUMBER, 2);
            fail();
        } catch(IllegalArgumentException iae) {
            // Do nothing, expected behavior
        }

        try {
            new HoleBase(VALID_NUMBER, 6);
            fail();
        } catch(IllegalArgumentException iae) {
            // Do nothing, expected behavior
        }
    }
}