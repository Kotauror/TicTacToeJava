package com.example.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTests {

    public Validator validator;

    @BeforeEach
    public void instantiateValidtor() {
        validator = new Validator();
    }

    @Test
    public void returnsTrueWhenMoveIsValid() {
        assertTrue(validator.isNumeric("2"));
    }

    @Test
    public void returnsFalseWhenMoveIsNotValid() {
        assertFalse(validator.isNumeric("J"));
    }

}
