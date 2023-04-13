package no.uib.inf101.sem2.controller;

import no.uib.inf101.sem2.model.GameState;

public interface ControllableQuizModel {
    
    /**
     * @return GameState objekt, om det er Game Over eller ikke
     */
    GameState getGameState();
}
