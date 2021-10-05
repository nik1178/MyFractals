import javax.swing.*;
import java.awt.event.*;
public class MyFrame extends JFrame implements MouseWheelListener, KeyListener{
    
    MyPanel panel = new MyPanel();
    MyFrame(){

        this.add(panel);

        this.addMouseWheelListener(this);
        this.addKeyListener(this);

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
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
