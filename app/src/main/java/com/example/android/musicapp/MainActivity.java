package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView playlist = (TextView) findViewById(R.id.button);
        TextView Library = (TextView) findViewById(R.id.button4);
        TextView player = (TextView) findViewById(R.id.button2);
        TextView shop = (TextView) findViewById(R.id.button3);

// Set a click listener on that shop view
        shop.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent shopIntent = new Intent(MainActivity.this, Shop.class);
                startActivity(shopIntent);
            }
        });

// Set a click listener on that player view
        player.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent playerIntent = new Intent(MainActivity.this, Player.class);
                startActivity(playerIntent);
            }
        });

// Set a click listener on that library view
        Library.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent(MainActivity.this, Library.class);
                startActivity(libraryIntent);
            }
        });

// Set a click listener on that playlist view
        playlist.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent playlistIntent = new Intent(MainActivity.this, Playlist.class);
                startActivity(playlistIntent);
            }
        });
    }
}
