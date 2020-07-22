package com.vidya.adis;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.vidya.adis.QuizContact.*;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;


    public QuizDbHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.db = sqLiteDatabase;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE "+
                QuestionsTable.TABLE_NAME +" ( "+
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                QuestionsTable.COLUMN_QUESTION + " TEXT, "+
                QuestionsTable.COLUMN_DOMAIN + " TEXT, "+
                QuestionsTable.COLUMN_SUBDOMAIN + " TEXT, "+
                QuestionsTable.COLUMN_SCORE + " INTEGER "+
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable(){
        Question q1 = new Question("X has an unusual approach to people (intrusive touching or licking)","A","1",0);
        addQuestion(q1);
        Question q2 = new Question("X can use you or others as a tool (i.e. hold your hand and point to things with your hand or use it like attempting to open a door turning the knob with your hand))","A","1",0);
        addQuestion(q1);
        Question q3 = new Question("It feels like X doesn’t respond when X’s name is called or when X is spoken directly to","A","1",0);
        addQuestion(q1);
        Question q4 = new Question("It feels like X is having a one‐sided conversation with you- as if X is not interested in your side of conversation","A","1",0);
        addQuestion(q1);
        Question q5 = new Question("X sticks to his agenda in a conversation- often speaking at you or rather over you","A","1",0);
        addQuestion(q1);
        Question q6 = new Question("X doesn’t add on to a conversation to keep it going or to repair it","A","1",0);
        addQuestion(q1);
        Question q7 = new Question("X does not attempt to clarify or provide extra background information if not understood","A","1",0);
        addQuestion(q1);
        Question q8 = new Question("X does not like to share toys, objects (e.g. food) or space (like on a sofa)","A","1",0);
        addQuestion(q1);
        Question q9 = new Question("X does not show or point out objects to other people to share his interest (e.g. helicopter, airplane in the sky or a train/ bus at a distance)","A","1",0);
        addQuestion(q1);
        Question q10 = new Question("X does not show interest in displaying his achievements (like a sticker, certificate from school or drawing he has made)","A","1",0);
        addQuestion(q1);
        Question q11 = new Question("X does not respond to a social smile (smile to a greeting) from a friendly stranger","A","1",0);
        addQuestion(q1);
        Question q12 = new Question("X doesn’t seem to share x’s enjoyment, excitement, achievements with others","A","1",0);
        addQuestion(q1);
        Question q13 = new Question("When X is happy, X does not seem to share this feeling with others","A","1",0);
        addQuestion(q1);
        Question q14 = new Question("X doesn’t seem to respond appropriately to praise or a nice compliment about him","A","1",0);
        addQuestion(q1);
        Question q15 = new Question("X does not show any evidence of happiness or excitement with other children’s excitement or pleasure (like in another child’s birthday party)","A","1",0);
        addQuestion(q1);
        Question q16 = new Question("X doesn’t seem to offer comfort to others when they are hurt or upset- and would rather ignore or walk away from the situation","A","1",0);
        addQuestion(q1);
        Question q17 = new Question("X doesn’t look at you for assurance or encouragement","A","1",0);
        addQuestion(q1);
        Question q18 = new Question("X is indifferent to or dislikes physical contact or show of affection (i.e. a cuddle or a kiss)","A","1",0);
        addQuestion(q1);
        Question q19 = new Question("X does not show interest in children of his own age and approach them on his own to interact/ play with them, unless compelled to do so","A","1",0);
        addQuestion(q1);
        Question q20 = new Question("X doesn’t initiate ‘small talk’ or a ‘social chit-chat’ to be friendly","A","1",0);
        addQuestion(q1);
        Question q21 = new Question("X only initiates interaction to get help from someone","A","1",0);
        addQuestion(q1);
        Question q22 = new Question("X fails to understand the rules of simple games like taking turns, following others","A","1",0);
        addQuestion(q1);
        Question q23 = new Question("X does not spontaneously enter the spirit or fun of the game","A","1",0);
        addQuestion(q1);
        Question q24 = new Question("X does not copy what other children do","A","1",0);
        addQuestion(q1);
        Question q25 = new Question("X does not seem to imitate people in the family when X was very young (i.e. imitating household chores like mowing the lawn, ironing etc)","A","1",0);
        addQuestion(q1);
        Question q26 = new Question("X’s facial expressions are limited or are exaggerated in range and mode","A","2",0);
        addQuestion(q1);
        Question q27 = new Question("X has an unusual approach to people (intrusive touching or licking)","A","2",0);
        addQuestion(q1);
        Question q28 = new Question("X does not use or understand body postures (i.e. seen to be looking away from someone who is talking to him- or understand that other person is not interested from their body language)","A","2",0);
        addQuestion(q1);
        Question q29 = new Question("X does not use gestures appropriately (e.g. actions like pointing, waving, nodding/shaking head, beckoning, shushing, putting out hands to ask for something)","A","2",0);
        addQuestion(q1);
        Question q30 = new Question("X does not understand gestures appropriately (e.g. actions as above)","A","2",0);
        addQuestion(q1);
        Question q31 = new Question("X does not understand change in tone of voice indicating request to change behaviour","A","2",0);
        addQuestion(q1);
        Question q32 = new Question("X has an unusual way of talking (abnormal volume, pitch, intonation, rate, rhythm, stress or prosody in speech)","A","2",0);
        addQuestion(q1);
        Question q33 = new Question("You cannot understand from X’s facial expression what X feels like","A","2",0);
        addQuestion(q1);
        Question q34 = new Question("X doesn’t show a warm, joyful expression when facing others","A","2",0);
        addQuestion(q1);
        Question q35 = new Question("X is unable to understand or interpret other’s facial expressions","A","2",0);
        addQuestion(q1);
        Question q36 = new Question("X has a difficulty in putting together eye contact facial expressions with gestures and body postures (Coordinating non‐verbal communication)","A","2",0);
        addQuestion(q1);
        Question q37 = new Question("X is unable to put together facial expressions, eye contact, gestures and body language to match the words X is coming out with i.e. asking for help or getting other person’s attention to something he is anxious/worried about","A","2",0);
        addQuestion(q1);
        Question q38 = new Question("X has a difficulty in conveying his thoughts, feelings and emotions using words, facial expressions, tone of voice, gestures and body language (postures)","A","2",0);
        addQuestion(q1);
        Question q39 = new Question("X’s facial expressions are limited or are exaggerated in range and mode","A","3 ",0);
        addQuestion(q1);



    }
    private void addQuestion(Question question){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION , question.getQuestion());
        cv.put(QuestionsTable.COLUMN_DOMAIN , question.getDomain());
        cv.put(QuestionsTable.COLUMN_SUBDOMAIN , question.getSubdomain());
        cv.put(QuestionsTable.COLUMN_SCORE , question.getScoreObtained());

        db.insert(QuestionsTable.TABLE_NAME,null,cv);
    }

}
