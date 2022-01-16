package com.example.nerdherd;

import static java.lang.Boolean.*;

public class SideBar {
    private int numSlots;
    private int curFilled;
    private int numCoins;
    public SideBar(int numSlots){
        this.numSlots = numSlots;
        this.curFilled = 0;
        this.numCoins = 0;
    }

    public int getCurFilled() {
        return this.curFilled;
    }

    public Boolean addBall(){
        this.curFilled +=1;
        if(this.curFilled>=this.numSlots){
            celebration();
            return TRUE;

        }else{
            return FALSE;
        }
    }
    public int getCoins(){
        return this.numCoins;
    }
    public void addCoins(int num_add){
        this.numCoins+=num_add;
    }
    public boolean spendCoins(int spending){
        if(this.numCoins-spending>=0){
            this.numCoins-=spending;
            return TRUE;
        }else{
            return FALSE;
        }
    }
    public void celebration(){
        return;
    }
}
