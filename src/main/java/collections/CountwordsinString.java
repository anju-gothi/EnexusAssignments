package collections;

import java.util.HashMap;
import java.util.Map;

//Write a Java Program to count the number of unique words in a string using HashMap.
public class CountwordsinString {

    public static int countWords(String st){
        int lenght = st.length();
        if(lenght<=1)
            return lenght;
        String[] wordsArray=st.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for(String s:wordsArray){
            if(map.containsKey(s)){
                int value=map.get(s);
                value++;
                map.put(s,value);
            }else{
                map.put(s,1);
            }
        }
        //checking for unique words
        int countW=0;
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                countW++;
                //System.out.println("Unique word is:"+entry.getKey());
            }
        }
      return countW;
    }
     public static void main(String[] args) {
        String st="a d s g a d";
         System.out.println("Number of Unique words are:"+countWords(st));
     }
}
