package com.example.cline.turfugame;

import android.content.Intent;
import android.gesture.Gesture;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class SinglePlayer extends AppCompatActivity {

    Button button3;
    Button button4;
    Button button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        this.button3 = (Button) this.findViewById(R.id.button3);

        this.button4 = (Button) this.findViewById(R.id.button4);

        this.button5 = (Button) this.findViewById(R.id.button5);
        this.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent but5 = new Intent(SinglePlayer.this,QuizActivity.class);
                startActivity(but5);
            }
        });

    }
}
