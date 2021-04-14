public class rule {

    public static int gagner(plateau set)
    {   
        int res = 0; 
        if (set.getnote()[0] > 24  ) res = 1;
        
         
        if (set.getnote()[1] > 24  ) res = 2;

         
        return res;
    
    }
    public static boolean opponentzero(plateau set){
        boolean det = true;
        if (set.getround() == 0){
           for (int i= 6; i<12; i++)
            if (set.board[i].getvalue() != 0) det=false;
        }
        else {  
           for (int i= 0; i<6; i++)
            if (set.board[i].getvalue() != 0) det=false;

        }
        return det;
    }
 /*   public static boolean starveonpurpose (int move,plateau set){
        boolean det = false;
        boolean res= false;

        if ( set.getround() == 0){
          if (opponentzero(set)){
             for (int i= 0; i<6; i++){
               if ((set.board[i].getvalue()+i)%12 >= 6 || set.board[i].getvalue() >=6)
                
                det=true;
             }
          }
          if (det){
              if (set.board[move].getvalue()< 6 && (set.board[move].getvalue()+move)%12 < 6) {
              res = true;
              }

          }
           
        }
        else {
            if (opponentzero(set)){
               for (int i= 6; i<12; i++)
                if ((set.board[i].getvalue()+i)%12 < 6 || set.board[i].getvalue() >=6)
                 det=true;
            }
            if (det){
                if ((set.board[move].getvalue()+move)%12 >= 6 && set.board[move].getvalue() <6)
                 res=true;
            }
        }
        return res;
    }
    **/
    public static boolean eatall(int move ,plateau set){
        plateau predict= set.copy(); 
        boolean res;
        predict.collectandDistri(move);
        res = opponentzero(predict);
        return res;
    }

    public static boolean ressonablemove(int move ,plateau set){
        boolean res =true;
        if (set.getround() ==0){
            if (move <0 || move >5) res =false;
        }
        else{ 
            if (move< 6 || move >11) res = false;
        }
        if (set.board[move].getvalue() == 0) res =false;
       // else if (starveonpurpose(move, set)) res =false;
        if (eatall(move, set)) res=false;

        return res;
        
            
    }
    public static boolean endlessloop(plateau set){
        int value =0;
        int[] a= new int [2];
        for (int i=0 ; i<12 ;i++) value +=set.board[i].getvalue(); 
        if (value == 2){
            int j=0;
            for (int i=0 ; i<12 ;i++){
               if (set.board[i].getvalue() !=0) {
                   a[j] = i;
                   j++;
               }
            }
            if (a[1]-a[0]== 6){
                return true;
            }  
        }
        return false;

    }
    public static boolean endofgame (plateau set,int para){
        boolean det;
        if (set.affamer())det =true;
        else if (para==0)det =true;
        else if (endlessloop(set)) det =true;
        else det =false;
        return det;
    }
   /*public static Object copy(Object oldObj) {   
        Object obj = null;   
        try {   
            // Write the object out to a byte array   
            ByteArrayOutputStream bos = new ByteArrayOutputStream();   
            ObjectOutputStream out = new ObjectOutputStream(bos);   
            out.writeObject(oldObj);   
            out.flush();   
            out.close();   
      
            // Retrieve an input stream from the byte array and read   
            // a copy of the object back in.   
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());    
            ObjectInputStream in = new ObjectInputStream(bis);   
            obj = in.readObject();   
        } catch (IOException e) {   
            e.printStackTrace();   
        } catch (ClassNotFoundException cnfe) {   
            cnfe.printStackTrace();   
        }   
        return obj;   
    }  **/

}
