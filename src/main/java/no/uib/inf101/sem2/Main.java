package no.uib.inf101.sem2;

import no.uib.inf101.sem2.model.QuizModel;
import no.uib.inf101.sem2.view.QuizView;

import javax.swing.JFrame;

public class Main {
  public static void main(String[] args) {
    QuizModel model = new QuizModel();
    QuizView view = new QuizView(model);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("INF101");
    frame.setContentPane(view);
    frame.pack();
    frame.setVisible(true);
  }
}
