package practice;

public class ByteCountDemo {
	public static void main(String[] args){
/*		for(;;){
			for(int i = 0; i < 9600000*2; ++i){
				
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		System.out.println(ByteCount4(1,1));
	}
	public static int ByteCount(int v) {
		int num = 0;
		while(v != 0){
			if(v % 2 == 1){
				++num;
			}
			v = v / 2;
		}
		return num;
	}//使用除法来求二进制数中有多少个1;
	public static int ByteCount2(int v){
		int num = 0;
		while(v != 0){
			num += v & 1;
			v = v >> 1;
		}
		return num;
	}//使用位运算来求二进制中有多少个1，时间复杂度为log2(v);不是最高效的解法。
	public static int ByteCount3(int v) {
		int num = 0;
		while(v != 0) {
			v &= v - 1;
			++num;
		}
		return num;
	}//这样时间复杂度为n（1的个数）;
	public static int ByteCount4(int a, int b) {
		int res = 0;
		int tmp = a ^ b;
		while(tmp != 0) {
			tmp &= tmp - 1;
			++res;
		}
		return res;
	}
}
