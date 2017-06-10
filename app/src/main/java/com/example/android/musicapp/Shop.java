package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.musicapp.R.layout.activity_shop;

public class Shop extends AppCompatActivity {
    Button submit;
    Button nowPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_shop);
        submit = (Button) findViewById(R.id.button9);
        nowPlaying = (Button) findViewById(R.id.playingbutton);

// set a listener on  nowplaying button

        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newScreen = new Intent(Shop.this, Player.class);
                startActivity(newScreen);
            }
        });
// set a listener on submit button to complete the order

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton payment1 = (RadioButton) findViewById(R.id.radio1);
                RadioButton payment2 = (RadioButton) findViewById(R.id.radio2);
                boolean paymentyearly = payment1.isChecked();
                boolean paymentmonthly = payment2.isChecked();

                if (paymentyearly) {
                    Toast.makeText(getApplicationContext(), "Thank you for yearly subscription", Toast.LENGTH_SHORT).show();
                }
                if (paymentmonthly)
                    Toast.makeText(getApplicationContext(), "Thank you for monthly subscription", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
