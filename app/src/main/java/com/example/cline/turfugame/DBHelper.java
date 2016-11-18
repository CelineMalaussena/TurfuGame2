package com.example.cline.turfugame;

/**
 * Created by Alexis on 14/11/16.
 */

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;

    // Our database name
    private static final String DATABASE_NAME = "TurfuQuizz";

    // The main table name
    private static final String TABLE_NAME = "Questions";

    // Columns name
    private static final String KEY_ID = "id";
    private static final String KEY_QUESTION = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_OPTIONA= "optionA";
    private static final String KEY_OPTIONB= "optionB";
    private static final String KEY_OPTIONC= "optionC";

    private SQLiteDatabase dbase;
    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        dbase = db;

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "
                + KEY_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_QUESTION + " TEXT, "
                + KEY_ANSWER   + " TEXT, "
                + KEY_OPTIONA  + " TEXT, "
                + KEY_OPTIONB  + " TEXT, "
                + KEY_OPTIONC  + " TEXT)";

        db.execSQL(sql);

        addAllQuestions();
        //db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV){
        // Drop the older table if existed already and recreates a new one
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private void addAllQuestions(){
        Question q1 = new Question("Which company is the largest manufacturer of network equipment?",
                "HP",
                "IBM",
                "CISCO",
                "CISCO");
        this.addQuestion(q1);

        Question q2 = new Question("Which of the following is NOT an operating system?",
                "SuSe",
                "BIOS",
                "DOS",
                "BIOS");
        this.addQuestion(q2);

        Question q3 = new Question("Which of the following is the fastest writable memory?",
                "RAM",
                "FLASH",
                "Register",
                "Register");
        this.addQuestion(q3);

        Question q4=new Question("Which of the following device regulates internet traffic?",
                "Router",
                "Bridge",
                "Hub",
                "Router");
        this.addQuestion(q4);

        Question q5=new Question("Which of the following is NOT an interpreted language?",
                "Ruby",
                "Python",
                "BASIC",
                "BASIC");
        this.addQuestion(q5);
    }

    public void addQuestion(Question q){
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION, q.getQuestion());
        values.put(KEY_ANSWER, q.getAnswer());
        values.put(KEY_OPTIONA, q.getOptionA());
        values.put(KEY_OPTIONB, q.getOptionB());
        values.put(KEY_OPTIONC, q.getOptionC());
        // Inserting Row
        dbase.insert(TABLE_NAME, null, values);
    }

    public List<Question> getAllQuestions(){
        List<Question> questionList = new ArrayList<Question>();

        // Select query
        String select = "SELECT * FROM " + TABLE_NAME;

        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(select, null);

        if (cursor.moveToFirst()){
            do {
                Question question = new Question();
                question.setId(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));
                question.setAnswer(cursor.getString(2));
                question.setOptionA(cursor.getString(3));
                question.setOptionB(cursor.getString(4));
                question.setOptionC(cursor.getString(5));

                questionList.add(question);
            } while(cursor.moveToNext());
        }

        return questionList;
    }

    public int rowcount(){
        int row=0;
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
