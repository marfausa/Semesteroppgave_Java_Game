package no.uib.inf101.sem2.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import no.uib.inf101.sem2.model.GameState;
import no.uib.inf101.sem2.model.QuizModel;


public class GameOver implements ViewableQuizModel{
  Rectangle2D button;
  GameState gameState = GameState.GAME_OVER;
  public boolean continueIsPressed;

  public GameOver() {
    continueIsPressed = false;
  
  }

  @Override
  public Rectangle2D getButton(){
    return this.button;
  }
  @Override
  public GameState getGameState() {
    return this.gameState;
  }


  /**
     * Tar inn Graphics2D objekt, Rectangle2D rektangel, Color farge når musepeker er på knapp, Quizmodel-model og siste størrelsen til font.
     * @param g2
     * @param rect
     * @param hovercolor
     * @param model
     * @param end 
     */
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
  
  public boolean continueIsPressed(){
    return this.continueIsPressed;
  }
  public void pressContinue(boolean bool){
    this.continueIsPressed = bool;
  }

  
}