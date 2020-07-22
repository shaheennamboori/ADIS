package com.vidya.adis;

public class Question {
    private String question;
    private String domain;
    private String subdomain;
    private int scoreObtained;

    public Question(String question, String domain, String subdomain, int scoreObtained) {
        this.question = question;
        this.domain = domain;
        this.subdomain = subdomain;
        this.scoreObtained = scoreObtained;
    }

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }

    public int getScoreObtained() {
        return scoreObtained;
    }

    public void setScoreObtained(int scoreObtained) {
        this.scoreObtained = scoreObtained;
    }
}
