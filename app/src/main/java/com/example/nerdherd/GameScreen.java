package com.example.nerdherd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Boolean.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameScreen extends AppCompatActivity {
    private boolean easy;
    SideBar bar;
    List<Ball> balls = new ArrayList<>();
    ImageView imageView;
    Door[] board;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        Intent intent = getIntent();
        String diff = intent.getStringExtra(PlayMenu.EXTRA_MESSAGE);
        if(diff.equals("easy")){
            easy = TRUE;
        }else{
            easy = FALSE;
        }
        board = makeBoard(easy);
    }


    public Door[] makeBoard(Boolean isEasy){
        // make the board using the door class
        Door[] board = new Door[12];

        for(int i = 0; i < board.length; i++){
            board[i] = new Door();
        }

        // random balls in 6 places
        Random rand = new Random();
        int balls = 0;

        while(balls < 6){
            int randNum = rand.nextInt(11);
            if(!board[randNum].isBall()){
                board[randNum].setBall();
                balls++;
            }
        }
        int numSlots;
        if (isEasy){
            numSlots= 3;
        }else{
            numSlots = 6;
        }
        bar = new SideBar(numSlots);

        return board;
    }


    public void DoorPressed(int doorIndex) {
        Door door = board[doorIndex];
        door.chooseDoor();
        Context context = getApplicationContext();
        CharSequence text;
        if(door.isBall()){
            text = Integer.toString(bar.getCurFilled());
            if(bar.addBall()){
                //YOU WIN
                Intent intent = new Intent(this, WinScreen.class);
                startActivity(intent);
            }
        }else{
            text = "NO STAR";
        }
        int duration = Toast.LENGTH_SHORT;
        board[doorIndex].chooseDoor();



        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void Door0Pressed(View view){
        DoorPressed(0);
    }
    public void Door1Pressed(View view){
        DoorPressed(1);
    }
    public void Door2Pressed(View view){
        DoorPressed(2);
    }
    public void Door3Pressed(View view){
        DoorPressed(3);
    }
    public void Door4Pressed(View view){
        DoorPressed(4);
    }
    public void Door5Pressed(View view){
        DoorPressed(5);
    }
    public void Door6Pressed(View view){
        DoorPressed(6);
    }
    public void Door7Pressed(View view){
        DoorPressed(7);
    }
    public void Door8Pressed(View view){
        DoorPressed(8);
    }
    public void Door9Pressed(View view){
        DoorPressed(9);
    }
    public void Door10Pressed(View view){
        DoorPressed(10);
    }
    public void Door11Pressed(View view){
        DoorPressed(11);
    }
}