package collections;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//12. WJP To Serialize HashMap In Java ?
/*HashMap class is serialized by default.It means HashMap class  does not need to implement Serializable interface
in order to make it eligible for Serialization.*/
public class SerializeHashMap {

    public static void serializeMap(Map<String,Integer> map){
        FileOutputStream file=null;
        try {
             file = new FileOutputStream("C:\\Users\\prash\\IdeaProjects\\com.enexus.global\\src\\main\\java\\collections\\file.ser");
            ObjectOutputStream streamobj = new ObjectOutputStream(file);
            streamobj.writeObject(map);
            streamobj.close();
            file.close();
        }catch(IOException e){
            System.out.println("File not found");
            e.printStackTrace();
        }

        }

        public static void deSerializeMap(String filePath){
               Map<String,Integer> map = new HashMap<>();
        try {
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream stream = new ObjectInputStream(file);
            map=(HashMap)stream.readObject();
            file.close();
            stream.close();
        }catch(IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException c){
            c.printStackTrace();
        }
          System.out.println("Deserialized map:"+map);

        }
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("anju",1);
        map.put("rama",2);
        map.put("Lalaita",3);
        serializeMap(map);
        deSerializeMap("C:\\Users\\prash\\IdeaProjects\\com.enexus.global\\src\\main\\java\\collections\\file.ser");
    }
}
