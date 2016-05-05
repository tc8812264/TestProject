package practice;

class ChopStick{//筷子类;
	boolean available;//筷子是否可用;
	int n;//第n双筷子;
	ChopStick(int n){
		this.available = true;
		this.n = n;
	}//初始化筷子为可用;
	public synchronized void takeup(String name){
		while(!available){
			System.out.println(name+"在等待拿起第"+n+"双筷子");
		}
		try {
			wait(); //等待;
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		available = false;
	}
	public synchronized void putdown(){
		available = true;
		notify(); //通知其他线程该线程放下筷子了;
	}
}
class Philosopher extends Thread{
    ChopStick left,right;
    String name;
    Philosopher(String name,ChopStick left,ChopStick right){
        this.name=name;
        this.left=left;
        this.right=right;
         
    }
    public void think(){      //思考问题
        left.putdown();            //放下左筷子
        right.putdown();           //放下右筷子
        System.out.println(name+"在思考。。。。");
    }
     
    public void eat(){
        left.takeup(name);        //拿起左筷子
        right.takeup(name);         //拿起右筷子
        System.out.println(name+"在吃饭。。。。");
    }
    public void run(){
        while(true){
            eat();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            think();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                 
                e.printStackTrace();
            }
        }
         
    }
}
public class Dining {
	   static ChopStick cp[]=new ChopStick[5];
	    static Philosopher ph[]=new Philosopher[5];
	    public static void main(String args[]) {
	    for(int n=0;n<5;n++){
	        cp[n]=new ChopStick(n);
	    }   
	    for(int n=0;n<5;n++){
	        ph[n]=new Philosopher("哲学家"+n,cp[n],cp[(n+1)%5]);
	    }
	    for(int n=0;n<5;n++){
	        ph[n].start();
	    }
	    }
}
