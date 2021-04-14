import java.io.*;


public class hole implements Serializable{
    private int  pion;
    
    protected hole ( int pion  ){this.pion = pion;}
    
    protected int getvalue()
    {
        return pion;
    }

    protected void besowed (){
        pion += 1;

    }
    public String toString(){
              return Integer.toString(pion);
    }

    protected void becollected(){
        pion = 0;
    }
   /* protected hole clone() {
        hole clone =null;
        try{
            clone = (hole) super.clone();
        }catch(CloneNotSupportedException e){
           System.out.println(e.getMessage());
        }
        return clone;
    }
    */

   /* protected hole copy() 
    {    
        hole lala = (hole) CloneUtil.clone(this);
        return lala;
    }*/
    protected hole copy()
    {
        hole lala= new hole(this.getvalue()) ;
        return lala;
    }  
}
