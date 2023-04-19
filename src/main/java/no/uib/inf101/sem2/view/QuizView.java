package no.uib.inf101.sem2.view;

import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;

import java.awt.geom.Rectangle2D;
import javax.swing.Timer;

import no.uib.inf101.sem2.model.GameState;



/**
 * A sample view to get you inspired for your own project.
 */
public class QuizView implements ViewableQuizModel {

  private ViewableQuizModel model;
  final int PANEL_WIDTH;
  final int PANEL_HEIGHT;
 
  GameState gamestate = GameState.ACTIVE_GAME;
  TitleScreen titleScreen;
  Timer timer;

  boolean startCountdown = false;
  boolean startedQuiz = false;
  boolean startLevel5 = false;
  boolean startLevel4 = false;
  boolean startLevel3 = false;
  boolean startLevel2 = false;
  boolean startLevel1 = false;
  
  int countdown = 4;
  float start = 60f;
  float end = 180f;
  
  public QuizView(int pw, int ph, ViewableQuizModel model) {
    PANEL_WIDTH = pw;
    PANEL_HEIGHT = ph;
    this.model = model;

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
    g2.setColor(Color.BLACK);
    g2.draw(rect);
    g2.fill(rect);
    g2.setColor(Color.WHITE);

    
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
    if (countdown <-1){
      Inf101Graphics.drawCenteredString(g2, "ORD 1", rect, this.start);
      if (this.start > 179f){
        g2.setColor(Color.RED);
        Inf101Graphics.drawCenteredString(g2, "ORD 1", rect, this.end);
      }
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


  
}


