package no.uib.inf101.sem2;

import no.uib.inf101.sem2.controller.QuizController;
import no.uib.inf101.sem2.model.QuizModel;
import no.uib.inf101.sem2.view.DrawView;

import javax.swing.JFrame;

public class Main {
  public static void main(String[] args) {

    QuizModel model = new QuizModel();
    DrawView view = new DrawView(model);

    QuizController quizController = new QuizController(model);

    JFrame frame = new JFrame();
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("NynorskKviss");
    frame.setContentPane(view);
    frame.pack();
    frame.setVisible(true);

    frame.addKeyListener(quizController);
  }
}
