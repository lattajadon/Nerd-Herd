package com.example.nerdherd;

public class Door {
    private boolean open;
    private boolean ball;

    public Door(){
        this.ball = false;
        this.open = false;
    }

    public void setBall(){
        this.ball = true;
    }

    public void chooseDoor(){
        this.open = true;
    }

    public boolean isOpen(){
        return this.open;
    }


    public boolean isBall(){
        return this.ball;
    }
}