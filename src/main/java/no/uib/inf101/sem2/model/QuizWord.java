package no.uib.inf101.sem2.model;

import java.awt.Color;

public class QuizWord {
    
    private String word;
    private String answer;
    private Color color;

    QuizWord(String word, String answer, Color color) {
        this.word = word;
        this.answer = answer;
        this.color = color;
    }

    public String getQuestion(){
        return this.word;
    }
    public String getAnswer(){
        return this.answer;
    }
    public Color getWordColor(){
        return this.color;
    }


}
