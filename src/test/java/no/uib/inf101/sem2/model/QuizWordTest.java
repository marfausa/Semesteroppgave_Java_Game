package no.uib.inf101.sem2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import no.uib.inf101.sem2.controller.QuizController;
import no.uib.inf101.sem2.view.DrawView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;


public class QuizWordTest{
  @Test
  public void sanityTest(){
    QuizWordFactory qwf = new QuizWordFactory();
    assertEquals(9, qwf.getWordList(1).size());
    
    QuizModel model = new QuizModel(qwf);
    DrawView view = new DrawView(model);

    ArrayList<QuizWord> l = new ArrayList<>();
    assertEquals(0, l.size());
    assertEquals(4, qwf.getWordList(1).size());
    assertEquals(5, qwf.GetNewQuizWords(3).size());

    QuizWord word = new QuizWord("kjærleik", "kjærlighet", null);

    

    String a = word.getQuestion();
    String b = word.getAnswer();
    assertTrue(a == "kjærleik");
    assertTrue(b == "kjærlighet");

    ArrayList<QuizWord> list = model.getWordList();
        int counter = 0;
        assert list != null && !list.isEmpty();
        
        for (QuizWord element : list) {
            System.out.println(element.getQuestion());
            counter +=1;
        }
    assertEquals(4, counter);

    assertEquals(4, model.getWordList().size());
    model.getCurrentWord();
    model.getCurrentWord();
    assertEquals(2, model.getWordList().size());
    
  }
  

}

  
