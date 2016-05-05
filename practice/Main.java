//最长递增子序列A
//Time Limit: 3000/2000 MS (Java/Others) Memory Limit: 65536/65536 K (Java/Others)
//Problem Description:
//给定一个长度为N的数组，找出一个最长的单调自增子序列（不一定连续，但是顺序不能乱）。
//例如：给定一个长度为8的数组A{ 1, 3, 5, 2, 4, 6, 7, 8 }，则其最长的单调递增子序列为{1, 2, 4, 6, 7, 8 }，长度为6。
//要求最好能过滤输入的合法性，即能够使用正则匹配输入内容，只允许输入数字、空格、-这些内容成为数组。

package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(7);
		list.add(8);
        boolean[][] vis = new boolean[list.size()][list.size()];
		int[][] res = new int[list.size()][list.size()];
		for(int i = 0; i < res.length; ++i){
			for(int j = 0; j < res[0].length; ++j){
				res[i][j] = 0;
			}
		}
		for(int i = 0; i < vis.length; ++i){
			for(int j = 0; j < vis[0].length; ++j){
				vis[i][j] = false;
			}
		}
		for(int i = 0; i < list.size() - 1; ++i){
            res[i][0] = list.get(i);
            vis[i][0] = true;
			for(int j = 0,k = i; j <= i;) {
				
                while(k > 0) {
                      if(vis[j][k] == true){
                            if(res[j][k] < list.get(i)) {
                                  res[j][k+1] = list.get(i);
                                  vis[j][k+1] = true;

                            }
                            break;
                      }else {
                          --k;                   	  
                      }
                }
                ++j;
          }
		}
		for(int i = 0; i < res.length; ++i) {
			if(list.get(list.size() - 1) > res[i][res[0].length - 2])
				res[i][res[0].length - 1] = list.get(list.size() - 1);
		}
		for(int i = 0; i < res.length; ++i){
			for(int j = 0; j < res[0].length; ++j) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}
}
