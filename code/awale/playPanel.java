import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JLabel;
import java.io.*;

public class playPanel extends JPanel  {
    JButton note1;
    JButton note2;
    JButton[] myholes;
    JPanel panel;
    plateau set;
    JLabel player1 = new JLabel("hello");
    JLabel player2 = new JLabel("hello");
    robot Sara;
    JButton abort;
    JPanel pp;
    boolean thend;
    public  playPanel(int diff, String playername ){
        set =new plateau();
        fixrobot(diff, playername);
        setLayout(new BorderLayout());
        companyAction listener = new companyAction();
        Buttons(listener);
        note1 =new JButton("0");
        note2 =new JButton("0");
        note1.setEnabled(false);
        note2.setEnabled(false);
        panel = new JPanel(); pp= new JPanel();
        pp.setLayout(new GridLayout(2,1));
        panel.setLayout(new GridLayout(2,6));
        abort = new JButton("abort");
        abortAction hear =new abortAction();
        abort.addActionListener(hear);
        pp.add(abort);
        
        addtoPanel();
        add(panel,BorderLayout.CENTER);
        
       
        
        thend = false;
        if (Sara.getround()==0){ 
            int theone= Sara.normal(set);

            if (! set.affamer() && rule.ressonablemove(theone, set)){
                set.collectandDistri(theone);
                set.note();
                set.changeRound();
                changeButtonLabel();
            }
        }
    }
    private void Buttons(ActionListener listener){        
        myholes =new JButton[12];
        for (int i=0 ;i< 12; i++){
            
            myholes[i]= new JButton("4");
            myholes[i].addActionListener(listener);
        }


    }
    private void addtoPanel(){
        String[] ref=set.getplayer(); 
        
         player1.setText("player1:"+ref[0]);
         player2.setText("player2:"+ref[1]);
        if (Sara.getround()==0){
           add(note1,BorderLayout.NORTH);
           add(note2,BorderLayout.SOUTH);
           for(int i=0; i<6;i++){
               panel.add(myholes[5-i]);
           }
           for(int i=6; i<12 ; i++){
               panel.add(myholes[i]);
           }
           add(player1,BorderLayout.EAST);
            pp.add(player2);
           
         

        }
        else {
           add(note1,BorderLayout.SOUTH);
           add(note2,BorderLayout.NORTH);   
            for(int i=6; i<12 ; i++){
              panel.add(myholes[17-i]);
           }
           for(int i=0; i<6;i++){
               panel.add(myholes[i]);
           }

           pp.add(player1);
           add(player2,BorderLayout.EAST);
         
        }
 
        add(pp,BorderLayout.WEST);
    }
    private int randomize(){
        return new java.util.Random().nextBoolean() ? 1 :0;
        
    }

    public void fixrobot( int diff ,String player){
        int i= randomize();
        String name ="";
        if (diff==0) name = "simpleRobot";
        else {if (diff < 5) name = "normalRobot";
              else  name = "difficultRobot";
        }
        
        if (i==0) set.setplayer(name,player);
        else set.setplayer(player, name);
        Sara =new robot(diff,i); 
    
        



    }  
    public  void changeButtonLabel(){    
        for (int i =0; i<12; i++){
            String s= Integer.toString(set.board[i].getvalue());
            myholes[i].setText(s);
        }
        int[] d=set.getnote(); 
        String t =Integer.toString(d[0]);
        String k =Integer.toString(d[1]);
        note1.setText(t);
        note2.setText(k);
        
    }
  /*  public class endDialogue  extends JDialog{
        public endDialogue(JFrame owner){
            super(owner,"Infomation",true);
            JButton start =new JButton("start");
            JButton quit =new JButton("quit");

            int i=rule.gagner(set);
            if (i==0) add(player1);
            else add(player2);
            setTitle("end");
            setSize(260,140);
            setResizable(false);
            setLayout(null); 
            startDialogue.dialogAction lis = new startDialogue.dialogAction();
            start.addActionListener(lis);
            quit.addActionListener(lis);
            add(start);
            add(quit);
            start.setBounds(60,100,60,25);
            quit.setBounds(140, 100,60,25);

        }
    }
   **/
    
    private class abortAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {   int para=0;
            if (set.getround() != Sara.getround()){
            set.abortgame(para);
            changeButtonLabel();
             thend=true;
            }
        }
    }    
    private class companyAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        { 
            if (set.getround() != Sara.getround()){   
        
                    JButton hi = (JButton)e.getSource();
                    int theone = 0;
                    int para=1;
                    for(int i=0 ; i<12; i++){ if (myholes[i]== hi) {theone = i;break;}}
                    if (rule.ressonablemove(theone, set)){

                    if (! rule.endofgame(set,para)){
                              set.collectandDistri(theone);
                              set.note();
                              set.changeRound();
                    }

                   changeButtonLabel();
                   
                   if (rule.endofgame(set, para)) {
                         thend =true;
                   }
                   else {  
                            theone= Sara.normal(set);

                         if (rule.ressonablemove(theone, set)){
                             set.collectandDistri(theone);
                             set.note();
                             set.changeRound();
                             
                         }
                         
                         if(rule.endofgame(set,para)){
                            thend = true;
                         }
                   }
                   changeButtonLabel();
            
                }
            }
        }
    }
}


