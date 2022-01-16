package com.example.nerdherd;

public class TestDoor {
    private Boolean ball = false;
    private Boolean open = false;

    public TestDoor(Boolean ball){
        this.ball = ball;
        this.open = open;
    }

    public String isBall(){
        if(this.ball == true){
            return "YES BALL";
        }else{
            return "NO BALL";
        }
    }

    public void setBall(boolean ball){
        this.ball = ball;
    }
}
