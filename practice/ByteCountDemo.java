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
	}//ʹ�ó�����������������ж��ٸ�1;
	public static int ByteCount2(int v){
		int num = 0;
		while(v != 0){
			num += v & 1;
			v = v >> 1;
		}
		return num;
	}//ʹ��λ����������������ж��ٸ�1��ʱ�临�Ӷ�Ϊlog2(v);�������Ч�Ľⷨ��
	public static int ByteCount3(int v) {
		int num = 0;
		while(v != 0) {
			v &= v - 1;
			++num;
		}
		return num;
	}//����ʱ�临�Ӷ�Ϊn��1�ĸ�����;
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
