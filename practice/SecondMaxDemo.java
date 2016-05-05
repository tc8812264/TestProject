package practice;

public class SecondMaxDemo {
	public static int FindMax(int[] data) {
		int count = data.length;
		int max = data[0];
		int sec_max = Integer.MIN_VALUE;
		for(int i = 0; i < count; ++i) {
			if(data[i] > max) {
				sec_max = max;
				max = data[i]; 
			}else if(data[i] > sec_max) {
				sec_max = data[i];
			}
		}
		return sec_max;
	}
	public static void main(String[] args) {
		int[] a = {1,4,7,3,19,43,7,4,28};
		System.out.println(FindMax(a));
	}
}
