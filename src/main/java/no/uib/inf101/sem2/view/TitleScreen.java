package no.uib.inf101.sem2.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.Timer;
import no.uib.inf101.sem2.model.GameState;


public class TitleScreen implements ViewableQuizModel{
  private BufferedImage ivar;
  private BufferedImage sunglasses;
  private Rectangle2D button;
  private GameState gamestate = GameState.TITLE_SCREEN;
  private Timer timer;
  private boolean continueIsPressed = false;
  private boolean startIsPressed = false;

  int PANEL_WIDTH;
  int xVelocity = 5;
  int yVelocity = 1;
  int x = 0;
  int y = 0;
  int onEye = 135;

  public TitleScreen(int pw) {
    PANEL_WIDTH = pw;
    ivar = Inf101Graphics.loadImageFromResources("/aasen.png");
    sunglasses = Inf101Graphics.loadImageFromResources("/sunglasses.png");

    timer = new Timer(4, this);
    timer.start();
  }
  @Override
    public void actionPerformed(ActionEvent e) {
    if (continueIsPressed()){
        moveSunglasses();
    }
  }

  @Override
    public GameState getGameState(){
      return this.gamestate;
    }

  public void draw(Graphics2D g2, Rectangle2D rect, Color hoverColor) {
    Color color = hoverColor;
    double scale = (rect.getHeight() / ivar.getHeight());
    Inf101Graphics.drawTitleString(g2, "NynorskKviss!", rect);
    Inf101Graphics.drawImage(g2, ivar, rect.getX(), rect.getY(), scale);

    if (continueIsPressed()) {
        drawContinued(g2, rect, color);

    } else {
      button = new Rectangle2D.Double(rect.getX() + rect.getWidth() / 2 + 20, rect.getY() + rect.getHeight() / 2, 500, 100);
      g2.setColor(color);
      g2.draw(button);
      Inf101Graphics.drawCenteredString(g2, "Klikk for å fortsetja", button);
    }

    if (startIsPressed) {
      button = new Rectangle2D.Double();
      gamestate = GameState.ACTIVE_GAME;
    }
  }

  private void drawContinued(Graphics2D g2, Rectangle2D rect, Color color){
    button = new Rectangle2D.Double(rect.getX() + rect.getWidth() / 2 + 200, rect.getY() + rect.getHeight() / 2, 150, 100);
    g2.setColor(color);
    g2.draw(button);
    Inf101Graphics.drawCenteredString(g2, "START", button);
    
    // Initiate position of sunglasses image
    int y = (int) (g2.getClipBounds().getHeight() / 2.8 - sunglasses.getHeight() / 2);
    g2.drawImage(sunglasses, this.x, y, null);
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


public void moveSunglasses(){
    x = x+xVelocity;
      int speedUp = xVelocity * -2;

      if (x > PANEL_WIDTH-sunglasses.getWidth() || x<0){
        xVelocity = speedUp;
      }

      if (xVelocity <0 && x == onEye ){
        xVelocity = 0;
        timer.stop();
      }
  }


}