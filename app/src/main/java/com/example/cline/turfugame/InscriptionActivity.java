package com.example.cline.turfugame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class InscriptionActivity extends AppCompatActivity implements View.OnClickListener {

    Button Register;
    EditText Pseudo, Age, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);


        this.Pseudo = (EditText) findViewById(R.id.pseudo);
        this.Age = (EditText) findViewById(R.id.age);
        this.Password = (EditText) findViewById(R.id.password);

        this.Register = (Button) findViewById(R.id.register);
        this.Register.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent register = new Intent(InscriptionActivity.this,LoginActivity.class);
        startActivity(register);
    }
}
