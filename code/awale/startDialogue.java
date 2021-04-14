
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class startDialogue extends JDialog {
    private JLabel label1 =new JLabel("Your name:");
    private int diff =1;
    private JTexField Tex =new JTextField(20);
    private JButton start= new JButton("start");
    private JButton quit = new JButton("quit");



   private String playername;
    public int  getdiff()
    {
        return diff;
    }
    public String getplayername()
    {
        return playername;
    }

    public startDialogue(JFrame owner)
    {
        super(owner,"Infomation",true);
        setSize(260,140);
        setResizable(false);
        setLayout(null); 
        add(label1);add(Tex);
        label1.setBounds(50,30,65,20);
        Tex.setBounds(120,30,90,20);

       
        dialogAction lis = new dialogAction();
        start.addActionListener(lis);
        quit.addActionListener(lis);
        add(start);
        add(quit);
        start.setBounds(60,100,60,25);
        quit.setBounds(140, 100,60,25);
        




    }

    public class dialogAction implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {   if (e.getSource() == quit) System.exit(0);
           else { playername=Tex.getText().trim(); dispose();}  
          
       }
    }


    
    
}
