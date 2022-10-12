import java.awt.Color;
import java.awt.image.BufferStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FrameTest extends JFrame implements ActionListener{

    public static void main(String[] args) {
        new FrameTest().setVisible(true);
    }
    
    Graphics2D g;
    //MyFrame frame = new MyFrame(this);
    static final int PANEL_WIDTH = 800;
    static final int PANEL_HEIGHT = 800;
    FrameTest(){
        setBounds(100, 100, PANEL_WIDTH, PANEL_HEIGHT);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        this.g.setStroke(new BasicStroke(2));
        int segmentLength=this.getHeight();
        g.translate(PANEL_WIDTH/2 + moveX, PANEL_HEIGHT*2+ moveY);

        fractal(segmentLength, 0);
        //makeTree(100,-90,400,800,g);
        System.out.println(i);

    }

    int i=0;

    static double angle1 = 30;
    static double angle2 = -30;
    static double sizeMultiplier = 1;
    static int counterLimit = 10;
    void fractal(int segmentLength, int counter){
        try{
            Thread.sleep(0);
        }catch(InterruptedException e){
            
        }
        if(counter > counterLimit) return;
        int drawLength = (int) (segmentLength*sizeMultiplier/4);
        int realDrawLength = drawLength;
        if(realDrawLength<1) realDrawLength=1;
        g.drawLine(0, 0, 0, -realDrawLength);

        g.translate(0, -drawLength);

        g.rotate(angle1/180*Math.PI);
        fractal(segmentLength/3*2, counter+1);
        //g.translate(0, segmentLength);
        g.rotate(-angle1/180*Math.PI);


        g.rotate((angle2)/180*Math.PI);
        fractal(segmentLength/3*2, counter+1);
        g.rotate(-(angle2)/180*Math.PI);
        g.translate(0, drawLength);

        i++;
    }

    void makeTree(int length, int angle, int x, int y, Graphics g){
        int xmove = (int) (Math.cos(Math.toRadians(angle))*length);
        int ymove = (int) (Math.sin(Math.toRadians(angle))*length);
        g.drawLine(x, y, x+xmove, y+ymove);
        try{
            Thread.sleep(1);
        } catch (Exception e) {
            
        }
        if(length>=1){
            makeTree(length-10, angle+30, x+xmove, y+ymove, g);
            makeTree(length-10, angle-30, x+xmove, y+ymove, g);
        }
    }
}
