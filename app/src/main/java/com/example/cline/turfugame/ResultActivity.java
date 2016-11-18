package com.example.cline.turfugame;

/**
 * Created by Alexis on 14/11/16.
 */

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        RatingBar bar = (RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);

        // Get text view
        TextView t=(TextView)findViewById(R.id.textResult);

        // Get and display score
        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("score");

        bar.setRating(score);
        switch (score){
            case 1:
            case 2:
                t.setText("T'es mauvais !");
                break;
            case 3:
            case 4:
                t.setText("T'es moyen !");
                break;
            case 5:
                t.setText("T'es génial !");
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }
}
