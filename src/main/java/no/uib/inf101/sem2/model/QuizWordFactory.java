package no.uib.inf101.sem2.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;


public class QuizWordFactory {
    
     //String[] quizWords;
     QuizWord[] quizWords = {
        new QuizWord("Hugleik","fantasi", Color.RED),
        new QuizWord("Hovmod", "arroganse", Color.BLUE),
        new QuizWord("Hugleik", "fantasi", Color.RED),
        new QuizWord("Hovmod", "arroganse", Color.BLUE),
        new QuizWord("Hugleik", "fantasi", Color.RED),
        new QuizWord("Hovmod", "arroganse", Color.BLUE),
        new QuizWord("Hugleik", "fantasi", Color.RED),
        new QuizWord("Hovmod", "arroganse", Color.BLUE)
};

ArrayList<QuizWord> questions = new ArrayList<>();

public QuizWordFactory() {
    for (int i = 0; i < quizWords.length; i++) {
        questions.add(quizWords[i]);
    }
}

public ArrayList<QuizWord> GetNewQuizWords() {
    ArrayList<QuizWord> selection = new ArrayList<>();
    Random r = new Random();
    // r.nextInt(0)
    // selection.add
    // fjern frå questions
    return selection;
}


}
