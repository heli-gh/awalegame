import java.io.*;

public class plateau implements Serializable{
    protected  hole[] board;
    private int round;
    private int lastHole;
    private String player1;
    private String player2;

    private int note1;
    private int note2;


    public plateau(){

         board = new hole[12];

        for ( int i=0;i<12 ; i++ )
          board[i] = new hole(4);

        round =0;
        lastHole=0;
        note1 =0;
        note2 =0;

    }
    public plateau(plateau obj){
        board = obj.getvalue();
        
    }

    public void setboard(hole[] lala){
        hole[] haha= new hole[12];
        for (int i=0;i<12;i++)
           haha[i]= lala[i].copy();

        this.board = haha;
    }

    public hole[] getvalue(){
        return board;
    }
    private void  setround(int i){
        round=i;
    }

    public int getlastHole(){
        return lastHole;
    }
    private void setlastHole(int i){
         lastHole=i;

    }
    public int[] getnote(){
        int[] a= new int[2] ;
        a[0]=note1;
        a[1]= note2;
        return a;
    }
    public void setnote(int haha, int lala){
        note1 = haha;
        note2 =lala;
         
    }

    public void setplayer(String player1, String player2)
    {
        this.player1 = player1;
        this.player2 = player2;
        
    }
    public String[] getplayer()
    {
        String[] s = new String[2];
        s[0] = new String(player1);
        s[1] = new String(player2);
        return s;
    }
    
    public int getround(){
        return round;
    }

    public void changeRound () {

        round = (round+1)%2;
    
    }
    public String BoardStr(){
        StringBuffer str =new StringBuffer();
        for (int i =0;i<12; i++ ){

        str.append(Integer.toString(board[i].getvalue()));
        str.append(" ");
        }
        str.append("   ");
        str.append(Integer.toString(note1));
        str.append("   ");
        str.append(Integer.toString(note2));

        return str.toString();


    }
    public String toString(){

        String s = BoardStr();

        return s;

    }
    /*
    protected plateau clone(){
        plateau clone =null;
        try{
            clone = (plateau) super.clone();
            for (int i =0 ;i<12;i++){
            clone.board[i]= (hole) board[i].clone();
            }
        

        }catch (CloneNotSupportedException event){ System.out.println();}
        return clone;
    }*/


    
    protected plateau copy() {

        plateau newbody = new plateau();
        newbody.setboard(board); 
        newbody.setround(round); 

        newbody.setlastHole(lastHole);
        newbody.setnote(note1,note2);
        newbody.setplayer(player1, player2);
        
        return newbody;
    }
    /*
    protected plateau copy(){
        plateau newbody = (plateau) CloneUtil.clone(this);
        return newbody;
    }**/
    public  boolean  affamer()
    {
      boolean det=true;
      if ( round == 0){
          for (int i= 0; i<6; i++)
           if (board[i].getvalue() != 0) det =false;

          if (det){
               for (int i= 6; i< 12 ;i++ ) {note2 += board[i].getvalue(); board[i].becollected();}
           }

      }
      else {
          for(int i =6 ; i<12 ;i++)
           if (board[i].getvalue() != 0) det =false;

          if (det){
            for (int i= 0; i< 6 ;i++ ) {
               note1 += board[i].getvalue();
               board[i].becollected();
            
            }
          }
      }
      return det;
    }
    public void abortgame(int para){
        
        if (para== 0) {
            for (int i =0 ; i<12; i++){
                if (getround()==0){
                   note2 += board[i].getvalue();
                   board[i].becollected();
                

                }
                else{
                    note1 += board[i].getvalue();
                    board[i].becollected();
            

                }
            }
        }

    }
    public void note()
    {
        if (round == 0){
           if (lastHole >=6) {
            
                int i = lastHole;
                while (board[i].getvalue() == 2 || board[i].getvalue() ==3){
                    note1 += board[i].getvalue();
                    board[i].becollected();
                    
                    
                    i= (i+11)%12;
                }
            
           }
        }
        else {
           if (lastHole < 6){
            
                int i = lastHole;
                while (board[i].getvalue() == 2 || board[i].getvalue() ==3){
                    note2 += board[i].getvalue();
                    board[i].becollected();
                    
                    
                    i= (i+11)%12;
                }
            
           }
        }
    }

    public void collectandDistri(int theone){
      if(board[theone].getvalue() >0){
        
        if (round == 0){
            if ( 0 <= theone && theone< 6){
                int quantity =board[theone].getvalue();
                board[theone].becollected();
                for (int i=1; i<=quantity; i++){
                    int k= (theone+ i)%12;
                    board[k].besowed();
                
                }
                lastHole = (theone +quantity)%12;

                
               
            }
          

        }
        else {
            if ( 6 <= theone && theone < 12){
                int quantity =board[theone].getvalue();
                board[theone].becollected();
                for (int i=1; i<=quantity; i++){
                    int k= (theone+ i)%12;
                    board[k].besowed();
    
                    
                }
                lastHole = (theone +quantity)%12;

                
               
            }
               
           
        }
        
      }
    }
 



}
