package no.uib.inf101.sem2.view;

import java.awt.event.ActionListener;

import no.uib.inf101.sem2.model.GameState;

public interface ViewableQuizModel extends ActionListener{
    
     /**
     * @return GameState objekt, om det er Game Over eller ikke
     */
    GameState getGameState();
}
