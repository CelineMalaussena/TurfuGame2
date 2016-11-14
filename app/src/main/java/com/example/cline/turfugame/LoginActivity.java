package com.example.cline.turfugame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity  {

    Button login;
    EditText pseudo, password;
    TextView registerLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        this.login = (Button) findViewById(R.id.login);
        this.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(login);
            }
        });


        this.pseudo = (EditText) findViewById(R.id.pseudo);
        this.password = (EditText) findViewById(R.id.password);

        this.registerLink = (TextView) findViewById(R.id.registerLink);
        this.registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerLink = new Intent(LoginActivity.this, InscriptionActivity.class);
                startActivity(registerLink);
            }
        });

    }

}
