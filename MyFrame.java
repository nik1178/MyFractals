import javax.swing.*;
public class MyFrame extends JFrame{
    
    MyFrame(MyPanel panel){

        this.add(panel);

        this.setSize(800,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
