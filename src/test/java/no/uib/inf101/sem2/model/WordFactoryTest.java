package no.uib.inf101.sem2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class WordFactoryTest{
  @Test
  public void ListLengthTest(){
    QuizWordFactory qwf = new QuizWordFactory();
    ArrayList<QuizWord> level1 = qwf.getWordList(1);
    ArrayList<QuizWord> level2 = qwf.getWordList(2);
    ArrayList<QuizWord> level3 = qwf.getWordList(3);
    ArrayList<QuizWord> level4 = qwf.getWordList(4);
    ArrayList<QuizWord> level5 = qwf.getWordList(5);

    assertEquals(9, level1.size());
    assertEquals(7, level2.size());
    assertEquals(7, level3.size());
    assertEquals(9, level4.size());
    assertEquals(9, level5.size());

  }

  @Test
  public void SelectedListTest(){
    QuizWordFactory qwf = new QuizWordFactory();
    ArrayList<QuizWord> level1 = qwf.GetNewQuizWords(1);
    ArrayList<QuizWord> level2 = qwf.GetNewQuizWords(2);
    ArrayList<QuizWord> level3 = qwf.GetNewQuizWords(3);
    ArrayList<QuizWord> level4 = qwf.GetNewQuizWords(4);
    ArrayList<QuizWord> level5 = qwf.GetNewQuizWords(5);


    assertEquals(5, level1.size());
    assertEquals(5, level2.size());
    assertEquals(5, level3.size());
    assertEquals(5, level4.size());
    assertEquals(5, level5.size());
  }
  
  }

