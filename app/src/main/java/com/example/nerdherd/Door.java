package com.example.nerdherd;

public class Door {
    boolean open;
    boolean ball;

    public Door(){
        this.ball = false;
        this.open = false;
    }

    void setBall(){
        this.ball = true;
    }

    void chooseDoor(){
        if(!this.open){
            this.open = true;
        }
        else{
            System.out.println("this door has already been opened");
        }
    }

    public boolean isBall(){
        return this.ball;
    }
}