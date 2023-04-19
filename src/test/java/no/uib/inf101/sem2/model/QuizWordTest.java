package no.uib.inf101.sem2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
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
    QuizModel model = new QuizModel(qwf);
    QuizWord word = new QuizWord("kjærleik", "kjærlighet", null);

    String a = word.getQuestion();
    String b = word.getAnswer();
    assertTrue(a == "kjærleik");
    assertTrue(b == "kjærlighet");
    

    
  }
  

}

  
