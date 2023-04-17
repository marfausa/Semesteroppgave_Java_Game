package no.uib.inf101.sem2.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

import no.uib.inf101.sem2.model.GameState;


/**
 * A sample view to get you inspired for your own project.
 */
public class TitleScreen extends JPanel implements ActionListener {

  private ViewableQuizModel model;
  final int PANEL_WIDTH = 1200;
  final int PANEL_HEIGHT = 800;
  
  Rectangle2D button;
  GameState gamestate = GameState.TITLE_SCREEN;

  boolean continueIsPressed = false;
  boolean startIsPressed = false;
  boolean readyToQuiz = false;
  
  private boolean mouseIsInTheRectangle = false;
  private boolean mouseIsPressed = false;

  private BufferedImage ivar;
  private BufferedImage sunglasses;
  private BufferedImage background;

  private Timer timer;
  int xVelocity = 5;
  int yVelocity = 1;
  int x = 0;
  int y = 0;
  int onEye = 135;
  
  public TitleScreen(ViewableQuizModel model) {
    this.model = model;
    this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    this.setupMousePositionUpdater();
    this.setupMousePressedUpdater();
    
    ivar = Inf101Graphics.loadImageFromResources("/aasen.png");
    sunglasses = Inf101Graphics.loadImageFromResources("/sunglasses.png");
    background = Inf101Graphics.loadImageFromResources("/background.png");

    timer = new Timer(4, this);
    timer.start();

      
    }


  @Override
  public void actionPerformed(ActionEvent e) {
    if (continueIsPressed){
      x = x+xVelocity;
      int speedUp = xVelocity * -2;

      if (x > PANEL_WIDTH-sunglasses.getWidth() || x<0){
        xVelocity = speedUp;
      }

      if (xVelocity <0 && x == onEye ){
        xVelocity = 0;
      }
    }
    repaint();
    
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    drawTitleScreen(g2);

    Graphics2D g3 = (Graphics2D) g;
    
    if (gamestate == GameState.ACTIVE_GAME){
      drawQuiz(g3);
    }

  }


 
  private void drawTitleScreen(Graphics2D g2){

     // Draw a centered rectangle with title text
     Rectangle2D rect = this.getRectangle();
     Color color = mouseIsInTheRectangle ? (mouseIsPressed ? Color.RED : Color.BLUE) : Color.BLACK;
     double scale = (rect.getHeight()/ivar.getHeight());
 
     g2.setColor(Color.BLACK);
     g2.draw(rect);
     
     Inf101Graphics.drawTitleString(g2, "NynorskKviss!", rect); 
     
     // Draw Ivar Aasen in the left side of the rectangle
     Inf101Graphics.drawImage(g2, ivar, rect.getX() , rect.getY() , scale);
     
     
     // Draw start button
     
     if (continueIsPressed){
       button = new Rectangle2D.Double(rect.getX() + rect.getWidth() / 2 + 200, rect.getY() + rect.getHeight() / 2 , 150, 100);
       g2.setColor(color);
       g2.draw(button);
       Inf101Graphics.drawCenteredString(g2, "START", button);
       // Initiate position of sunglasses image
       y = (int) (getHeight() / 2.8 - sunglasses.getHeight() / 2);
       g2.drawImage(sunglasses, x, y, null);


     } else{
       button = new Rectangle2D.Double(rect.getX() + rect.getWidth() / 2 + 20, rect.getY() + rect.getHeight() / 2 , 500, 100);
       g2.setColor(color);
       g2.draw(button);
       Inf101Graphics.drawCenteredString(g2, "Klikk for å fortsetja", button);

     }

     if (startIsPressed){
      gamestate = GameState.ACTIVE_GAME;
     }
     
  }


  private void drawQuiz(Graphics2D g3){
    // Draw a centered rectangle with title text
    Rectangle2D rect = this.getRectangle();

    g3.setColor(Color.BLACK);
    g3.draw(rect);
    g3.fill(rect);

  }
  
  private Rectangle2D getRectangle() {
    return new Rectangle2D.Double(50, 50, getWidth() - 100, getHeight() - 100);
  }
  private Rectangle2D getButton(){
    return button;
  }

  private void setupMousePositionUpdater() {
    // Keep the mousePosition variable up to date
    this.addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseMoved(MouseEvent e) {
        mouseIsInTheRectangle = getButton().contains(e.getPoint());
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
        
        if (mouseIsInTheRectangle && continueIsPressed){
          startIsPressed = true;
        }
        else if (mouseIsInTheRectangle && startIsPressed == false ){
          continueIsPressed = true;
        }
        mouseIsPressed = false;

        updateCursor();
        repaint();
      }
    });
  }





  
}
