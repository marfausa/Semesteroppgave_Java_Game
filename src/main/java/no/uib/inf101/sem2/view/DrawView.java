package no.uib.inf101.sem2.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import no.uib.inf101.sem2.model.GameState;


public class DrawView extends JPanel {

  private ViewableQuizModel model;
  final int PANEL_WIDTH = 1200;
  final int PANEL_HEIGHT = 800;
  
  Rectangle2D button;
  GameState gamestate = GameState.TITLE_SCREEN;
  TitleScreen titleScreen;
  QuizView quizScreen;

  private boolean mouseIsInTheRectangle = false;
  private boolean mouseIsPressed = false;


  float start = 60f;
  float end = 180f;
  
  public DrawView(ViewableQuizModel model) {
    this.model = model;
    this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    this.setupMousePositionUpdater();
    this.setupMousePressedUpdater();
    
    titleScreen = new TitleScreen(PANEL_WIDTH);
    quizScreen = new QuizView(PANEL_WIDTH, PANEL_HEIGHT);
  
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
      drawQuiz(g2);
      this.gamestate = quizScreen.getGameState();
      repaint();
    }

  }


  private void drawFrame(Graphics2D g2){
      Rectangle2D rect = this.getRectangle();
      g2.setColor(Color.BLACK);
      g2.draw(rect);
    }

  private void drawTitleScreen(Graphics2D g2){
      Color color = mouseIsInTheRectangle ? (mouseIsPressed ? Color.RED : Color.BLUE) : Color.BLACK;
      button = titleScreen.getButton();
      titleScreen.draw(g2, this.getRectangle(), color);
    
  }

  private void drawQuiz(Graphics2D g2){
    Rectangle2D rect = this.getRectangle();
    quizScreen.draw(g2, rect);
  

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
    if (gamestate == GameState.TITLE_SCREEN){
      if (mouseIsInTheRectangle) {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
      } else {
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      }
    }
  }

  private void setupMousePressedUpdater() {
    if (gamestate == GameState.TITLE_SCREEN){
      this.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
          mouseIsPressed = true;
          repaint();
        }
    
        @Override
        public void mouseReleased(MouseEvent e) {
          // Record that button is pressed
          
          if (mouseIsInTheRectangle && titleScreen.continueIsPressed()){
            titleScreen.pressStart(true);
          }
          else if (mouseIsInTheRectangle && titleScreen.startIsPressed() == false ){
            titleScreen.pressContinue(true);
          }
          mouseIsPressed = false;

          updateCursor();
          repaint();
        }
    });
  }

  }




  

  }

