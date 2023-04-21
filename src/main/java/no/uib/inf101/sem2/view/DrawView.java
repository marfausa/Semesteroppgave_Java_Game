package no.uib.inf101.sem2.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import no.uib.inf101.sem2.model.GameState;
import no.uib.inf101.sem2.model.QuizModel;


public class DrawView extends JPanel {

  private QuizModel model;
  final int PANEL_WIDTH = 1200;
  final int PANEL_HEIGHT = 800;
  
  Rectangle2D button;
  GameState gamestate = GameState.TITLE_SCREEN;
  TitleScreen titleScreen;
  QuizView quizScreen;
  GameOver gameOverScreen;

  private boolean mouseIsInTheRectangle = false;
  private boolean mouseIsPressed = false;


  float start = 60f;
  float end = 240f;
  
  public DrawView(QuizModel model) {
    this.model = model;
    this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    this.setupMousePositionUpdater();
    this.setupMousePressedUpdater();
    
    titleScreen = new TitleScreen(PANEL_WIDTH);
    quizScreen = new QuizView(PANEL_WIDTH, PANEL_HEIGHT, this.model, 4);
    gameOverScreen = new GameOver(PANEL_WIDTH);
  
    }
      

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    drawFrame(g2);

    

    if (gamestate == GameState.TITLE_SCREEN){
      drawTitleScreen(g2);
      this.gamestate = titleScreen.getGameState();
      repaint();
    }

    else if (gamestate == GameState.ACTIVE_GAME){
      quizScreen.startTimer();
      drawQuiz(g2);
      this.gamestate = quizScreen.getGameState();
      repaint();
    }
    
    else if (gamestate == GameState.GAME_OVER){
      drawGameOver(g2);
      repaint();
    }

    if (gameOverScreen.continueIsPressed()){
      this.gamestate = GameState.ACTIVE_GAME;
      quizScreen = new QuizView(PANEL_WIDTH, PANEL_HEIGHT, this.model, 4);
      drawQuiz(g2);
      repaint();
    }

  }


  private void drawFrame(Graphics2D g2){
      Rectangle2D rect = this.getRectangle();
      g2.setColor(Color.BLACK);
      g2.draw(rect);
      g2.clip(rect);
      
    }
  
  private void drawTitleScreen(Graphics2D g2){
      button = titleScreen.getButton();
      Color color = mouseIsInTheRectangle ? (mouseIsPressed ? Color.RED : Color.BLUE) : Color.BLACK;
      button = titleScreen.getButton();
      titleScreen.draw(g2, this.getRectangle(), color);  
  }

  private void drawQuiz(Graphics2D g2){
    Rectangle2D rect = this.getRectangle();
    quizScreen.draw(g2, rect);
  }

  private void drawGameOver(Graphics2D g2){
      Rectangle2D rect = this.getRectangle();
      button = gameOverScreen.getButton();

      g2.setColor(Color.BLACK);
      g2.draw(rect);
      g2.fill(rect);

      Color dimGray = new Color(128, 128, 128, 64);
      g2.setColor(dimGray);
      String lastWord = quizScreen.getLastWord();
      Inf101Graphics.drawCenteredString(g2, lastWord, rect, this.end);

      g2.setColor(Color.RED);
      Inf101Graphics.drawCenteredString(g2, "GAME OVER", rect, 180f);

      Color color = mouseIsInTheRectangle ? (mouseIsPressed ? Color.RED : Color.CYAN) : Color.WHITE;

      gameOverScreen.draw(g2, rect, color);
      
      
    }
  
  
  private Rectangle2D getRectangle() {
    return new Rectangle2D.Double(50, 50, getWidth() - 100, getHeight() - 100);
  }

  private void setupMousePositionUpdater() {
    // Keep the mousePosition variable up to date
    this.addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseMoved(MouseEvent e) {
        mouseIsInTheRectangle = button.contains(e.getPoint());
        updateCursor();
        repaint();
      }
    });
  }


  private void updateCursor() {
      if (mouseIsInTheRectangle) {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
      } else {
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      }
    }
  

  private void setupMousePressedUpdater() {
      this.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
          mouseIsPressed = true;
          repaint();
        }

    
        @Override
        public void mouseReleased(MouseEvent e) {
          // Record that button is pressed
          if (gamestate == GameState.TITLE_SCREEN){
            if (mouseIsInTheRectangle && titleScreen.continueIsPressed()){
              titleScreen.pressStart(true);
            }
            else if (mouseIsInTheRectangle && titleScreen.startIsPressed() == false ){
              titleScreen.pressContinue(true);
            }
            mouseIsPressed = false;

            updateCursor();
            repaint();
          } else if (gamestate == GameState.GAME_OVER){
              if (mouseIsInTheRectangle){
                gameOverScreen.pressContinue(true);
              }
              mouseIsPressed = false;

              updateCursor();
              repaint();
          }
        }
    });
  

  }




  

  }

