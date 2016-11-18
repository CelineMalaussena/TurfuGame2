package com.example.cline.turfugame;

/**
 * Created by Alexis on 14/11/16.
 */

import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity{
    List<Question> quesList;
    Question currentQuestion;
    TextView questionTextView;

    int score = 0;
    int questionId = 0;

    RadioButton rda, rdb, rdc;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz);

        DBHelper db = new DBHelper(this);
        quesList = db.getAllQuestions();

        currentQuestion = quesList.get(questionId);

        questionTextView = (TextView)findViewById(R.id.textView1);
        rda = (RadioButton)findViewById(R.id.radio0);
        rdb = (RadioButton)findViewById(R.id.radio1);
        rdc = (RadioButton)findViewById(R.id.radio2);
        nextButton = (Button)findViewById(R.id.button1);

        setQuestionView();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = (RadioGroup)findViewById(R.id.radioGroup1);
                RadioButton answer = (RadioButton)findViewById(grp.getCheckedRadioButtonId());
                Log.d("Your answer", currentQuestion.getAnswer()+" "+answer.getText());

                if(currentQuestion.getAnswer().equals(answer.getText())){
                    score++;
                    Log.d("score", "Your score"+score);
                }
                if(questionId < 5){
                    currentQuestion = quesList.get(questionId);
                    setQuestionView();
                }
                else{
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("score", score); //Your score
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }

    private void setQuestionView(){
        questionTextView.setText(currentQuestion.getQuestion());
        rda.setText(currentQuestion.getOptionA());
        rdb.setText(currentQuestion.getOptionB());
        rdc.setText(currentQuestion.getOptionC());

        questionId++;
    }
}
