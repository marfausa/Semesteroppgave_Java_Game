package no.uib.inf101.sem2.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import no.uib.inf101.sem2.model.GameState;

public class QuizController implements KeyListener{
    private ControllableQuizModel controller;
    String currentInput;

    public QuizController (ControllableQuizModel cqm){
        controller = cqm;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if (controller.getGameState() == GameState.ACTIVE_GAME){

            String currentInput = controller.getInputAnswer();
            char keyChar = e.getKeyChar();
            
            if (keyChar == KeyEvent.VK_ENTER) {
                // Enter key was pressed
                if (controller.inputCheckAnswer(currentInput) == false){
                    currentInput = "";
                } else if (controller.inputCheckAnswer(currentInput)){
                    currentInput = "";

                }

            } else if (keyChar == KeyEvent.VK_BACK_SPACE) {
                // Backspace key was pressed
                if (currentInput.length() > 0) {
                    String deletedInput = currentInput.substring(0, currentInput.length() - 1);
                    currentInput = deletedInput;
                }
            } else if (keyChar != KeyEvent.CHAR_UNDEFINED) {
                // Some other key was pressed
                currentInput += keyChar;
                
            }
            controller.updateInputString(currentInput);
    }
    }
        

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
