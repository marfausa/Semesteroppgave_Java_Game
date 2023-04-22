package no.uib.inf101.sem2.view;

import java.awt.Color;
import java.awt.Font;
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
  boolean quizClear = false;
  
  
  int numQuestions = 25;
  int stageCounter = 0;

  int countdown;
  int stageInterval = 0;
  int levelUp = 0;

  int level = 0;

  boolean wrongAnswer;
  boolean correctAnswer;
  

  float start = 60f;
  float end = 240f;
  
  public QuizView(int pw, int ph, QuizModel model, int tick) {
    PANEL_WIDTH = pw;
    PANEL_HEIGHT = ph;

    this.model = model;
    gamestate = this.model.getGameState();
    this.currentQuestion = this.model.getCurrentQuestion();
    this.currentAnswer = this.model.getCurrentAnswer();
    
    countdown = tick;
    timer = new Timer(1000, this);
    
    }

      
  @Override
  public void actionPerformed(ActionEvent e) {
    countDown();
    if (startedQuiz){
      
      if (stageInterval == -1){
        expandingWord();
      }

    }
    if (gamestate == GameState.GAME_OVER){
      timer.stop();
    }

    }
  
  @Override
  public GameState getGameState() {
    return this.gamestate;
  }

  public void startTimer(){
    this.startCountdown = true;
    timer.start();
  }

  public void draw(Graphics2D g2, Rectangle2D rect) {
    inputBox = new InputBox(g2, rect, this.model.getInputAnswer());
 
    g2.setColor(Color.BLACK);
    g2.draw(rect);
    g2.fill(rect);
    g2.setColor(Color.WHITE);

    if (numQuestions == 25){
        drawCountdown(g2, rect);
    }
    if (numQuestions == 0){
      this.quizClear = true;
    }
    drawAmountofQuestions(g2, rect);
    drawQuizStage(g2, rect);
    
  }

  public boolean isQuizCleared(){
    return this.quizClear;
  }


  private void drawQuizStage(Graphics2D g2, Rectangle2D rect){
    String correctInput = model.getCorrectUserAnswer();


    if (this.countdown == -1){
      stageInterval = this.countdown;
    }

    if (stageInterval == -1){
        g2.setColor(model.getCurrentColor());
        Inf101Graphics.drawCenteredString(g2, model.getCurrentQuestion(), rect, this.start);
        inputBox.drawInputBox();  
    }
    if (this.start > this.end){
         g2.setColor(Color.RED);
         Inf101Graphics.drawCenteredString(g2, model.getCurrentQuestion(), rect, this.start);
         gamestate = GameState.GAME_OVER; 

    } else if (correctInput != null && correctInput.equalsIgnoreCase(model.getCurrentAnswer())){
      this.model.nextStage();
      this.numQuestions -= 1;
      this.start = 60f;
    }

   
  }

   
  public void drawAmountofQuestions(Graphics2D g2, Rectangle2D rect){
    if (startedQuiz){
      g2.setColor(model.getCurrentColor());
      g2.setFont(new Font("Arial", Font.PLAIN, 24));
      g2.drawString("NIVÅ: " + model.getCurrentLevel(), 1000, 100);
      
      g2.setColor(Color.WHITE);
      g2.drawString("Resterande oppgåver: " + numQuestions, 80, 100);

      if (this.start == 192){
        g2.setColor(Color.RED);
        g2.drawString("3", 500, 100);
      }
      if (this.start == 208){
        g2.setColor(Color.RED);
        g2.drawString("2", 500, 100);
      }
      if (this.start == 239){
        g2.setColor(Color.RED);
        g2.drawString("1", 500, 100);
      }


      String wrongInput = model.getWrongUserAnswer();
      if (wrongInput != null && !wrongInput.equalsIgnoreCase(model.getCurrentAnswer())){
        wrongAnswer = true;
      }
  
      if ( wrongAnswer && wrongInput != null){
        drawWrongAnswers(g2, rect, wrongInput);
      }
    }
  }

  private void drawWrongAnswers(Graphics2D g2, Rectangle2D rect, String wrongInput){
        g2.setFont(new Font("Arial", Font.PLAIN, 24));
        g2.setColor(Color.RED);
        g2.drawString("X " + wrongInput, 80, 150);
        g2.setColor(Color.WHITE);
      
    
  }
  
  
  private void countDown(){
    if (this.startCountdown){
      this.countdown -= 1;
    } 
  }

  private void expandingWord(){
    if (start < end){
      start *= 1.001;
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
      timer.setDelay(10);
    }

  }

  
}


