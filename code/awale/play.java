import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class play {   





    public static void main(String[] args){       
        EventQueue.invokeLater(()->{
           JFrame f =new JFrame("Awale");
           f.setBounds(600,600,600,600);
           int diff=8;
           
           playPanel awale = new playPanel(diff,"lihengshuo");
           
           f.add(awale);
           f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           f.setVisible(true);
        });

    }
}
