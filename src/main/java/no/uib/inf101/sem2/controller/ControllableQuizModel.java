package no.uib.inf101.sem2.controller;

import no.uib.inf101.sem2.model.GameState;

public interface ControllableQuizModel {
    
    /**
     * @return GameState objekt, om det er Game Over, i hovedmeny, aktivt spill, eller vunnet spill.
     */
    GameState getGameState();


    /**
     * @param input Skriver inn hver bokstav og bygger opp en String med disse, sender det til modellen slik at det viser input
     * i view i sanntid. 
     */
    void updateInputString(String input);

    /**
     * @param input Dersom enter-tasten trykkes vil det av input sjekkes opp mot riktig svar.
     * @return true/false
     * 
     */
    public boolean inputCheckAnswer(String input);

    /**
     * Sjekker svar og tømmer gjeldende input.
     * @return riktig svar i String for gjeldende ord
     */
    public String getInputAnswer();

    /**
     * Brukes for å starte en level, dersom listen med ord er tom. Er listen tom, vil den hente inn 5 ord fra QuizWordFactory.
     * Deretter vil level plusses med 1. Level startet på 0, men øker for hver gang det hentes en ny liste. 
     * @return true/false
     * 
     */
    public boolean startLevel();

    /**
     * @return Henter gjeldende level som int-verdi.
     */
    public int getCurrentLevel();




}
