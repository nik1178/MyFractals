import java.awt.Color;
import java.awt.image.BufferStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MyPanel extends JPanel implements ActionListener{
    
    Graphics2D g;
    //MyFrame frame = new MyFrame(this);
    static final int PANEL_WIDTH = 800;
    static final int PANEL_HEIGHT = 800;
    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        Timer timer = new Timer(0, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        repaint();
    }

    public static int moveX = 0;
    public static int moveY = -800;

    @Override
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
        g.setColor(Color.white);
        this.g = (Graphics2D) g;
        int segmentLength=this.getHeight();
        fractal(PANEL_WIDTH/2 + moveX, PANEL_HEIGHT*2+ moveY, segmentLength, 0);
    }

    static double angle1 = 60;
    static double angle2 = -60;
    static double sizeMultiplier = 1;
    static int counterLimit = 15;
    void fractal(int x, int y, int segmentLength, int counter){
        if(counter > counterLimit) return;
        g.translate(x, y);
        int drawLength = (int) (segmentLength*sizeMultiplier/4);
        int realDrawLength = drawLength;
        if(realDrawLength<1) realDrawLength=1;
        g.drawLine(0, 0, 0, -realDrawLength);

        g.translate(0, -drawLength);

        g.rotate(angle1/180*Math.PI);
        fractal(0, 0, segmentLength/3*2, counter+1);
        //g.translate(0, segmentLength);
        g.rotate(-angle1/180*Math.PI);


        g.rotate((angle2)/180*Math.PI);
        fractal(0, 0, segmentLength/3*2, counter+1);
        g.rotate(-(angle2)/180*Math.PI);
        g.translate(0, drawLength);
    }
}
