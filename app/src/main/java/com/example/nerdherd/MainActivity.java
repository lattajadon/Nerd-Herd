package com.example.nerdherd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.lang.Boolean.*;


public class MainActivity extends AppCompatActivity {

    SideBar bar;
    List<Ball> balls = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void playPressed(View view){
        Intent intent = new Intent(this, PlayMenu.class);
        startActivity(intent);
    }

}