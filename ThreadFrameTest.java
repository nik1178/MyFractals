import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ThreadFrameTest extends JFrame implements ActionListener{

    //Main multithread program

    public static void main(String[] args) {
        new ThreadFrameTest();
    }
    
    Graphics2D g;
    //MyFrame frame = new MyFrame(this);
    static final int PANEL_WIDTH = 800;
    static final int PANEL_HEIGHT = 800;
    ThreadFrameTest(){
        setBounds(100, 100, PANEL_WIDTH, PANEL_HEIGHT);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        Timer timer = new Timer(0, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        repaint();
    }

    public static int moveX = 0;
    public static int moveY = -800;
    static ArrayList<Thread> threads = new ArrayList<>();

    @Override
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
        g.setColor(Color.white);
        this.g = (Graphics2D) g;
        this.g.setStroke(new BasicStroke(2));
        g.translate(PANEL_WIDTH/2 + moveX, PANEL_HEIGHT*2+ moveY);


        fractal();

    }

    static double angle1 = 30;
    static double angle2 = -30;
    static double sizeMultiplier = 0.25;
    static int counterLimit = 10;
    static int drawLength;
    void fractal(){

        int segmentLength=this.getHeight();


        /* try{
            Thread.sleep(0);
        }catch(InterruptedException e){} */

        ThreadFrameTest.drawLength = (int) (segmentLength*sizeMultiplier)>=1 ? (int) (segmentLength*sizeMultiplier) : 1;

        g.translate(0, -drawLength);
        g.drawLine(0,0,0,-drawLength);




        MyRunnable mr = new MyRunnable(1, g, 0, -drawLength, 90-angle1);
        Thread t = new Thread(mr);
        threads.add(t);
        t.start();

        int i=0;

        try{
            Thread.sleep(10000);
        }catch(Exception e){}

        while(true){
            try{
                for(; i<threads.size(); i++){
                    threads.get(i).join();
                    //System.out.println(i + " " + threads.size());
                }
                break;
            }catch(Exception e){i--;}
        }
        System.out.println(i);
    }
}


class MyRunnable implements Runnable{

    Graphics2D g;
    int counter = 0;
    int x;
    int y;
    double angle;
    MyRunnable(int counter, Graphics2D g, int x, int y, double angle){
        this.g = g;
        this.counter = counter;
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    @Override
    public void run() {

        /* try{
            Thread.sleep(100);
        }catch(Exception e){System.out.println("no sleep");} */

        g.setColor(Color.white);
        g.setStroke(new BasicStroke(2));

        double divisionValue = ThreadFrameTest.drawLength/(3*Math.pow(counter,1.1))*2;

        int x1 = (int) (x + divisionValue*Math.cos(Math.toRadians(angle)));
        int y1 = (int) (y - divisionValue*Math.sin(Math.toRadians(angle)));

        g.drawLine(x,y,x1,y1);

        if(counter<ThreadFrameTest.counterLimit){
            MyRunnable mr = new MyRunnable(counter+1, g, x1, y1, angle-ThreadFrameTest.angle1);

            Thread t = new Thread(mr);
            
            /* while(true){
                try{
                    ThreadFrameTest.threads.add(t);
                    break;
                }catch(Exception e){}
            } */
            t.start();
        }

        double newAngle2 = angle + ThreadFrameTest.angle1 - ThreadFrameTest.angle2;

        
        int x2 = (int) (x + divisionValue*Math.cos(Math.toRadians(newAngle2)));
        int y2 = (int) (y - divisionValue*Math.sin(Math.toRadians(newAngle2)));

        g.drawLine(x,y,x2,y2);

        if(counter<ThreadFrameTest.counterLimit){
            MyRunnable mr = new MyRunnable(counter+1, g, x2, y2, angle-ThreadFrameTest.angle2);

            Thread t = new Thread(mr);
            
            /* while(true){
                try{
                    ThreadFrameTest.threads.add(t);
                    break;
                }catch(Exception e){}
            } */
            t.start();
        }
    }
}