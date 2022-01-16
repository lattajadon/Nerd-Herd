package com.example.nerdherd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;

import static java.lang.Boolean.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameScreen extends AppCompatActivity {
    private boolean easy;
    SideBar bar;
    //List<Ball> balls = new ArrayList<>();
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
        for (int i = 0; i < 12; i++) {
            int id = getResources().getIdentifier("door"+i, "id", getPackageName());
            findViewById(id).setClickable(false);
        }
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
        generateStars(numSlots);

        return board;
    }

    public void generateStars(int numStars){
        for (int i = 0; i < numStars; i++) {
            int star_id = getResources().getIdentifier("star"+i, "id", getPackageName());
            findViewById(star_id).setVisibility(View.VISIBLE);
        }
    }



    public void CardPressed(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Add the buttons
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                for (int i = 0; i < 12; i++) {
                    int door_id = getResources().getIdentifier("door"+i, "id", getPackageName());
                    findViewById(door_id).setClickable(true);
                }
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
         // Set other dialog properties


        // Create the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void winnerState(){
        LottieAnimationView openingChest = findViewById(R.id.openingChest);
        openingChest.setProgress(0);
        openingChest.playAnimation();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                SwitchToEndScreen();
            }
        }, 5000);   //5 seconds
    }

    public void SwitchToEndScreen(){
        Intent intent = new Intent(this, WinScreen.class);
        startActivity(intent);
    }

    public void DoorPressed(int doorIndex) {
        Door door = board[doorIndex];
        int doorId = getResources().getIdentifier("door"+doorIndex, "id", getPackageName());
        Context context = getApplicationContext();
        CharSequence text; //for the toast message
        int star = -1; //Variable for tracking whether a star is present
        if(!door.isOpen()) { //check if door is open
            if (door.isBall()) { // check if door has ball
                if (bar.addBall()) {
                    //YOU WIN
//
                    winnerState();
                }
                text = Integer.toString(bar.getCurFilled());
                star = 1;
            } else {
                text = "NO STAR";
                star = 0;
            }
            int duration = Toast.LENGTH_SHORT;
            board[doorIndex].chooseDoor();
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            for (int i = 0; i < 12; i++) {
                int id = getResources().getIdentifier("door"+i, "id", getPackageName());
                findViewById(id).setClickable(false);
            }
        }else {
            text = "Already Picked";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


        ImageView animationStar;
        ImageButton btn = (ImageButton)findViewById(doorId);
        final ImageButton doorImg = (ImageButton) findViewById(doorId);
        if(star == 1){
            int star_id = getResources().getIdentifier("star"+(bar.getCurFilled()-1), "id", getPackageName());
            ImageView starImage = (ImageView)findViewById(star_id);
            starImage.setImageResource(R.drawable.purple_star);
//            animationStar = (ImageView) findViewById(R.id.animationStar);
//            Animation starZoom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.grow);
//            animationStar.setVisibility(View.VISIBLE);
//            animationStar.startAnimation(starZoom);
            btn.setImageResource(R.drawable.opened_door_star);
            doorImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    doorImg.setEnabled(false);
                }
            });
        }else if(star == 0){
            btn.setImageResource(R.drawable.opened_door_empty);
            doorImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    doorImg.setEnabled(false);
                }
            });
        }
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