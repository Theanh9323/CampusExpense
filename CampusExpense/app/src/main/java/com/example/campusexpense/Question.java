package com.example.campusexpense;

public class Question {
    private String answer;
    private int image;
    public Question(String answer, int image) {
        this.answer = answer;
        this.image = image;
    }
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
