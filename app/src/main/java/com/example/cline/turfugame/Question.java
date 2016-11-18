package com.example.cline.turfugame;

/**
 * Created by Alexis on 14/11/16.
 */

public class Question{
    private int id;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String answer;

    public Question(){
        id = 0;
        question = "";
        optionA = "";
        optionB = "";
        optionC = "";
        answer = "";
    }

    public Question(String q, String a, String b, String c, String ans){
        question = q;
        optionA = a;
        optionB = b;
        optionC = c;
        answer = ans;
    }

    public int getId(){
        return id;
    }
    public String getQuestion() {
        return question;
    }
    public String getOptionA() {
        return optionA;
    }
    public String getOptionB() {
        return optionB;
    }
    public String getOptionC() { return optionC; }
    public String getAnswer() {
        return answer;
    }

    public void setId(int newId ){ id = newId; }
    public void setQuestion(String q) {
        question = q;
    }
    public void setOptionA(String a) {
        optionA = a;
    }
    public void setOptionB(String b) { optionB = b; }
    public void setOptionC(String c) { optionC = c; }
    public void setAnswer(String newAnswer) {
        answer = newAnswer;
    }
}
