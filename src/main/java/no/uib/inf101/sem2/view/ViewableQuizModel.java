package no.uib.inf101.sem2.view;

import no.uib.inf101.sem2.model.GameState;

public interface ViewableQuizModel {
    
     /**
     * @return GameState objekt, om det er Game Over eller ikke
     */
    GameState getGameState();
}
