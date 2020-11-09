package collections;

//7. Remove duplicates from arraylist without using collections

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicate {
  public static void remove(List<Character> list){
      for(int index=0;index<list.size();index++){
          char ch = list.get(index);
          int firstindex=list.indexOf(ch);
          int lastindex=list.size()-1;
          do{
           if(list.get(lastindex)==ch){
               list.remove(list.get(lastindex));
               System.out.println(list);
              lastindex=list.size()-1;
           }
           else
               lastindex--;

          } while(firstindex!=lastindex);

      }
  }
    public static void main(String[] args) {
        List<Character> list=new ArrayList<>();
        list.add('a');
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('b');
        remove(list);
        System.out.println(list);
    }
}
