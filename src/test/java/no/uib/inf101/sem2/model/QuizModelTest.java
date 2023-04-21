package no.uib.inf101.sem2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.ArrayList;


public class QuizModelTest{
  @Test
  public void modelTest(){
    QuizModel model = new QuizModel();

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
    assertEquals(0,model.levelList.size());

    //Level 3
    model.nextStage();
    assertEquals(3,model.getCurrentLevel());
    
    assertEquals(4,model.levelList.size());
    model.nextStage();
    assertEquals(3,model.levelList.size());
    model.nextStage();
    assertEquals(2,model.levelList.size());
    model.nextStage();
    assertEquals(1,model.levelList.size());
    model.nextStage();
    assertEquals(0,model.levelList.size());

    //Level 4
    model.nextStage();
    assertEquals(4,model.getCurrentLevel());
    assertEquals(4,model.levelList.size());
    model.nextStage();
    assertEquals(3,model.levelList.size());
    model.nextStage();
    assertEquals(2,model.levelList.size());
    model.nextStage();
    assertEquals(1,model.levelList.size());
    model.nextStage();
    assertEquals(0,model.levelList.size());

    //Level 5
    model.nextStage();
    assertEquals(5,model.getCurrentLevel());
    assertEquals(4,model.levelList.size());
    model.nextStage();
    assertEquals(3,model.levelList.size());
    model.nextStage();
    assertEquals(2,model.levelList.size());
    model.nextStage();
    assertEquals(1,model.levelList.size());
    model.nextStage();
    assertEquals(0,model.levelList.size());

  }

}

  
