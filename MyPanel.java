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

    @Override
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
        g.setColor(Color.white);
        this.g = (Graphics2D) g;
        int segmentLength=this.getHeight();
        fractal(PANEL_WIDTH/2, PANEL_HEIGHT, segmentLength);
    }

    static double angle1 = 60;
    static double angle2 = -60;
    void fractal(int x, int y, int segmentLength){
        if(segmentLength*10<1) return;
        g.translate(x, y);
        int drawLength = segmentLength/4;
        g.drawLine(0, 0, 0, -drawLength);

        g.translate(0, -drawLength);

        g.rotate(angle1/180*Math.PI);
        fractal(0, 0, segmentLength/3*2);
        //g.translate(0, segmentLength);
        g.rotate(-angle1/180*Math.PI);


        g.rotate((angle2)/180*Math.PI);
        fractal(0, 0, segmentLength/3*2);
        g.rotate(-(angle2)/180*Math.PI);
        g.translate(0, drawLength);
    }
}
