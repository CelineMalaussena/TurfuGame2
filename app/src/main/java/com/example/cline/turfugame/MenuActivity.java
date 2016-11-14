package com.example.cline.turfugame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button1 = (Button) this.findViewById(R.id.button1);
        this.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent but1 = new Intent(MenuActivity.this,SinglePlayer.class);

                startActivity(but1);
            }
        });
        this.button2 = (Button) this.findViewById(R.id.button2);
        this.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent but2 = new Intent(MenuActivity.this,MultiPlayer.class);

                startActivity(but2);
            }
        });
        this.button6 = (Button) this.findViewById(R.id.button6);
        this.button6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent but6 = new Intent(MenuActivity.this,Options.class);

                startActivity(but6);
            }
        });


    }


}
