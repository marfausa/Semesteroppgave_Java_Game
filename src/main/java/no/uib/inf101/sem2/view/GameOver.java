package no.uib.inf101.sem2.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.Timer;
import no.uib.inf101.sem2.model.GameState;


public class GameOver implements ViewableQuizModel{
  private Rectangle2D button;
  private GameState gamestate = GameState.GAME_OVER;
  private Timer timer;
  private boolean continueIsPressed = false;

  int PANEL_WIDTH;
  int x;
  int y;
  int countdown = 1;
  

  public GameOver(int pw) {
    PANEL_WIDTH = pw;
  
    timer = new Timer(1000, this);
    timer.start();
  }

  @Override
    public void actionPerformed(ActionEvent e) {
      if (this.countdown > 0){
        this.countdown -= 1;
      } 
  
  }

  @Override
    public GameState getGameState(){
      return this.gamestate;
    }

  public void draw(Graphics2D g2, Rectangle2D rect, Color hoverColor) {
    if (countdown == 0){
      Color color = hoverColor;
      
      button = new Rectangle2D.Double(rect.getCenterX()-150, rect.getY() * 11.5, 300, 100);
      g2.setColor(color);
      g2.draw(button);
      
      Inf101Graphics.drawCenteredString(g2, "Freista på nytt?", button);
     
      

      if (continueIsPressed()) {
        button = new Rectangle2D.Double();
        
      }
    }
  }


  public Rectangle2D getButton(){
    return this.button;
  }
  
  public boolean continueIsPressed(){
    return this.continueIsPressed;
  }
  
  public void pressContinue(boolean bool){
    this.continueIsPressed = bool;
  }


  public void startTimer(){
    timer.start();
  }

}