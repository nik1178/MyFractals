import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
public class MyFrame extends JFrame implements MouseWheelListener, KeyListener, MouseMotionListener, MouseListener{
    
    MyPanel panel = new MyPanel();
    MyFrame(){

        this.add(panel);

        this.addMouseWheelListener(this);
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    int selectedLine = 0;

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        // TODO Auto-generated method stub
        if(selectedLine==1) MyPanel.angle2+=e.getWheelRotation();
        else if(selectedLine==2) MyPanel.angle1+=e.getWheelRotation();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        System.out.println(e.getKeyCode());
        if(e.getKeyCode()==49){
            selectedLine = 1;
        } else if(e.getKeyCode()==50){
            selectedLine = 2;
        }

        if(e.getKeyCode()==45){
            MyPanel.sizeMultiplier*=0.9;
            /* MyPanel.counterLimit--; */
        } else if(e.getKeyCode()==521){
            MyPanel.sizeMultiplier*=1.1;
            /* MyPanel.counterLimit++; */

        }
        repaint();
    }

    int startX;
    int startY;
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        startX=e.getX();
        startY=e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        MyPanel.moveX += e.getX()-startX;
        MyPanel.moveY += e.getY()-startY;

        startX=e.getX();
        startY=e.getY();

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
