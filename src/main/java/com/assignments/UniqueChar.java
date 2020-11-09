package com.assignments;
/*Given two strings, first string is a sentence and the second string is a character. You need to write a
        function to print unique number of characters in between the occurrences of second-string excluding
        spaces. String1 = “I love java programming” String2 =”o” output: “vejavpr”*/


import java.util.HashSet;
import java.util.Set;

public class UniqueChar {
  public static String findUnique(String st, String ch){
    int length = st.length();
    if (length<=1)
        return st;
    int firstIndex;
    int secondIndex;
    //finding the index of given charcter
    firstIndex= st.indexOf(ch);
    secondIndex = st.lastIndexOf(ch);
      String sub=" ";
    if(secondIndex>firstIndex){
         sub = st.substring(firstIndex+1,secondIndex);
    }
    //getting unique charcters
    Set<Character> set = new HashSet<>();
      for(int index=0;index<sub.length();index++){
          if(sub.charAt(index)!=' '){
             set.add(sub.charAt(index));
          }
      }

      return set.toString();
}

    public static void main(String[] args) {
      String st = "I love java programming";
      String ch ="o";
      System.out.println("Unique characters are:"+findUnique(st,ch));

    }
}
