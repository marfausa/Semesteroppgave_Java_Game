package no.uib.inf101.sem2.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import no.uib.inf101.sem2.model.GameState;


public class Victory implements ViewableQuizModel{
  private Rectangle2D button;

  private GameState gamestate = GameState.VICTORY;
 
  private boolean continueIsPressed = false;

  int PANEL_WIDTH;
  int x;
  int y;
  int countdown = 3;
  

  public Victory(int pw) {
    PANEL_WIDTH = pw;

  }

  @Override
    public void actionPerformed(ActionEvent e) {
      } 
  

  @Override
    public GameState getGameState(){
      return this.gamestate;
    }


  public void draw(Graphics2D g2, Rectangle2D rect, Rectangle2D button, Color hoverColor) {
      g2.setColor(Color.BLACK);
      g2.draw(rect);
      g2.fill(rect);

      g2.setColor(Color.CYAN);
      Inf101Graphics.drawCenteredString(g2, "GRATULERER DU VANT", rect, 60f);

      
      Color color = hoverColor;
      button = new Rectangle2D.Double(rect.getCenterX()-150, rect.getY() * 11.5, 300, 100);
      g2.setColor(color);
      g2.draw(button);
      
      Inf101Graphics.drawCenteredString(g2, "Spela ein gong til?", button);
    
      if (continueIsPressed()) {
        button = new Rectangle2D.Double();   
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



}