package no.uib.inf101.sem2.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class QuizController implements KeyListener{
    private ControllableQuizModel controller;

    public QuizController (ControllableQuizModel cqm){
        controller = cqm;

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
