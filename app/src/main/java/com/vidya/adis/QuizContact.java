package com.vidya.adis;

import android.provider.BaseColumns;

public final class QuizContact {

    public QuizContact() {

    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_DOMAIN  = "domain";
        public static final String COLUMN_SUBDOMAIN = "subdomain";
        public static final String COLUMN_SCORE = "score";
    }
}
