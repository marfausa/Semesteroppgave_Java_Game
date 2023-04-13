package no.uib.inf101.sem2.model;

import no.uib.inf101.sem2.controller.ControllableQuizModel;
import no.uib.inf101.sem2.view.ViewableQuizModel;

public class QuizModel implements ViewableQuizModel, ControllableQuizModel {
    private GameState gameState;

    public QuizModel(){

    }
    @Override
    public GameState getGameState() {
        return this.gameState;
    }
    
}
