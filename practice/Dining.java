package practice;

class ChopStick{//������;
	boolean available;//�����Ƿ����;
	int n;//��n˫����;
	ChopStick(int n){
		this.available = true;
		this.n = n;
	}//��ʼ������Ϊ����;
	public synchronized void takeup(String name){
		while(!available){
			System.out.println(name+"�ڵȴ������"+n+"˫����");
		}
		try {
			wait(); //�ȴ�;
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		available = false;
	}
	public synchronized void putdown(){
		available = true;
		notify(); //֪ͨ�����̸߳��̷߳��¿�����;
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
    public void think(){      //˼������
        left.putdown();            //���������
        right.putdown();           //�����ҿ���
        System.out.println(name+"��˼����������");
    }
     
    public void eat(){
        left.takeup(name);        //���������
        right.takeup(name);         //�����ҿ���
        System.out.println(name+"�ڳԷ���������");
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
	        ph[n]=new Philosopher("��ѧ��"+n,cp[n],cp[(n+1)%5]);
	    }
	    for(int n=0;n<5;n++){
	        ph[n].start();
	    }
	    }
}
