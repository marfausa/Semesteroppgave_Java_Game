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


public class QuizModelTest{
  @Test
  public void modelTest(){
    QuizWordFactory qwf = new QuizWordFactory();
    
    QuizModel model = new QuizModel();
    DrawView view = new DrawView(model);

    ArrayList<QuizWord> list = model.getWordList();
    assertEquals(4,model.levelList.size());
    assertEquals(4, list.size());
    assertTrue(true, model.currentQuestion);
    assertTrue(true, model.currentAnswer);
    
    //Level 1
    assertEquals(1,model.getCurrentLevel());
    model.nextStage();
    assertEquals(3,model.levelList.size());
    model.nextStage();
    assertEquals(2,model.levelList.size());
    model.nextStage();
    assertEquals(1,model.levelList.size());
    model.nextStage();
    assertEquals(0,model.levelList.size());

    //Level 2
    model.nextStage();
    assertEquals(2,model.getCurrentLevel());
    
    assertEquals(4,model.levelList.size());
    model.nextStage();
    assertEquals(3,model.levelList.size());
    model.nextStage();
    assertEquals(2,model.levelList.size());
    model.nextStage();
    assertEquals(1,model.levelList.size());
    model.nextStage();

    //Level 3
    model.nextStage();
    assertEquals(4,model.levelList.size());
    model.nextStage();
    assertEquals(3,model.levelList.size());
    model.nextStage();
    assertEquals(2,model.levelList.size());
    model.nextStage();
    assertEquals(1,model.levelList.size());
    model.nextStage();

    //Level 4
    model.nextStage();
    assertEquals(4,model.levelList.size());
    model.nextStage();
    assertEquals(3,model.levelList.size());
    model.nextStage();
    assertEquals(2,model.levelList.size());
    model.nextStage();
    assertEquals(1,model.levelList.size());
    model.nextStage();

    //Level 5
    model.nextStage();
    assertEquals(4,model.levelList.size());
    model.nextStage();
    assertEquals(3,model.levelList.size());
    model.nextStage();
    assertEquals(2,model.levelList.size());
    model.nextStage();
    assertEquals(1,model.levelList.size());
    model.nextStage();

  }

}

  
