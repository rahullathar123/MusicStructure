package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Library extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        Button player = (Button) findViewById(R.id.player);
        Button home = (Button) findViewById(R.id.Home);
// Set a click listener on player button view
        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent library = new Intent(Library.this, Player.class);
                startActivity(library);
            }
        });
// set a click listener on home button view
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(Library.this, MainActivity.class);
                startActivity(home);
            }
        });
    }
}
