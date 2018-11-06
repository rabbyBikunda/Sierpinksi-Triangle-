/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rabby_Bikunda_lab3;

import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *  
 * @author bikunda
 */
public class DrawSierpinskiTriangle extends JComponent   //DrawSierpinskiTriangle inherits methods  from JComponent class
{
     public static void main(String[] args)
    {
        JFrame window = new JFrame();//create new Jframe called window
        window.setSize(1000, 1000); // sets height and width of window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits the program when the window is  closed
        window.setVisible(true); // displays the window
        
        DrawSierpinskiTriangle d1 = new DrawSierpinskiTriangle(); // creates drawing
        window.add(d1);                           
    }

    @Override
    public void paint(Graphics g) //method from JComponent class
    {
        Graphics2D g2 = (Graphics2D) g;

        //x and y coordinates for triangle
        int x1 = 250;
        int y1 = 100;
        int x2 = 500;
        int y2 = 500;
        int x3 = 50;
        int y3 = 500;

        //variables that store random x and y coordinates of point 
        int randomX;
        int randomY;

        //midpoint of x and y
        double midpointX;
        double midpointY;

        //stores x and y coordinateds in Point method
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        Point p3 = new Point(x3, y3);

        //draws triangle by connecting x and y coordinates
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x3, y3, x1, y1);

        Random rand = new Random();

        //generates random number that will be stored in variable
        randomX = rand.nextInt();
        randomY = rand.nextInt();

        //creates a new point and uses random x and y coordinates
        Point2D.Double randomPoint = new Point.Double(randomX, randomY);

        for (int i = 0; i < 100000; i++) 
        {

            //gets random corner from triangle
            int corner = 1 + rand.nextInt(3);

            if (corner == 1)
            {
                midpointX = (p1.x + randomPoint.x) / 2; //midpoint of x value of corner of triangle and random point 
                midpointY = (p1.y + randomPoint.y) / 2; //midpoint of y value of corner of triangle and random point 
                g2.draw(new Line2D.Double(midpointX, midpointY, midpointX, midpointY)); //plots the point
                Point2D.Double newPoint = new Point.Double(midpointX, midpointY); // creates new point with the midpoint becoming the new coordinates
                randomPoint = newPoint; // the new point is declared as the random point 

            } 
            
            else if (corner == 2)
            {
                midpointX = (p2.x + randomPoint.x) / 2;
                midpointY = (p2.y + randomPoint.y) / 2;
                g2.draw(new Line2D.Double(midpointX, midpointY, midpointX, midpointY));
                Point2D.Double newPoint = new Point.Double(midpointX, midpointY);
                randomPoint = newPoint;
            } 
            
            else if (corner == 3)
            {
                midpointX = (p3.x + randomPoint.x) / 2;
                midpointY = (p3.y + randomPoint.y) / 2;
                g2.draw(new Line2D.Double(midpointX, midpointY, midpointX, midpointY));
                Point2D.Double newPoint = new Point.Double(midpointX, midpointY);
                randomPoint = newPoint;
            }

        }

    }
}
