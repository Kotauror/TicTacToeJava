package com.core.tictactoe;

import com.core.tictactoe.game_options.NoOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class NoOptionTests {

    private NoOption noOption;

    @BeforeEach
    public void instantiate() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        noOption = new NoOption(new CommandLineUi(new PrintStream(outputStream), System.in));
    }

    @Test
    public void optionUnknown() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        NoOption noOption = new NoOption(new CommandLineUi(new PrintStream(outputStream), System.in));

        noOption.run(3);

        assertEquals("There is no such option\n", outputStream.toString());
    }

    @Test
    public void returns0AsSizeOfBoard() {
        assertEquals(0, noOption.getBoardSize());
    }

}
