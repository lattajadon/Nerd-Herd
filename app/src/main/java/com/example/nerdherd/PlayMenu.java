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

    public void startPressed(View view){
        Intent intent = new Intent(this, GameScreen.class);
        if(diffSwitch.isChecked()){
            diff = "easy";
        }else{
            diff="hard";
        }
        intent.putExtra(EXTRA_MESSAGE, diff);
        startActivity(intent);
    }
}