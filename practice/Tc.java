package practice;

import java.util.*;

public class Tc {
	public static void main(String args[]){
		Tc1 a = Tc1.getInstance();
		List b = new ArrayList();
		b.add(1);
		b.add(1);
		b.add(2);
		b.add(2);
		b.add(4);
		b.add(3);
		b.add(3);
		b.add(4);
		removeRepeatNumber(b);
	}
	public static void removeRepeatNumber(List list){
		Set set = new HashSet();
		List newList = new ArrayList();
		for(Iterator it = list.iterator();it.hasNext();) {
			Object element = it.next();
			if(set.add(element)) {
				newList.add(element);
			}
		}
		list.clear();
		list.addAll(newList);
		System.out.println(list);
	}
}

class Tc1 {
	private Tc1(){};
	public static Tc1 getInstance(){
		return Tcinstance.instance;
	}
	private static class Tcinstance{
		static Tc1 instance = new Tc1();
	}

}
