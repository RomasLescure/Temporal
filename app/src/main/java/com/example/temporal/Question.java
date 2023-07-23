package com.example.temporal;


import java.io.Serializable;

public class Question implements Serializable{
    private String question;
    private String[] options;
    private int correctAnswerIndex;
    private int selectedAnswerIndex = -1;

    public Question(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public int getSelectedAnswerIndex() {
        return selectedAnswerIndex;
    }

    public void setSelectedAnswerIndex(int selectedAnswerIndex) {
        this.selectedAnswerIndex = selectedAnswerIndex;
    }

    public boolean isAnswered() {
        return selectedAnswerIndex != -1;
    }

    public boolean isCorrect() {
        return selectedAnswerIndex == correctAnswerIndex;
    }
}
