package com.vidya.adis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    Bitmap bmp , scaledbmp;
    Date dateObj;
    DateFormat dateFormat;



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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.banner);
        scaledbmp = Bitmap.createScaledBitmap(bmp,1200,518,false);

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
        Boolean SUCCESS = true;
        dateObj = new Date();


        score_A1 = calculateScores(0,25);
        score_A2 = calculateScores(25,38);
        score_A3 = calculateScores(38,63);
        score_B1 = calculateScores(63,77);
        score_B2 = calculateScores(77,88);
        score_B3 = calculateScores(88,97);
        score_B4 = calculateScores(97,105);

        Paint myPaint = new Paint();
        Paint titlePaint = new Paint();

        PdfDocument document = new PdfDocument();
        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(1200,2010,1).create();
        PdfDocument.Page myPage1 = document.startPage(myPageInfo);
        Canvas canvas = myPage1.getCanvas();

        canvas.drawBitmap(scaledbmp,0,0,myPaint);

        titlePaint.setTextAlign(Paint.Align.CENTER);
        titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        titlePaint.setTextSize(70);
        canvas.drawText("ADIS REPORT",600,270,titlePaint);

        myPaint.setTextAlign(Paint.Align.RIGHT);
        dateFormat = new SimpleDateFormat("dd/MM/yy");
        canvas.drawText("Date : " + dateFormat.format(dateObj),-20,640,myPaint);

        dateFormat = new SimpleDateFormat("HH:mm:ss");
        canvas.drawText("Time : " + dateFormat.format(dateObj),-20,690,myPaint);

        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(60);

        canvas.drawText("A1 : ",50,900,myPaint);
        canvas.drawText("A2 : ",50,1000,myPaint);
        canvas.drawText("A3 : ",50,1100,myPaint);
        canvas.drawText("B1 : ",50,1200,myPaint);
        canvas.drawText("B2 : ",50,1300,myPaint);
        canvas.drawText("B3 : ",50,1400,myPaint);
        canvas.drawText("B4 : ",50,1500,myPaint);



        canvas.drawText(score_A1+"",500,900,myPaint);
        canvas.drawText(score_A2+"",500,1000,myPaint);
        canvas.drawText(score_A3+"",500,1100,myPaint);
        canvas.drawText(score_B1+"",500,1200,myPaint);
        canvas.drawText(score_B2+"",500,1300,myPaint);
        canvas.drawText(score_B3+"",500,1400,myPaint);
        canvas.drawText(score_B4+"",500,1500,myPaint);


        document.finishPage(myPage1);

        File file = new File(Environment.getExternalStorageDirectory(),"/Report.pdf");

        try {
            document.writeTo(new FileOutputStream(file));
        }catch(IOException e){
            e.printStackTrace();
            Toast.makeText(QuizActivity.this,"Some thing went wrong , Submit again",Toast.LENGTH_SHORT).show();
            SUCCESS = false;
        }







        if(SUCCESS) {
        document.close();
        Log.d("FINAL RESULT", "endQuiz: "+score_A1+" "+score_A2+" "+score_A3+" "+score_B1+" "+score_B2+" "+score_B3+" "+score_B4);

        Toast.makeText(QuizActivity.this,"Reported saved in storage",Toast.LENGTH_LONG).show();

        finish();}


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