package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//WJP to Convert keys of a map to List
public class ConvertKeysinList {
    public static List<String> keysToList(Map<String,Integer> map){
        //declare a list
        List<String> list = new ArrayList<>();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            list.add(entry.getKey());
        }
        return list;
    }
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("anju",1);
        map.put("arti",2);
        map.put("Gajal",3);
        System.out.println(keysToList(map));
    }

}
