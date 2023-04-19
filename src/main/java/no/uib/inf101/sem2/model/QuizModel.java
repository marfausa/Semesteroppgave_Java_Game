package no.uib.inf101.sem2.model;

import no.uib.inf101.sem2.controller.ControllableQuizModel;
import no.uib.inf101.sem2.view.ViewableQuizModel;

public class QuizModel implements ViewableQuizModel, ControllableQuizModel {
    private GameState gameState;

    private QuizWord currentQuizWord; // I staden for eigen klasse, gjerne string?
    private QuizWordFactory quizWordFactory;

    private int level;

    private String currentInput = "";    

    public QuizModel(QuizWordFactory quizWordFactory) {
        this.quizWordFactory = quizWordFactory;
        level = 1;
        
    }
    
    @Override
    public GameState getGameState() {
        return this.gameState;
    }
    @Override
    public void updateInputString(char c) {
        currentInput += c;
        System.out.println(currentInput);
    }
    

}
