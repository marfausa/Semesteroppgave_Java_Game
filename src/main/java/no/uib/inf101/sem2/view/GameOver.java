package no.uib.inf101.sem2.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import no.uib.inf101.sem2.model.QuizModel;


public class GameOver {
  private Rectangle2D button;
  private boolean continueIsPressed = false;

  int PANEL_WIDTH;
  int x;
  int y;
  int countdown = 1;
  

  public GameOver(int pw) {
    PANEL_WIDTH = pw;
  
  }

  public void draw(Graphics2D g2, Rectangle2D rect, Color hoverColor, QuizModel model, float end) {
    
      Color color = hoverColor;
      g2.setColor(Color.BLACK);
      g2.draw(rect);
      g2.fill(rect);

      Color dimGray = new Color(128, 128, 128, 64);
      g2.setColor(dimGray);
      Inf101Graphics.drawCenteredString(g2, model.getCurrentQuestion(), rect, end);

      g2.setColor(Color.RED);
      Inf101Graphics.drawCenteredString(g2, "GAME OVER", rect, 180f);

      g2.setColor(Color.WHITE);
      g2.setFont(new Font("Helvetica", Font.PLAIN, 50));
      g2.drawString("Korrekt omsetjing: ", 100, 140);

      g2.setColor(Color.PINK);
      g2.setFont(new Font("Helvetica", Font.ITALIC, 40));
      g2.drawString(model.getCurrentAnswer() , 150, 220);
      
      
      button = new Rectangle2D.Double(rect.getCenterX()-150, rect.getY() * 11.5, 300, 100);
      g2.setColor(color);
      g2.draw(button);
      
      Inf101Graphics.drawCenteredString(g2, "Freista på nytt?", button);
     

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