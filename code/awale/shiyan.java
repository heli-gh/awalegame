import java.util.Scanner;

import java.io.*;
public class shiyan {


    public static void main(String[]args) throws IOException{
          final int diff =0;
          final int round=0;
          int para =1;
          robot Sara= new robot(diff,round);
          plateau zl= new plateau();
          Scanner s =new Scanner(System.in);
          if (Sara.getround() == 0){
            System.out.println(zl);
               int move = Sara.simple(zl);
               System.out.println(Integer.toString(move));
               if (rule.ressonablemove(move, zl)){
                   zl.collectandDistri(move);
                   zl.note();
                   zl.changeRound();
                   System.out.println(zl);

               }
          }

          while (! rule.endofgame(zl,para)){
            int theone;
            do{
             System.out.println(zl);

             System.out.println("choice:");

             theone = s.nextInt();

            }
             while (! rule.ressonablemove(theone, zl)) ;            

             
                if (rule.ressonablemove(theone, zl)){
                    zl.collectandDistri(theone);
                    zl.note();
                    zl.changeRound();
                    
                



            }
        
            if(! rule.endofgame(zl,para)){
               int move = Sara.simple(zl);
               System.out.println(Integer.toString(move));
               if ( rule.ressonablemove(move, zl)){
                   zl.collectandDistri(move);
                   zl.note();
                   zl.changeRound();
                   System.out.println(zl);

               }
            }
        

        

  

          }





    }
    
}
