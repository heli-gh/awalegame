public class debug {
    public static void main (String[] args){
        plateau haha=new plateau();
        hole[] halo= haha.getvalue();
        halo[1]= new hole(1);
        halo[2]=new hole(2);
        hole[] nb = haha.getvalue();

        
        System.out.println(nb[1]);
        System.out.println(nb[2]);
    }
    
}
