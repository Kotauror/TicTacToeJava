package com.core.tictactoe.game_options;

public enum GameMode {

    HUMAN_VS_HUMAN("1"),
    PLAY_WITH_COMPUTER("2"),
    HUMAN_VS_COMPUTER_HUMAN_GOES_FIRST("2H"),
    COMPUTER_VS_HUMAN_COMPUTER_GOES_FIRST("2C"),
    EXIT("E");

    private final String value;

    GameMode(String gameModeString) {
        this.value = gameModeString;
    }

    public String value() {
        return value;
    }
}
