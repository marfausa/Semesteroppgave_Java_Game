package no.uib.inf101.sem2.view;



import java.awt.geom.Rectangle2D;

import no.uib.inf101.sem2.model.GameState;

public interface ViewableQuizModel {
    
     /**
     * @return GameState objekt, om det er Game Over eller ikke
     */
    GameState getGameState();

     /**
     * @return Rectangle2D objekt som indikerer en knapp som er mulig å klikke på
     */
    Rectangle2D getButton();
}
