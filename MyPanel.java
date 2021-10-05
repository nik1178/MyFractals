import java.awt.Color;

import javax.swing.*;
public class MyPanel extends JPanel{
    
    MyFrame frame = new MyFrame(this);
    MyPanel(){
        this.setSize(frame.getWidth(), frame.getHeight());
        this.setBackground(Color.black);
    }
}
