import java.awt.*;
import java.applet.*;
public class Test1 extends Applet{
    @Override
    public void init(){
        setSize(1200,600);
        setBackground(Color.CYAN);
    }

    public void paint(Graphics g){
        /* makeTree(100,0,600,550,g); */
    }
    void makeTree(int length, int angle, int x, int y, Graphics g){
        int xmove = (int) (Math.cos(Math.toRadians(angle))*length);
        int ymove = (int) (Math.sin(Math.toRadians(angle))*length);
        g.drawLine(x, y, x+xmove, y+ymove);
        if(length>=1){
            makeTree(length-10, angle+30, x+xmove, y+ymove, g);
            makeTree(length-10, angle-30, x+xmove, y+ymove, g);
        }
    }
}
