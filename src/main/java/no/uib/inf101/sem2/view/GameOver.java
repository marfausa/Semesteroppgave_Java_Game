package no.uib.inf101.sem2.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.Timer;
import no.uib.inf101.sem2.model.GameState;


public class GameOver implements ViewableQuizModel{
  private Rectangle2D button;
  private GameState gamestate = GameState.GAME_OVER;
  private Timer timer;
  private boolean continueIsPressed = false;
  private boolean startIsPressed = false;

  int PANEL_WIDTH;
  int x;
  int y;
  int countdown = 3;
  

  public GameOver(int pw) {
    PANEL_WIDTH = pw;
  
    timer = new Timer(4, this);
    timer.start();
  }

  @Override
    public void actionPerformed(ActionEvent e) {
      if (countdown > 0){
        countdown -= 1;
      } 
  
  }

  @Override
    public GameState getGameState(){
      return this.gamestate;
    }

  public void draw(Graphics2D g2, Rectangle2D rect, Color hoverColor) {
    if (countdown == 0){
      Color fillButton = Color.CYAN;
      Color color = hoverColor;
      button = new Rectangle2D.Double(rect.getCenterX()-150, rect.getY() * 11.5, 300, 100);
      g2.setColor(fillButton);
      g2.draw(button);
      
      double midX = rect.getBounds2D().getCenterX();
      
      Inf101Graphics.drawCenteredString(g2, "Freista på nytt?", button);
    

      if (startIsPressed) {
        button = new Rectangle2D.Double();
        gamestate = GameState.ACTIVE_GAME;
      }
    }
  }


  public Rectangle2D getButton(){
    return this.button;
  }
  
  public boolean continueIsPressed(){
    return this.continueIsPressed;
  }
  
  public boolean startIsPressed(){
    return this.startIsPressed;
  }
  public void pressStart(boolean bool){
    this.startIsPressed = bool;
  }
  public void pressContinue(boolean bool){
    this.continueIsPressed = bool;
  }


  public void startTimer(){
    timer.start();
  }

}