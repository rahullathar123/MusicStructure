package com.example.android.musicapp;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;


public class Player extends Activity {
    public static int onlyOneTime = 0;
    private Button bt1, bt2, bt3, bt4;
    private ImageView imageview;
    private MediaPlayer mediaPlayer;
    // set initial and final time of any song
    private double startDuration = 0;
    private double finalDuration = 0;
    ;
    // set forward and rewind time for any song
    private Handler myHandler = new Handler();
    private int forwardDuration = 5000;
    private int backwardDuration = 5000;
    private SeekBar seekBar;
    private TextView txt1, txt2, txt3;
    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startDuration = mediaPlayer.getCurrentPosition();
            txt1.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startDuration),
                    TimeUnit.MILLISECONDS.toSeconds((long) startDuration) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startDuration)))
            );
            seekBar.setProgress((int) startDuration);
            myHandler.postDelayed(this, 100);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        bt1 = (Button) findViewById(R.id.button5);
        bt2 = (Button) findViewById(R.id.button6);
        bt3 = (Button) findViewById(R.id.button7);
        bt4 = (Button) findViewById(R.id.button8);
        imageview = (ImageView) findViewById(R.id.imageView);

        txt1 = (TextView) findViewById(R.id.textView1);
        txt2 = (TextView) findViewById(R.id.textView2);
        txt3 = (TextView) findViewById(R.id.textView3);
        txt3.setText("Song.mp3");

        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setClickable(false);
        bt2.setEnabled(false);

        // set listener on playing button
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();

                finalDuration = mediaPlayer.getDuration();
                startDuration = mediaPlayer.getCurrentPosition();

                if (onlyOneTime == 0) {
                    seekBar.setMax((int) finalDuration);
                    onlyOneTime = 1;
                }
// set the total time of song
                txt2.setText(String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) finalDuration),
                        TimeUnit.MILLISECONDS.toSeconds((long) finalDuration) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                        finalDuration)))
                );
// show  the curent duration status of the song
                txt1.setText(String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) startDuration),
                        TimeUnit.MILLISECONDS.toSeconds((long) startDuration) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                        startDuration)))
                );

                seekBar.setProgress((int) startDuration);
                myHandler.postDelayed(UpdateSongTime, 100);
                bt2.setEnabled(true);
                bt3.setEnabled(false);
            }
        });

        // this button useful for pausing the song

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pausing sound", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                bt2.setEnabled(false);
                bt3.setEnabled(true);
            }
        });

// this  button useful for forward any song

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) startDuration;

                if ((temp + forwardDuration) <= finalDuration) {
                    startDuration = startDuration + forwardDuration;
                    mediaPlayer.seekTo((int) startDuration);
                    Toast.makeText(getApplicationContext(), "You  Jumped forward 5 seconds", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Cannot jump forward 5 seconds", Toast.LENGTH_SHORT).show();
                }
            }
        });
// this button useful for rewind

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) startDuration;

                if ((temp - backwardDuration) > 0) {
                    startDuration = startDuration - backwardDuration;
                    mediaPlayer.seekTo((int) startDuration);
                    Toast.makeText(getApplicationContext(), "You  Jumped backward 5 seconds", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Cannot jump backward 5 seconds", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}