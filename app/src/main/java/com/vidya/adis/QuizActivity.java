package com.vidya.adis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView textViewQNumber;
    private TextView textViewQuestion;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioButton rb5;
    private Button buttonNext;
    private Button buttonPrevious;
    private Button buttonExit;

    private List<Question> questionList;
    private int noOfQuestions;
    private int questionCounter;
    private Question currentQuestion;



    double score_A1,score_A2,score_A3,score_B1,score_B2,score_B3,score_B4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewQNumber = findViewById(R.id.textViewQNumber);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        rbGroup = findViewById(R.id.rbGroup);
        rb1 = findViewById(R.id.option1);
        rb2 = findViewById(R.id.option2);
        rb3 = findViewById(R.id.option3);
        rb4 = findViewById(R.id.option4);
        rb5 = findViewById(R.id.option5);

        buttonNext = findViewById(R.id.buttonNext);
        buttonPrevious = findViewById(R.id.buttonPrevious);
        buttonExit = findViewById(R.id.buttonExit);

        QuizDbHelper dbHelper = new QuizDbHelper(this);

        //All data available in questionList
        questionList = dbHelper.getAllQuestions();
        noOfQuestions = questionList.size();
        showNextQuestion();



        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb1.isChecked()){
                    questionList.get(questionCounter).setScoreObtained(0);
                }else if(rb2.isChecked()){
                    questionList.get(questionCounter).setScoreObtained(1);
                }else if(rb3.isChecked()){
                    questionList.get(questionCounter).setScoreObtained(2);
                }else if (rb4.isChecked()){
                    questionList.get(questionCounter).setScoreObtained(3);
                }else {
                    questionList.get(questionCounter).setScoreObtained(-1);
                }
                Log.e("TAG_SCORE_OBTAINED", "onClick: " +questionList.get(questionCounter).getScoreObtained());
                questionCounter++;
                showNextQuestion();
            }
        });
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialAlertDialogBuilder(QuizActivity.this)
                        .setTitle("Confirm")
                        .setMessage("Do you want to exit and reset the quiz?")
        .setNegativeButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        })
        .setPositiveButton("NO", null)
        .show();
            }
        });



        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionCounter>0) {
                    rbGroup.clearCheck();
                    questionCounter--;
                    currentQuestion = questionList.get(questionCounter);
                    if (currentQuestion.getScoreObtained() == 0)rb1.setChecked(true);
                    else if (currentQuestion.getScoreObtained() == 1)rb2.setChecked(true);
                    else if (currentQuestion.getScoreObtained()==2)rb3.setChecked(true);
                    else  if (currentQuestion.getScoreObtained()==3)rb4.setChecked(true);
                    else rb5.setChecked(true);
                    textViewQuestion.setText(currentQuestion.getQuestion());
                    textViewQNumber.setText("Domain "+ currentQuestion.getDomain()+ " : " +(questionCounter+1));

                }
            }
        });
    }

    private void showNextQuestion() {
        if (questionCounter<noOfQuestions){
            currentQuestion = questionList.get(questionCounter);
            if (currentQuestion.getScoreObtained() == 3){rb4.setChecked(true);}
            else if(currentQuestion.getScoreObtained()==0){rb1.setChecked(true);}
            else if(currentQuestion.getScoreObtained()==1){rb2.setChecked(true);}
            else if(currentQuestion.getScoreObtained()==2){rb3.setChecked(true);}
            else rb5.setChecked(true);
            textViewQuestion.setText(currentQuestion.getQuestion());
            textViewQNumber.setText("Domain "+ currentQuestion.getDomain()+ " : " +(questionCounter+1));
        }else {
            endQuiz();
        }
    }

    private void endQuiz() {

        score_A1 = calculateScores(0,25);
        score_A2 = calculateScores(25,38);
        score_A3 = calculateScores(38,63);
        score_B1 = calculateScores(63,77);
        score_B2 = calculateScores(77,88);
        score_B3 = calculateScores(88,97);
        score_B4 = calculateScores(97,105);

        Log.d("FINAL RESULT", "endQuiz: "+score_A1+" "+score_A2+" "+score_A3+" "+score_B1+" "+score_B2+" "+score_B3+" "+score_B4);

        Toast.makeText(QuizActivity.this,"Reported generated successfully !",Toast.LENGTH_LONG).show();

        finish();


        }

    private double calculateScores(int i, int i2) {
        int attempted = 0;
        int sum=0;
        for(int j = i ; j<i2 ; j++){

            if (questionList.get(j).getScoreObtained()!=-1){
                attempted++;
                sum+=questionList.get(j).getScoreObtained();

            }

        }
        return ((sum+0.0)/attempted);
    }

}