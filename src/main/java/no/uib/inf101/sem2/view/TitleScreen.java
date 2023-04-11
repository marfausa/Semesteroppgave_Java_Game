package no.uib.inf101.sem2.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * A sample view to get you inspired for your own project.
 */
public class TitleScreen extends JPanel implements ActionListener {
  
  final int PANEL_WIDTH = 1200;
  final int PANEL_HEIGHT = 800;
  private boolean mouseIsInTheRectangle = false;
  private boolean mouseIsPressed = false;
  private BufferedImage ivar;
  private BufferedImage sunglasses;
  private Timer timer;
  int xVelocity = 5;
  int yVelocity = 1;
  int x = 0;
  int y = 0;
  
  public TitleScreen() {
    this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    this.setupMousePositionUpdater();
    this.setupMousePressedUpdater();
    ivar = Inf101Graphics.loadImageFromResources("/aasen.png");
    sunglasses = Inf101Graphics.loadImageFromResources("/sunglasses.png");

    timer = new Timer(4, this);
    timer.start();

  }


  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    
    // Draw a centered rectangle with text
    Rectangle2D rect = this.getRectangle();
    g2.setColor(Color.BLACK);
    g2.draw(rect);
    Inf101Graphics.drawTitleString(g2, "NynorskKviss!", rect); 
    
    // Draw the INF101 ivar in the left side of the rectangle
    
    double scale = (rect.getHeight()/ivar.getHeight());
    Inf101Graphics.drawImage(g2, ivar, rect.getX() , rect.getY() , scale);

     // Calculate the position of the sunglasses image
     y = (int) (getHeight() / 2.7 - sunglasses.getHeight() / 2);
     g2.drawImage(sunglasses, x, y, null);

     // Draw start button
    Rectangle2D startButton = new Rectangle2D.Double(rect.getX() + rect.getWidth() / 2 + 200, rect.getY() + rect.getHeight() / 2 , 200, 100);
    Color color = mouseIsInTheRectangle ? (mouseIsPressed ? Color.RED : Color.BLUE) : Color.BLACK;
    g2.setColor(color);
    g2.draw(startButton);
    Inf101Graphics.drawCenteredString(g2, "START", startButton);


  }

  @Override
  public void actionPerformed(ActionEvent e) {
    //double glideWidth = sunglasses.getWidth();
    //x = (int) (PANEL_WIDTH / 5.5 - glideWidth / 2);
    x = x+xVelocity;
    int speedUp = xVelocity * -2;

    if (x > PANEL_WIDTH-sunglasses.getWidth()+30 || x<0){
      xVelocity = speedUp;
    }
    
    int onEye = 135;
  
    if (xVelocity <0 && x == onEye ){
      xVelocity = 0;
    }
    
    repaint();
    
  }

  private Rectangle2D getRectangle() {
    return new Rectangle2D.Double(50, 50, getWidth() - 100, getHeight() - 100);
  }

  private void setupMousePositionUpdater() {
    // Keep the mousePosition variable up to date
    this.addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseMoved(MouseEvent e) {
        mouseIsInTheRectangle = getRectangle().contains(e.getPoint());
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
        mouseIsPressed = false;
        repaint();
      }
    });
  }




  
}
