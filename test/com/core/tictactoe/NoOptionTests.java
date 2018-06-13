package com.core.tictactoe;

import com.core.tictactoe.game_options.NoOption;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class NoOptionTests {

    @Test
    public void optionUnknown() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        NoOption noOption = new NoOption(new CommandLineUi(new PrintStream(output), System.in));

        noOption.run(new CommandLineUi(new PrintStream(output), System.in));

        assertEquals("There is no such option\n", output.toString());
    }
}
