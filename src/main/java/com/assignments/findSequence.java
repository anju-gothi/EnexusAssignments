package com.assignments;
/*String a="HeyDearHowareyou";
        String b="Howareyou";
        Write a code to find that string b is present in String
        a? without induild funtion*/

import java.util.ArrayList;
import java.util.List;
public class findSequence
{
    public static boolean findSeq(String a,String b){
        if(a.length()<b.length())
            return false;
        List<String> list = new ArrayList<>();
        int index2=0;
      for(int index=0;index<=a.length()-b.length();index++){
          if(a.charAt(index)==b.charAt(0)){
              StringBuilder builder = new StringBuilder();
              //start from first matching character index
                index2=index;
                while(index2<index+b.length()){
                    builder.append(a.charAt(index2));
                    index2++;
                }
                if(b.equals(builder.toString()))
                   return true;
          }
      }
      return false;
    }
    public static void main(String[] args) {
        String a= "HeyDearHowareyou";
        String b ="Howareyou";
        System.out.println(findSeq(a,b));
    }

}

