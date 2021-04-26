public class robot{
   private String name;
   private int diff;
   private int round ;
   public robot(int diff ,int round){
       this.diff = diff; 
       this.round = round ;
       if (diff==0) name = "simpleRobot";
       else {if (diff < 5) name = "normalRobot";
             else  name = "difficultRobot";
       }

   }
   public String getname(){
       return name;
   } 
   public int getdiff(){
       return diff;
   } 
   public int  getround(){
       return round;
   } 
   public void setround(plateau set){
       String[] n = set.getplayer();
       if (n[0].equals("simpleRobot") || n[0].equals("normalRobot") || n[0].equals("difficultRobot")) round = 0;
       else round =1;
                
   }
   private int toolmaxturn(plateau set,int deep){
       
    int[] det= new int[6];
    int max = 0;
    int[] a= set.getnote();
    if(rule.endofgame(set, 1) || deep==0){max= a[round]- a[(round +1)%2] ;return max;}
    
    if(a[round] > 24){ max = 100;}
    else {

   
      if (set.getround() ==0){ 
        for (int i =0; i < 6; i++){
             plateau predict = set.copy();
             if (rule.ressonablemove(i, predict)){
              predict.collectandDistri(i);
              predict.note();
              predict.changeRound();
              det[i] =toolminturn(predict,deep -1);
              
             }

        }


      }

      else{
        for (int i =6; i < 12; i++){
            plateau predict = set.copy();
            if (rule.ressonablemove(i, predict)){
                predict.collectandDistri(i);
                predict.note();
                predict.changeRound();

                det[i-6]=toolminturn(predict,deep -1);

            }

        }
      }
    
      for (int i= 0; i<6 ; i++)
      {
        if (max < det[i]) max =det[i];   
      }
    }
    return max;

   }
   private int toolminturn(plateau set,int deep){
    int[] det= new int[6];
    int min=0;
    int[] a= set.getnote();
    if(rule.endofgame(set, 1)|| deep ==  0){min= a[round]- a[(round +1)%2] ; return min;}
    
    if (a[round] > 24){ min =100;}
    else{
      if (set.getround() ==0){ 
        for (int i =0; i < 6; i++){
             plateau predict = set.copy();
             if (rule.ressonablemove(i, predict)){
              predict.collectandDistri(i);
              predict.note();
              predict.changeRound();
              det[i] =toolmaxturn(predict,deep-1);

              
             }

        }


      }

      else{
        for (int i =6; i < 12; i++){
            plateau predict = set.copy();
            if (rule.ressonablemove(i, predict)){
                predict.collectandDistri(i);
                predict.note();
                predict.changeRound();

                det[i-6]=toolmaxturn(predict,deep -1);

            }

        }
      }
    
      for (int i= 0; i<6 ; i++)
      {
        if (min > det[i]) min =det[i];   
      }
    }
    return min;

   }

   private int[] toolattact(plateau set){
       int[] det = new int[6];
       for (int i=0; i<6; i++) det[i]=0;

      
       if (set.getround() ==0){ 
           for (int i =0; i < 6; i++){
               plateau predict = set.copy();
               if (rule.ressonablemove(i, predict)){
               predict.collectandDistri(i);
               predict.note();
               predict.changeRound();
               int[] a=predict.getnote();
               int[] b=set.getnote();
               det[i]=a[0]-b[0];
               }

           }


       }
       else{
           for (int i =6; i < 12; i++){
               plateau predict = set.copy();
               if (rule.ressonablemove(i, predict)){
                   predict.collectandDistri(i);
                   predict.note();
                   predict.changeRound();
                   int[] a=predict.getnote();
                   int[] b=set.getnote();

                   det[i-6]=a[1]-b[1];

               }

           }
       }
       return det;


   }  
   public int normal(plateau set){
      
      int num =0 ;
      int[] det = new int[6];
      int[] ev = new int[6];
      
      if (set.getround() ==0 ){
        for (int i=0 ; i<6 ; i++){
            plateau lalala = set.copy();
            if (rule.ressonablemove(i, lalala)){
                lalala.collectandDistri(i);
                lalala.note();
                lalala.changeRound();
                det[i] = toolminturn(set, diff);
                
            }
        }
      }
      else {
        for (int i=6; i<12;i++){
             plateau lalala = set.copy();
            if (rule.ressonablemove(i, lalala)){
                lalala.collectandDistri(i);
                lalala.note();
                lalala.changeRound();
                det[i-6] = toolminturn(set, diff);

             
         }
        }

      }
 
      int[] ord = det;
      
      if (set.getround()==0){   
            for (int j=0; j<6;j++){
                int max=0;
                for (int i =0;i<6; i++ ){
                      if (ord[max]<ord[i]) 
                      {max =i;
                      
                      }

                }
               ord[max]= -50;
               ev[j]=max;
            }

      }
      else{            
          for (int j=0 ; j<6;j++ ){
             int max=0;
             for (int i =0;i<6; i++ ){
             if (ord[max]<ord[i]) max = i;
             }
             ord[max]=-50;
             
            ev[j]=max+6;
        }
        
      }
      int t =0;
      while(! rule.ressonablemove(ev[t], set) && t< 5 )
      {
         t++;   
      }
      num = ev[t];
    return num;
            



   }

   private int[] toolprotect(plateau set){
       int[] det = new int[6];
       for (int i=0; i<6; i++) det[i]=0;
       if (set.getround() ==0 ){
           for (int i=0 ; i<6 ; i++){
               plateau lalala = set.copy();
               if (rule.ressonablemove(i, lalala)){
                   lalala.collectandDistri(i);
                   lalala.note();
                   lalala.changeRound();
                   int[] ref;

                   ref = toolattact(lalala);

                   int max=0;
                   for (int j =0;j<6; j++ ){
                       if (max<ref[j]) max = ref[j];
                   }
                   det[i]=max;
               }
           }
       }
       else {
           for (int i=6; i<12;i++){
                plateau lalala = set.copy();
               if (rule.ressonablemove(i, lalala)){
                lalala.collectandDistri(i);
                lalala.note();
                lalala.changeRound();
                int[] ref ;
                ref = toolattact(lalala);
                int max=0;
                for (int j =0;j<6; j++ ){
                    if (max<ref[j]) max = ref[j];
                }
                det[i-6]=max;
            }
           }

       }
       return det;
   }

   public  int[] toolevalu(plateau set ){
       int[] a =toolattact(set);
       int[] b = toolprotect(set);
       int[] c = new int[6];
       for (int i=0; i<6; i++)
       {
           c[i]= a[i]-b[i];
       }
       return c;
   }
   public int simple( plateau set) {
         int[] det = toolevalu(set);
         int fin=0;
         int[] ev= new int[6];
         int[] ord = det;
      
         if (set.getround()==0){   
               for (int j=0; j<6;j++){
                   int max=0;
                   for (int i =0;i<6; i++ ){
                         if (ord[max]<ord[i]) 
                         {max =i;
                         
                         }
   
                   }
                  ord[max]= -50;
                  ev[j]=max;
               }
   
         }
         else{            
             for (int j=0 ; j<6;j++ ){
                int max=0;
                for (int i =0;i<6; i++ ){
                if (ord[max]<ord[i]) max = i;
                }
                ord[max]=-50;
                
               ev[j]=max+6;
           }
           
         }
         int t =0;
         while(! rule.ressonablemove(ev[t], set) && t< 5 )
         {
            t++;   
         }
         fin = ev[t];
       
         try{
             Thread.currentThread().sleep(1000);
         }

         catch (InterruptedException event){ event.printStackTrace();}
         return fin;
   }
   /*  
    public abstract int moderate( plateau set){

   }
   public abstract int difficult( plateau set){

   }
   public int robotplay(plateau set){

   }
   **/
}
