package practice;
class Base{
	public void fun(){
		System.out.println("base!");
	}
}
class Sub extends Base{
	public void fun(){
		System.out.println("Sub!");
	}
}
public class ReflectionDemo {
	public static void main(String args[]){
		try {
			Class<?> c = Class.forName("practice.Sub");
			Base b = (Base)c.newInstance();
			b.fun();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

