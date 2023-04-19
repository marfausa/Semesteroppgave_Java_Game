package no.uib.inf101.sem2.view;

import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;

import java.awt.geom.Rectangle2D;
import javax.swing.Timer;

import no.uib.inf101.sem2.model.GameState;
import no.uib.inf101.sem2.model.QuizModel;
import no.uib.inf101.sem2.model.QuizWord;


public class QuizView implements ViewableQuizModel {

  private QuizModel model;
  private InputBox inputBox;
  final int PANEL_WIDTH;
  final int PANEL_HEIGHT;
 
  GameState gamestate;
  QuizWord currentWord;
  String currentQuestion;
  String currentAnswer;
  Timer timer;

  boolean startCountdown = false;
  boolean startedQuiz = false;
  boolean startLevel5 = false;
  boolean startLevel4 = false;
  boolean startLevel3 = false;
  boolean startLevel2 = false;
  boolean startLevel1 = false;
  
  int stageCounter;
  int countdown = 4;
  float start = 60f;
  float end = 180f;
  
  public QuizView(int pw, int ph, QuizModel model) {
    PANEL_WIDTH = pw;
    PANEL_HEIGHT = ph;

    this.model = model;
    gamestate = this.model.getGameState();
    currentWord = this.model.getCurrentWord();
    currentQuestion = this.currentWord.getQuestion();
    currentAnswer = this.currentWord.getAnswer();
    
    timer = new Timer(1000, this);
    

    }

      
  @Override
  public void actionPerformed(ActionEvent e) {
    countDown();
    startCountdown = true;
    if (startedQuiz){
      timer.setDelay(1);
      expandingWord();
    }
    }
  
  @Override
  public GameState getGameState() {
    return this.gamestate;
  }

  public void startTimer(){
    timer.start();
  }

  public void draw(Graphics2D g2, Rectangle2D rect) {
    inputBox = new InputBox(g2, rect, currentAnswer);
    g2.setColor(Color.BLACK);
    g2.draw(rect);
    g2.fill(rect);
    g2.setColor(Color.WHITE);

    drawCountdown(g2, rect);

    if (startLevel5){
      stageCounter = 1;
    }
    
    if (countdown <-1){
      Inf101Graphics.drawCenteredString(g2, currentQuestion, rect, this.start);
      inputBox.drawInputBox();
      }
    if (this.start > 179f){
      g2.setColor(Color.RED);
      Inf101Graphics.drawCenteredString(g2, currentQuestion, rect, this.end);
        }
    
    }
  
  
  private void countDown(){
    if (startCountdown){
      countdown -= 1;
    } 
  }

  private void expandingWord(){
    if (start < end){
      start *= 1.0003;
    }
  }

  private void drawCountdown(Graphics2D g2, Rectangle2D rect){
    if (countdown > 3){
      Inf101Graphics.drawCenteredString(g2, "Gjer klar for nedteljing", rect, 60f);
    } else if (countdown > 0){
      Inf101Graphics.drawCenteredString(g2, String.valueOf(countdown), rect, 60f);
    } 
    if (countdown == 0){
      Inf101Graphics.drawCenteredString(g2, "KVISS START!", rect, 60f);
      startedQuiz = true;
    }

    if (countdown ==-1){
      Inf101Graphics.drawCenteredString(g2, "Level 5", rect, 80f);
      startLevel5 = true;
    }
  }



  
}


