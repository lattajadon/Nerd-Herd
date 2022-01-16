package com.example.nerdherd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

import static java.lang.Boolean.*;

public class PlayMenu extends AppCompatActivity {
    private String diff;
    ToggleButton diffSwitch;
    public static final String EXTRA_MESSAGE = "com.example.NerdHerd.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_menu);
        diffSwitch = (ToggleButton)findViewById(R.id.diffButton);

    }

    public void englishPressed(View view){
        Intent intent = new Intent(this, GameScreen.class);
        if(diffSwitch.isChecked()){
            diff = "hard,english";
        }else{
            diff = "easy,english";
        }
        intent.putExtra(EXTRA_MESSAGE, diff);
        startActivity(intent);
    }
    public void sciencePressed(View view){
        Intent intent = new Intent(this, GameScreen.class);
        if(diffSwitch.isChecked()){
            diff = "hard,science";
        }else{
            diff = "easy,science";
        }
        intent.putExtra(EXTRA_MESSAGE, diff);
        startActivity(intent);
    }
    public void mathPressed(View view){
        Intent intent = new Intent(this, GameScreen.class);
        if(diffSwitch.isChecked()){
            diff = "hard,math";
        }else{
            diff = "easy,math";
        }
        intent.putExtra(EXTRA_MESSAGE, diff);
        startActivity(intent);
    }
}