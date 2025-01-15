package no.uib.inf101.sem2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.ArrayList;


public class QuizWordTest{
  @Test
  public void sanityTest(){
    QuizWordFactory qwf = new QuizWordFactory();
    assertEquals(61, qwf.getWordList(1).size());
    
    QuizModel model = new QuizModel();

    ArrayList<QuizWord> l = new ArrayList<>();
    assertEquals(0, l.size());
    assertEquals(61, qwf.getWordList(1).size());
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

  
