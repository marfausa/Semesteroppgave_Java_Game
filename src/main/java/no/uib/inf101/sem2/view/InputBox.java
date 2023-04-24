package no.uib.inf101.sem2.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


public class InputBox  {
    Rectangle2D inputBox;
    Graphics2D g2;
    String input;
    int width;

    public InputBox(Graphics2D g2, Rectangle2D rect, String input){
        this.inputBox = new Rectangle2D.Double(rect.getX()  , rect.getY() * 12 , rect.getWidth(), 50);
        width = (int) rect.getWidth();
        this.g2 = g2;
        this.input = input;  
    }

     /**
     * Tegner område som viser hvor brukerinput vises på skjermen.
     */
    public void drawInputBox(){
        Color color = new Color(128, 128, 128, 64);
        g2.setColor(color);
        g2.draw(inputBox);
        g2.fill(inputBox);
        
        g2.setColor(Color.WHITE);
        Inf101Graphics.drawCenteredString(g2, input, inputBox);
      }
    
}
