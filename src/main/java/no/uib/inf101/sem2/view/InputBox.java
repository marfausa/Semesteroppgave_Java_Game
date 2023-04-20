package no.uib.inf101.sem2.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.Timer;

public class InputBox implements ActionListener {
    Rectangle2D inputBox;
    Graphics2D g2;
    String input;
    Timer timer;
    int width;

    int x = 1;
    int y = 0;
    int xVelocity = 5;


    public InputBox(Graphics2D g2, Rectangle2D rect, String input){
        this.inputBox = new Rectangle2D.Double(rect.getX()  , rect.getY() * 12 , rect.getWidth(), 50);
        width = (int) rect.getWidth();
        this.g2 = g2;
        this.input = input;
       

    }

    public void drawInputBox(){
        Color color = new Color(128, 128, 128, 64);
    
        g2.setColor(color);
        g2.draw(inputBox);
        g2.fill(inputBox);
        
        g2.setColor(color.WHITE);
        Inf101Graphics.drawCenteredString(g2, input, inputBox);

    
      }
    
    public void glideInputBox(){
        x = x+xVelocity;
        if (x == width){

        }
        //HELP
        }
    


    @Override
    public void actionPerformed(ActionEvent e) {
        glideInputBox();
    }
    
}
