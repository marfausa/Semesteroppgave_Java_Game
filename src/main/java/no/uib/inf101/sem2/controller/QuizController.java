package no.uib.inf101.sem2.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import no.uib.inf101.sem2.view.DrawView;

public class QuizController implements KeyListener{
    private ControllableQuizModel controller;
    private DrawView view;
    String currentInput;

    public QuizController (ControllableQuizModel cqm, DrawView qv){
        controller = cqm;
        view = qv;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
         // if(e.getKeyCode(KeyStroke.))
        // controller.checkAnswer();
        String currentInput = controller.getInputAnswer();
        char keyChar = e.getKeyChar();
        
        if (keyChar == KeyEvent.VK_ENTER) {
            // Enter key was pressed
           if (controller.inputCheckAnswer(currentInput) == false){
                currentInput = "";
           } else if (controller.inputCheckAnswer(currentInput)){
            currentInput = "RIKTIG";
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
        

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
