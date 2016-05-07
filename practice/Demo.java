package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Demo {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; ++i) {
		  list.add(2);
		}
		for(int j = 0; j < 100; ++j) {
		  list.add(3);
		}
    for(int j = 0; j < 1000; ++j) {
      list.add(4);
    }
    for(int j = 0; j < 3; ++j) {
      list.add(5);
    }
    for(int j = 0; j < 87; ++j) {
      list.add(6);
    }
    for(int j = 0; j < 7; ++j) {
      list.add(7);
    }
    for(int j = 0; j < 432; ++j) {
      list.add(8);
    }
    list.add(10);
    list.add(10);
    list.add(55);
    list.add(55);
    list.add(55);
    list.add(55);
    list.add(77);
    list.add(85);
    list.add(105);
    Solve(list);

	}
	public static void Solve(ArrayList<Integer> list) {
	  Map<Integer,Integer> temp = new HashMap<Integer,Integer>();
	  for(int i : list) {
	    if(temp.get(i) == null){
	      temp.put(i, 1);
	    }else {
	      temp.put(i, temp.get(i) + 1);
	    }
	  }
	  temp = sortMap(temp);
	  getRes(temp);
	}
	private static void getRes(Map<Integer,Integer> map){
	  int i = 0;
    Iterator<Entry<Integer,Integer>> it = map.entrySet().iterator();  
    while(i < 5){  
       Map.Entry<Integer,Integer> entry = (Map.Entry<Integer,Integer>) it.next();  
       System.out.println(entry.getKey() + ":" + entry.getValue()); 
       ++i; 
    }  
	}   
public static Map<Integer,Integer> sortMap(Map<Integer,Integer> oldMap) {  
    ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(oldMap.entrySet());  
    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {  

        @Override  
        public int compare(Entry<Integer, Integer> arg0,  
                Entry<Integer, Integer> arg1) {  
            return -(arg0.getValue() - arg1.getValue());  
        }  
    });  
    Map<Integer,Integer> newMap = new LinkedHashMap<Integer,Integer>();  
    for (int i = 0; i < list.size(); i++) {  
        newMap.put(list.get(i).getKey(), list.get(i).getValue());  
    }  
    return newMap;  
}  
}  



