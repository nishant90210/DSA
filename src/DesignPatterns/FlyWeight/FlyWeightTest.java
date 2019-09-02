package DesignPatterns.FlyWeight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by NISHANT on 4/24/18.
 */
public class FlyWeightTest extends JFrame{

    JButton startDrawing;

    int windowWidth = 1750;
    int windowHeight = 150;

    Color[] shapeColor = {Color.orange, Color.red, Color.yellow, Color.blue, Color.pink, Color.cyan, Color.magenta, Color.black, Color.gray};

    public static void main(String[] args) {

        new FlyWeightTest();
    }

    public FlyWeightTest(){

        this.setSize(windowWidth, windowHeight);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("FlyWeight UniqueString");

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        final JPanel drawingPanel = new JPanel();
        startDrawing = new JButton("Draw Stuff");

        contentPane.add(drawingPanel, BorderLayout.CENTER);
        contentPane.add(startDrawing, BorderLayout.SOUTH);

        startDrawing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Graphics g = drawingPanel.getGraphics();
                long startTime = System.currentTimeMillis();
                for (int i = 0; i < 100000; ++i) {
                    g.setColor(getRandColor());
                    g.fillRect(getRandX(), getRandY(), getRandX(), getRandY());
                }
                long endTime = System.currentTimeMillis();
                System.out.println("Time Taken " + (endTime-startTime));
            }
        });
    }

    private int getRandY() {

        return ((int) Math.random()*windowHeight);
    }

    private int getRandX() {

        return ((int) Math.random()*windowWidth);
    }

    private Color getRandColor() {

        Random random = new Random();
        int randInt = random.nextInt(9);
        return shapeColor[randInt];
    }

}
