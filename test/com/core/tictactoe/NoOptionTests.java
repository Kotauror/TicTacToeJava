package com.core.tictactoe;

import com.core.tictactoe.game_options.NoOption;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoOptionTests {

    @Test
    public void optionUnknown() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        NoOption noOption = new NoOption(new CommandLineUi(new PrintStream(outputStream), System.in));

        noOption.run();

        assertEquals("There is no such option\n", outputStream.toString());
    }
}
