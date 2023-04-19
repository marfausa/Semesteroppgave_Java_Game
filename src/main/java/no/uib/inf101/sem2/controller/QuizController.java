package no.uib.inf101.sem2.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import no.uib.inf101.sem2.view.DrawView;

public class QuizController implements KeyListener{
    private ControllableQuizModel controller;
    private DrawView view;

    public QuizController (ControllableQuizModel cqm, DrawView qv){
        controller = cqm;
        view = qv;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
         // if(e.getKeyCode(KeyStroke.))
        // controller.checkAnswer();
        controller.updateInputString(e.getKeyChar());

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
