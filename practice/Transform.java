package practice;

import java.util.*;

public class Transform {
    public static String trans(String s) {
        String res = "";
        char[] a = s.toCharArray();
        String tmp = "";
        for(int i = 0; i < a.length; ++i){
            if(a[i] < 97) {
               a[i] = Character.toLowerCase(a[i]);
               tmp = tmp + a[i];
            }else {
               a[i] = Character.toUpperCase(a[i]);
               tmp = tmp + a[i];
            }
        }
        String[] tmp1 = tmp.split(" ");
        res = tmp1[tmp1.length - 1];
        for(int i = tmp1.length - 2; i >= 0; --i){
           res = res +" "+tmp1[i]; 
        }
        
        return res;
    }
    public static void main(String[] args){
    	String s = "Hello World";
    	System.out.println(trans(s));
    }
}