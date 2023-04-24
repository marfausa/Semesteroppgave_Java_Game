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

    /**
     * @return Ordet som skal oversettes fra QuizWord-objekt.
     */
    public String getQuestion(){
        return this.word;
    }
    
     /**
     * @return Riktig fasit fra QuizWord-objekt.
     */
    public String getAnswer(){
        return this.answer;
    }

     /**
     * @return Fargen som forbindes med QuizWord-objekt.
     */
    public Color getWordColor(){
        return this.color;
    }


}
