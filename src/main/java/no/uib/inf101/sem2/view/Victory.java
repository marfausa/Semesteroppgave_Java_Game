package no.uib.inf101.sem2.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import no.uib.inf101.sem2.model.GameState;


public class Victory implements ViewableQuizModel{
  private Rectangle2D button;
  private BufferedImage background;

  private GameState gamestate = GameState.VICTORY;
 
  private boolean continueIsPressed = false;

  int PANEL_WIDTH;
  int x;
  int y;
  int countdown = 3;
  

  public Victory(int pw) {
    PANEL_WIDTH = pw;
    this.background = Inf101Graphics.loadImageFromResources("bakgrunn3.png");

  }

  @Override
    public void actionPerformed(ActionEvent e) {
      } 
  

  @Override
    public GameState getGameState(){
      return this.gamestate;
    }


  public void draw(Graphics2D g2, Rectangle2D rect, Color hoverColor) {
      double scale = (rect.getHeight() / this.background.getHeight());
      Inf101Graphics.drawImage(g2, this.background, rect.getX(), rect.getY(), scale);

      g2.setColor(Color.ORANGE);
      g2.setFont(new Font("Big Caslon", Font.PLAIN, 80));
      g2.drawString("GRATULERER! ", 100, 300);
      g2.drawString("DU VANN!!", 180, 400);

      
      Color color = hoverColor;
      button = new Rectangle2D.Double(rect.getCenterX()/2 - 40, 500, 300, 80);
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