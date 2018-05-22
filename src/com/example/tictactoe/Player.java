package com.example.tictactoe;

public class Player {

    public boolean active;
    public String sign;

    Player(String sign){
        this.active = false;
        this.sign = sign;
    }
}
