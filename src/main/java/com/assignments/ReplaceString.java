package com.assignments;
//Given an array of strings ={“hello”,”ello”}, replace all ll with aa without using inbuilt method.
public class ReplaceString {

    public static String[] replaceChar(String[] array){
        if(array.length<=0)
            return null;
        for(int index=0;index<array.length;index++){
           array[index]=replace(array[index]);
        }
        return array;
    }
    public static String replace(String st){
        StringBuilder builder = new StringBuilder();
        for(int index=0;index<st.length();index++){
            if(st.charAt(index)!='l'){
                builder.append(st.charAt(index));
            }else
                builder.append('a');
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] array ={"hello","ello"};
        String[] array1 = replaceChar(array);
        for(String s:array1)
            System.out.println(s);
    }
}
