package no.uib.inf101.sem2.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.Timer;

import no.uib.inf101.sem2.model.GameState;
import no.uib.inf101.sem2.model.QuizModel;
import no.uib.inf101.sem2.model.QuizWord;


public class QuizView implements ViewableQuizModel, ActionListener {

  private QuizModel model;
  private InputBox inputBox;
  final int PANEL_WIDTH;
  final int PANEL_HEIGHT;
 
  GameState gamestate;
  QuizWord currentWord;
  String currentQuestion;
  String currentAnswer;
  Timer timer;
  BufferedImage background;

  boolean startCountdown = false;
  boolean startedQuiz = false;
  boolean quizClear = false;
  
  int numQuestions = 25;
  int countdown;
  int stageInterval = 0;

  int level = 0;

  boolean wrongAnswer;
  boolean correctAnswer;
  

  float start = 60f;
  float end = 240f;
  
  public QuizView(int pw, int ph, QuizModel model, int tick) {
    PANEL_WIDTH = pw;
    PANEL_HEIGHT = ph;

    this.background = Inf101Graphics.loadImageFromResources("/bakgrunn2.png");
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

  @Override
  public Rectangle2D getButton() {
    throw new UnsupportedOperationException("Unimplemented method 'getButton'");
  }

  /**
     * Metode for å tegne aktivt spill, og kaller på hjelpemetodene for å gjøre dette.
     * @param g2 Graphics2d
     * @param rect Rectangle2D
     * 
     */
  public void draw(Graphics2D g2, Rectangle2D rect) {
    double scale = (rect.getHeight() / this.background.getHeight());
    Inf101Graphics.drawImage(g2, this.background, rect.getX(), rect.getY(), scale);
    inputBox = new InputBox(g2, rect, this.model.getInputAnswer());
 
    
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

  /**
     * @return true/false. Returnerer true dersom det er 0 ord igjen av spillet.
     */
  public boolean isQuizCleared(){
    return this.quizClear;
  }

   /**
     * Starter timer.
     */
  public void startTimer(){
    this.startCountdown = true;
    timer.start();
  }

   /**
     * Hjelpemetode for å tegne spillet når det kjøres.
     * Den sjekker jevnlig etter riktig input fra brukeren ved å hente dette fra model.
     * For hvert ord som kommer tegnes dette til skjermen med startposisjon og størrelse.
     * Deretter økes fontstørrelsen så lenge den er mindre enn maksstørrelse.
     * Hvis ingen korrekt input før nådd maksstørrelse så er det game over.
     * Dersom korrekt input er registrert hentes neste ord fra modellen.
     * @param g2
     * @param rect
     */
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

  /**
     * Hjelpemetode for å tegne spillinfo.
     * Så lenge "KVISS START" er blitt vist på skjermen tegnes også nåværende nivå og antall ord igjen av spillet.
     * Tegner også de tre siste sekundene før game over ved å kalle på drawTimeLeft()
     * Kaller på drawWrongAnswers() for hver gang det er feil input fra brukeren.
     * @param g2
     * @param rect
     */
  private void drawAmountofQuestions(Graphics2D g2, Rectangle2D rect){
    if (startedQuiz){
      g2.setColor(model.getCurrentColor());
      g2.setFont(new Font("Arial", Font.PLAIN, 24));
      g2.drawString("NIVÅ: " + model.getCurrentLevel(), 1000, 100);
      
      g2.setColor(Color.WHITE);
      g2.drawString("Resterande gloser: " + numQuestions, 80, 100);

      drawTimeLeft(g2, rect);
      
      String wrongInput = model.getWrongUserAnswer();
      if (wrongInput != null && !wrongInput.equalsIgnoreCase(model.getCurrentAnswer())){
        wrongAnswer = true;
      }
  
      if ( wrongAnswer && wrongInput != null){
        drawWrongAnswers(g2, rect, wrongInput);
      }
    }
  }

  /**
     * Hjelpemetode for å vise feil svar brukeren selv har skrevet med rød skrift: "X 'feil svar'"
     * @param g2
     * @param rect
     * @param wrongInput String med feil brukerinput
     */
  private void drawWrongAnswers(Graphics2D g2, Rectangle2D rect, String wrongInput){
        g2.setFont(new Font("Arial", Font.PLAIN, 24));
        g2.setColor(Color.RED);
        g2.drawString("X " + wrongInput, 80, 150);
        g2.setColor(Color.WHITE);
      
  }

  /**
     * Hjelpemetode for å tegne de tre siste sekundene før game over.
     * Den sjekker jevnlig etter riktig input fra brukeren ved å hente dette fra model.
     * Ved gitte intervaller i fontstørrelse vil en nedtelling tegnes på skjermen før game over. 
     * @param g2
     * @param rect
     */
  private void drawTimeLeft(Graphics2D g2, Rectangle2D rect){
    g2.setColor(Color.RED.darker());
    if (this.start > 190 && this.start < 206){
      Inf101Graphics.drawCenteredString(g2, "3", rect,  160, 120);
    }
    if (this.start > 206 && this.start < 222){
      Inf101Graphics.drawCenteredString(g2, "2", rect,  160, 120);
    }
    if (this.start > 222 && this.start < 239){
      Inf101Graphics.drawCenteredString(g2, "1", rect,  160, 120);
    }
  }


  /**
     * Hjelpemetode for å tegne nedtellingen før spillet begynner.
     * Ved hjelp av actionlistener går nedtellingen nedover, og 3,2,1 vises på skjermen når countdown har disse verdiene.
     * @param g2
     * @param rect
     */
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

   /**
     * Hjelpemetode for å lage en countdown i begynnelsen av spillet.
     */
  private void countDown(){
    if (this.startCountdown){
      this.countdown -= 1;
    } 
  }

    /**
     * Hjelpemetode for å øke størrelsen på ordene i spillet.
     * 
     */
  private void expandingWord(){
    if (start < end){
      start *= 1.001;
    }
  }

  

  
}


