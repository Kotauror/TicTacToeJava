package com.core.tictactoe.game_options;

public enum GameMode {

    HUMAN_VS_HUMAN("1"),
    HUMAN_VS_COMPUTER("H"),
    COMPUTER_VS_HUMAN("C"),
    EXIT("E");

    private final String value;

    GameMode(String gameModeString) {
        this.value = gameModeString;
    }

    public String value() {
        return value;
    }
}
