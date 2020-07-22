package com.vidya.adis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.vidya.adis.QuizContact.*;

import java.util.ArrayList;
import java.util.List;

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

        //A1 Social - emotional reciprocity


        Question q1 = new Question("X has an unusual approach to people (intrusive touching or licking)","A","1",0);
        addQuestion(q1);
        Question q2 = new Question("X can use you or others as a tool (i.e. hold your hand and point to things with your hand or use it like attempting to open a door turning the knob with your hand))","A","1",0);
        addQuestion(q2);
        Question q3 = new Question("It feels like X doesn’t respond when X’s name is called or when X is spoken directly to","A","1",0);
        addQuestion(q3);
        Question q4 = new Question("It feels like X is having a one‐sided conversation with you- as if X is not interested in your side of conversation","A","1",0);
        addQuestion(q4);
        Question q5 = new Question("X sticks to his agenda in a conversation- often speaking at you or rather over you","A","1",0);
        addQuestion(q5);
        Question q6 = new Question("X doesn’t add on to a conversation to keep it going or to repair it","A","1",0);
        addQuestion(q6);
        Question q7 = new Question("X does not attempt to clarify or provide extra background information if not understood","A","1",0);
        addQuestion(q7);
        Question q8 = new Question("X does not like to share toys, objects (e.g. food) or space (like on a sofa)","A","1",0);
        addQuestion(q8);
        Question q9 = new Question("X does not show or point out objects to other people to share his interest (e.g. helicopter, airplane in the sky or a train/ bus at a distance)","A","1",0);
        addQuestion(q9);
        Question q10 = new Question("X does not show interest in displaying his achievements (like a sticker, certificate from school or drawing he has made)","A","1",0);
        addQuestion(q10);
        Question q11 = new Question("X does not respond to a social smile (smile to a greeting) from a friendly stranger","A","1",0);
        addQuestion(q11);
        Question q12 = new Question("X doesn’t seem to share x’s enjoyment, excitement, achievements with others","A","1",0);
        addQuestion(q12);
        Question q13 = new Question("When X is happy, X does not seem to share this feeling with others","A","1",0);
        addQuestion(q13);
        Question q14 = new Question("X doesn’t seem to respond appropriately to praise or a nice compliment about him","A","1",0);
        addQuestion(q14);
        Question q15 = new Question("X does not show any evidence of happiness or excitement with other children’s excitement or pleasure (like in another child’s birthday party)","A","1",0);
        addQuestion(q15);
        Question q16 = new Question("X doesn’t seem to offer comfort to others when they are hurt or upset- and would rather ignore or walk away from the situation","A","1",0);
        addQuestion(q16);
        Question q17 = new Question("X doesn’t look at you for assurance or encouragement","A","1",0);
        addQuestion(q17);
        Question q18 = new Question("X is indifferent to or dislikes physical contact or show of affection (i.e. a cuddle or a kiss)","A","1",0);
        addQuestion(q18);
        Question q19 = new Question("X does not show interest in children of his own age and approach them on his own to interact/ play with them, unless compelled to do so","A","1",0);
        addQuestion(q19);
        Question q20 = new Question("X doesn’t initiate ‘small talk’ or a ‘social chit-chat’ to be friendly","A","1",0);
        addQuestion(q20);
        Question q21 = new Question("X only initiates interaction to get help from someone","A","1",0);
        addQuestion(q21);
        Question q22 = new Question("X fails to understand the rules of simple games like taking turns, following others","A","1",0);
        addQuestion(q22);
        Question q23 = new Question("X does not spontaneously enter the spirit or fun of the game","A","1",0);
        addQuestion(q23);
        Question q24 = new Question("X does not copy what other children do","A","1",0);
        addQuestion(q24);
        Question q25 = new Question("X does not seem to imitate people in the family when X was very young (i.e. imitating household chores like mowing the lawn, ironing etc)","A","1",0);
        addQuestion(q25);

        //A2 : Non Verbal Communication


        Question q26 = new Question("X’s facial expressions are limited or are exaggerated in range and mode","A","2",0);
        addQuestion(q26);
        Question q27 = new Question("X has an unusual approach to people (intrusive touching or licking)","A","2",0);
        addQuestion(q27);
        Question q28 = new Question("X does not use or understand body postures (i.e. seen to be looking away from someone who is talking to him- or understand that other person is not interested from their body language)","A","2",0);
        addQuestion(q28);
        Question q29 = new Question("X does not use gestures appropriately (e.g. actions like pointing, waving, nodding/shaking head, beckoning, shushing, putting out hands to ask for something)","A","2",0);
        addQuestion(q29);
        Question q30 = new Question("X does not understand gestures appropriately (e.g. actions as above)","A","2",0);
        addQuestion(q30);
        Question q31 = new Question("X does not understand change in tone of voice indicating request to change behaviour","A","2",0);
        addQuestion(q31);
        Question q32 = new Question("X has an unusual way of talking (abnormal volume, pitch, intonation, rate, rhythm, stress or prosody in speech)","A","2",0);
        addQuestion(q32);
        Question q33 = new Question("You cannot understand from X’s facial expression what X feels like","A","2",0);
        addQuestion(q33);
        Question q34 = new Question("X doesn’t show a warm, joyful expression when facing others","A","2",0);
        addQuestion(q34);
        Question q35 = new Question("X is unable to understand or interpret other’s facial expressions","A","2",0);
        addQuestion(q35);
        Question q36 = new Question("X has a difficulty in putting together eye contact facial expressions with gestures and body postures (Coordinating non‐verbal communication)","A","2",0);
        addQuestion(q36);
        Question q37 = new Question("X is unable to put together facial expressions, eye contact, gestures and body language to match the words X is coming out with i.e. asking for help or getting other person’s attention to something he is anxious/worried about","A","2",0);
        addQuestion(q37);
        Question q38 = new Question("X has a difficulty in conveying his thoughts, feelings and emotions using words, facial expressions, tone of voice, gestures and body language (postures)","A","2",0);
        addQuestion(q38);

        //A3 : Relationships


        Question q39 = new Question("X doesn't make or sustain friendship like other children of his age","A","3",0);
        addQuestion(q39);
        Question q40 = new Question("X does not enjoy playing with children of his age or developmental level(choses to play with older or younger than him)","A","3",0);
        addQuestion(q40);
        Question q41 = new Question("X prefer adult company over children","A","3",0);
        addQuestion(q41);
        Question q42 = new Question("X's friends consider him as odd and seem like they are trying to avoid him","A","3",0);
        addQuestion(q42);
        Question q43 = new Question("X doesn't get invited for play dates/ parties like other children of his age","A","3",0);
        addQuestion(q43);
        Question q44 = new Question("X does not show an interest in inviting X’s mates for play dates/ or birthday parties","A","3",0);
        addQuestion(q44);
        Question q45 = new Question("X does not seem to take another person’s perspective (Age ≥ 4 years)","A","3",0);
        addQuestion(q45);
        Question q46 = new Question("X does not seem to notice that the other person is not interested in an activity/play or a topic of conversation that he wants them to engage in","A","3",0);
        addQuestion(q46);
        Question q47 = new Question("X does not notice when he is being teased or ridiculed by others","A","3",0);
        addQuestion(q47);
        Question q48 = new Question("X does not alter his behaviour according to where he is? (i.e. library vs park)","A","3",0);
        addQuestion(q48);
        Question q49 = new Question("X does not alter his behaviour with adults in authority or strangers versus family members","A","3",0);
        addQuestion(q49);
        Question q50 = new Question("X shows inappropriate expressions of emotion? (laughing or smiling i.e. when someone is hurt or upset)","A","3",0);
        addQuestion(q50);
        Question q51 = new Question("X is unaware of social conventions or appropriate social behaviour and can ask socially inappropriate questions or make socially inappropriate statements","A","3",0);
        addQuestion(q51);
        Question q52 = new Question("X does not notice how X’s behaviour affects others emotionally (makes them happy, unhappy OR annoyed) and carries on","A","3",0);
        addQuestion(q52);
        Question q53 = new Question("X does not engage in pretend play with peers(making up stories and characters within the play)","A","3",0);
        addQuestion(q53);
        Question q54 = new Question("X does not understand when other children are pretending","A","3",0);
        addQuestion(q54);
        Question q55 = new Question("X finds it difficult to make friends easily","A","3",0);
        addQuestion(q55);
        Question q56 = new Question("X does not respond to the social approaches of other children warmly","A","3",0);
        addQuestion(q56);
        Question q57 = new Question("X does not have preferred friends","A","3",0);
        addQuestion(q57);
        Question q58 = new Question("X does not enjoy playing in groups of children","A","3",0);
        addQuestion(q58);
        Question q59 = new Question("X lacks understanding of the rules of and becomes extremely directive and bossy (everything has to be on his agenda)","A","3",0);
        addQuestion(q59);
        Question q60 = new Question("X’s interaction is limited with others, withdrawn or aloof or ‘in his own world’","A","3",0);
        addQuestion(q60);
        Question q61 = new Question("X does not try to attract attention of others and would rather remain unnoticed","A","3",0);
        addQuestion(q61);
        Question q62 = new Question("X would prefer solitary activities /play on X’s own rather than with other children","A","3",0);
        addQuestion(q62);
        Question q63 = new Question("X does not understand cues/ prompts from others suggesting that a change in X’s behaviour is expected? (i.e. when becoming over-personal with unfamiliar people)","A","3",0);
        addQuestion(q63);

        //B1 : Stereotypes

        Question q64 = new Question("X has pedantic speech or he speaks in an unusually formal precise language (e.g. child speaks like an adult or 'little professor' – calls his ‘mum’ mother )","B","1",0);
        addQuestion(q64);
        Question q65 = new Question("X repeats words, odd phrases, dialogue or more extensive songs that X has heard from surroundings over and over again out of context (echolalia/ perseverative language)? ","B","1",0);
        addQuestion(q65);
        Question q66 = new Question("X comes out with gibberish or ‘jargon’ (mature jargoning after age of 24 months)","B","1",0);
        addQuestion(q66);
        Question q67 = new Question("X uses language that has some meaning only to those who know X and who are used to X’s way of talking (idiosyncratic language)","B","1",0);
        addQuestion(q67);
        Question q68 = new Question("X uses made up words (neologisms) in his conversations","B","1",0);
        addQuestion(q68);
        Question q69 = new Question("X says 'he, she for I'  OR  'You for I' (pronoun reversal)","B","1",0);
        addQuestion(q69);
        Question q70 = new Question("X refers to himself by own name (does not use “I”)","B","1",0);
        addQuestion(q70);
        Question q71 = new Question("X goes around making unusual guttural noises, unusual squealing, repetitive humming or intonational noises (repetitive vocalisations or noises)","B","1",0);
        addQuestion(q71);
        Question q72 = new Question("X displays finger flicking, flapping or twisting his hands (Repetitive purposeless hand movements)","B","1",0);
        addQuestion(q72);
        Question q73 = new Question("X shows unusual whole body movements like toe walking, foot to foot rocking, dipping & swaying, spinning (Stereotyped or complex whole body movements)","B","1",0);
        addQuestion(q73);
        Question q74 = new Question("X is seen to display grimacing, teeth grinding, intense body tensing, clenching","B","1",0);
        addQuestion(q74);
        Question q75 = new Question("X shows perseverative or purposeless repetitive action, play or behaviour","B","1",0);
        addQuestion(q75);
        Question q76 = new Question("X waves sticks or drops items (Nonfunctional play with objects), opens and shuts doors or turns lights on and off","B","1",0);
        addQuestion(q76);
        Question q77 = new Question("X lines up toys or objects","B","1 ",0);
        addQuestion(q77);

        //B2 : Rigid routines rituals

        Question q78 = new Question("X has unusual routines- specific, multiple‐step sequences of behaviour","B","2",0);
        addQuestion(q78);
        Question q79 = new Question("X insists on rigidly following specific routines","B","2",0);
        addQuestion(q79);
        Question q80 = new Question("X has repetitive questioning about a particular topic","B","2",0);
        addQuestion(q80);
        Question q81 = new Question("X has certain unusual compulsive ritualistic behaviour (e.g. insistence on turning in a circle three times before entering a room)","B","2",0);
        addQuestion(q81);
        Question q82 = new Question("X is excessively rigid, inflexible, or rule‐bound in behaviour- that X insists that you do it in a particular way or order. Please describe in the comment box","B","2",0);
        addQuestion(q82);
        Question q83 = new Question("X doesn’t like food being mixed or touching each other","B","2 ",0);
        addQuestion(q83);
        Question q84 = new Question("X has a difficulty in moving from one activity/conversation/environment that X is engaged in to another one (transitions) that is out of range of what is seen in children of that age","B","2",0);
        addQuestion(q84);
        Question q85 = new Question("X shows an overreaction to little changes in environment (moving items at dinner table, furniture or driving an alternate route) that should not generally affect other children","B","2",0);
        addQuestion(q85);
        Question q86 = new Question("X takes things literally (Unable to understand humour, irony or implied meaning)","B","2",0);
        addQuestion(q86);
        Question q87 = new Question("X has an immense sense of justice and can’t tolerate slightest of change to it","B","2",0);
        addQuestion(q87);
        Question q88 = new Question("X cannot tolerate sudden change of plans and needs constant updating","B","2",0);
        addQuestion(q88);

        //B3 : Fixated Interests

        Question q89 = new Question("X has certain interests/ hobbies that are so strong that interferes with his/your life","B","3",0);
        addQuestion(q89);
        Question q90 = new Question("X is focused on the same few objects, topics or activities","B","3",0);
        addQuestion(q90);
        Question q91 = new Question("X has an unusual preoccupation with numbers, letters, symbols","B","3",0);
        addQuestion(q91);
        Question q92 = new Question("X can be overly perfectionistic and finds it difficult to cope with failures","B","3",0);
        addQuestion(q92);
        Question q93 = new Question("X has interests that are unusual and abnormal in focus (i.e. traffic lights, escalators, lifts)","B","3",0);
        addQuestion(q93);
        Question q94 = new Question("X can excessively focus on non-relevant or nonfunctional parts of objects (like wheels of toy car)","B","3",0);
        addQuestion(q94);
        Question q95 = new Question("X has unusual preoccupations (e.g. color; time tables; historical events, etc)?","B","3",0);
        addQuestion(q95);
        Question q96 = new Question("X is overtly attached to unusual inanimate object (e.g., piece of string, stone, stick or rubber band)?","B","3",0);
        addQuestion(q96);
        Question q97 = new Question("X notices trivia or little things rather than seeing the big picture","B","3",0);
        addQuestion(q97);

        //B4. Reactivity sensory stimulus

        Question q98 = new Question("X is sensitive to feel of certain objects or textures:  labels, woolen clothes, tights","B","4",0);
        addQuestion(q98);
        Question q99 = new Question("X has significant aversion to having hair or toenails cut or teeth brushed","B","4",0);
        addQuestion(q99);
        Question q100 = new Question("X doesn’t like the feel of certain food stuff in his mouth","B","4",0);
        addQuestion(q100);
        Question q101 = new Question("X is seen to closely inspect objects or self for no clear purpose (for example, holding things at unusual angles) (not due to visual impairment) OR look at people out of the corner of their eyes or squinting at them","B","4",0);
        addQuestion(q101);
        Question q102 = new Question("X has an unusual fascination with watching movement of things (e.g., spinning wheels of toys, the opening and closing of doors, electric fan or other rapidly revolving object)","B","4",0);
        addQuestion(q102);
        Question q103 = new Question("X becomes extremely distressed by atypical/ loud sudden noises (traffic, siren, drill, hand dryers etc)","B","4",0);
        addQuestion(q103);
        Question q104 = new Question("X can differentiate subtle change in the taste (e.g.brand change) of food given to him","B","4",0);
        addQuestion(q104);
        Question q105 = new Question("X is found licking or sniffing objects  before tasting","B","4",0);
        addQuestion(q105);







    }
    private void addQuestion(Question question){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION , question.getQuestion());
        cv.put(QuestionsTable.COLUMN_DOMAIN , question.getDomain());
        cv.put(QuestionsTable.COLUMN_SUBDOMAIN , question.getSubdomain());
        cv.put(QuestionsTable.COLUMN_SCORE , question.getScoreObtained());

        db.insert(QuestionsTable.TABLE_NAME,null,cv);
    }

    public List<Question> getAllQuestions(){
        List<Question> questionList = new ArrayList<>();

        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+ QuestionsTable.TABLE_NAME,null);
        if (c.moveToFirst()){
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setDomain(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DOMAIN)));
                question.setSubdomain(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_SUBDOMAIN)));
                question.setScoreObtained(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_SCORE)));
                questionList.add(question);
            }while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

}
