import java.io.*;


public class CloneUtil{
    /*public static <T extends Serializable> T clone(T obj){
            T cloneObj=null;
            try{
                    //写入字节流
                    ByteArrayOutputStream baos=new ByteArrayOutputStream();
                    ObjectOutputStream oos=new ObjectOutputStream(baos);
                    oos.writeObject(obj);
                    oos.flush();
                    oos.close();

                    //分配内存,写入原始对象,生成新对象
                    ByteArrayInputStream bais=new ByteArrayInputStream(baos.toByteArray());//获取上面的输出字节流
                    ObjectInputStream ois=new ObjectInputStream(bais);

                    //返回生成的新对象
                    cloneObj= (T) ois.readObject();
                    ois.close();
            }catch (Exception e){
                   e.printStackTrace();
            }
            return cloneObj;
    }*/


//测试类1
  public static Object clone(Object oldObj) {   
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
    }  
//测试类2



//测试
}