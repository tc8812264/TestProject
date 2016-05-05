package practice;

public class CloneDemo {
	public static void main(String[] args){
		Obj a = new Obj();
		Obj b = (Obj)a.clone();
		b.changeSon("li");
		System.out.print(a.getSon().name+" "+b.getSon().name);
	}
}
class Son implements Cloneable{
	int age = 10;
	String name = "tc";
	public Object clone(){
		Object o = null;
		try {
			o = (Son)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
}
class Obj implements Cloneable{
	private int i = 0;
	private Son son = new Son();

	public Son getSon() {
		return son;
	}

	public void setSon(Son son) {
		this.son = son;
	}
	
	public void changeSon(String name){
		this.son.name = name;
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	public void changeI(int i){
		this.i = i;
	}
	public Object clone(){
		Obj o = null;
		try {
			o = (Obj)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 实现深复制。
		o.son = (Son)this.getSon().clone();
		return o;
	}
	
}
