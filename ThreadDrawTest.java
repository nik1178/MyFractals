import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ThreadDrawTest extends JFrame implements ActionListener{

    public static void main(String[] args) {
        new ThreadDrawTest().setVisible(true);
    }
    
    Graphics2D g;
    //MyFrame frame = new MyFrame(this);
    static final int PANEL_WIDTH = 800;
    static final int PANEL_HEIGHT = 800;
    ThreadDrawTest(){
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
    public static int moveY = 0;
    static ArrayList<Thread> threads = new ArrayList<>();

    @Override
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
        g.setColor(Color.white);
        this.g = (Graphics2D) g;
        this.g.setStroke(new BasicStroke(2));
        int segmentLength=this.getHeight()/2;

        System.out.println("Test");

        this.g.translate(PANEL_WIDTH/2 + moveX, PANEL_HEIGHT/2+ moveY);
        //this.g.drawLine(0, 0, 0, -segmentLength);

        MyRunnableTest mr1 = new MyRunnableTest(this.g, 0);
        Thread t = new Thread(mr1);
        threads.add(t);
        t.start();

        int i=0;
        while(true){
            try{
                for(; i<threads.size(); i++){
                    threads.get(i).join();
                }
                break;
            }catch(Exception e){i--;}
        }
        
    }
}


class MyRunnableTest  implements Runnable{

    Graphics2D g;
    int counter = -1;
    MyRunnableTest(Graphics2D g, int counter){
        this.g = g;
        this.counter = counter;
    }

    @Override
    public void run() {
        g.setColor(Color.white);
        g.setStroke(new BasicStroke(2));
        g.drawLine(-100, -100, 100, 100+counter*10);
        if(counter<1500 && counter>=0){
            MyRunnableTest mr1 = new MyRunnableTest(this.g, counter+1);
            Thread t = new Thread(mr1);
            while(true){
                try{
                    ThreadDrawTest.threads.add(t);
                    break;
                }catch(Exception e){}
            }
            t.start();
        }
    }
}