package no.uib.inf101.sem2;

import no.uib.inf101.sem2.model.QuizModel;
import no.uib.inf101.sem2.view.TitleScreen;

import javax.swing.JFrame;

public class Main {
  public static void main(String[] args) {
    QuizModel model = new QuizModel();
    TitleScreen view = new TitleScreen(model);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("INF101");
    frame.setContentPane(view);
    frame.pack();
    frame.setVisible(true);
  }
}
