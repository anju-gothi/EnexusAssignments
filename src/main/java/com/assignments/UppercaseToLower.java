package com.assignments;
//Convert Uppercase to Lowercase in java without using built in method?

public class UppercaseToLower {

    public static String convertCase(String st){
        if(st.length()<1)
            return st;
        StringBuilder builder = new StringBuilder();
        for(int index=0;index<st.length();index++){
            char ch = st.charAt(index);
           if(ch<=(int)'Z' && ch>=(int)'A'){
               builder.append((char)(ch+32));
           }
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        System.out.println("Lowercase is:"+convertCase("ANJU"));
    }
}
