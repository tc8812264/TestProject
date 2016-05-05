package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CardsGameDemo {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("创建扑克牌成功！");
		ArrayList<Card> cards = new ArrayList<Card>(52);
		for(int i = 1; i <= 4; ++i){
			for(int j = 1; j <= 13; ++j){
				cards.add(new Card(i,j));
			}
		}
		System.out.println(cards.toString());
		System.out.println("-----------------开始洗牌！-------------");
		Collections.shuffle(cards);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------------洗牌结束！-------------");
		System.out.println("-----------------创建玩家..-------------");
		System.out.println("请输入第一位玩家的ID和姓名：");
		int id;
		String name;
		while (true) {
			System.out.println("请输入ID：");
			try{
				id=in.nextInt();		
			}catch(Exception e){
				System.out.println("您的输入格式有误请输入整数！");	
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				continue;
			}
			break;
			} 

		System.out.println("输入姓名：");
		name = in.next();
		Gamer first = new Gamer(id,name);
		System.out.println("请输入第二位玩家的ID和姓名：");
		while (true) {
			System.out.println("请输入ID：");
			try{
				id=in.nextInt(); 
			}catch(Exception e){
				System.out.println("您的输入格式有误请输入整数！");	
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				continue;
			}
			break;
			} 

		System.out.println("输入姓名：");
		name = in.next();
		Gamer second = new Gamer(id,name);
		System.out.println("开始发牌！");
		System.out.println(first.name+"拿牌");
		first.hands[0] = cards.get(0);
		System.out.println(second.name+"拿牌");
		second.hands[0] = cards.get(1);
		System.out.println(first.name+"拿牌");
		first.hands[1] = cards.get(2);
		System.out.println(second.name+"拿牌");		
		second.hands[1] = cards.get(3);
		System.out.println("发牌结束！");
		System.out.println("开始游戏...");
		String firstmaxhands = findMaxHands(first).toString();
		String secondmaxhands = findMaxHands(second).toString();
	//找到玩家的最大手牌 ;
		System.out.println("玩家："+first.name+"的最大手牌为："+firstmaxhands);
		System.out.println("玩家："+second.name+"的最大手牌为："+secondmaxhands);
		if(FindWinner(first,second)){
			System.out.println("-----------------玩家 "+first.name+"获胜！-------------");
		}else {
			System.out.println("-----------------玩家 "+second.name+"获胜！-------------");
		}
		System.out.println("玩家各自的手牌为：");
		System.out.println(first.name+"："+first.handsEcho());
		System.out.println(second.name+"："+second.handsEcho());
	}
	public static Card findMaxHands(Gamer gamer){
		Card maxHands;
		if(gamer.hands[0].number > gamer.hands[1].number){
			maxHands = gamer.hands[0];
		}else if(gamer.hands[0].number < gamer.hands[1].number){
			maxHands = gamer.hands[1];
		}else {
			if(gamer.hands[0].color > gamer.hands[1].color){
				maxHands = gamer.hands[0];
			}else {
				maxHands = gamer.hands[1];
			}
		}//找到玩家的最大手牌 ;
		return maxHands;
	}
	public static boolean FindWinner(Gamer first, Gamer second){
		Card firstMaxCard = findMaxHands(first);
		Card secondMaxCard = findMaxHands(second);
		if(firstMaxCard.number > secondMaxCard.number){
			return true;
		}else if(firstMaxCard.number < secondMaxCard.number){
			return false;
		}else {
			if(firstMaxCard.color > secondMaxCard.color){
				return true;
			}else {
				return false;
			}
		}
	}
}
class Card{
	int color;//1.方块 2.梅花 3.红桃 4.黑桃
	int number; //1 = 2; 2 = 3....A =13
	public Card(int color,int number) {
		this.color = color;
		this.number = number;
	}
	public String toString(){
		String realcolor = "";
		String realnumber = "";
		switch(this.color){
			case 1: realcolor = "方块";break;
			case 2: realcolor = "梅花";break;
			case 3: realcolor = "红桃";break;
			case 4: realcolor = "黑桃";break;
		}
		switch(this.number) {
			case 1: realnumber = "2";break;
			case 2: realnumber = "3";break;
			case 3: realnumber = "4";break;
			case 4: realnumber = "5";break;
			case 5: realnumber = "6";break;
			case 6: realnumber = "7";break;
			case 7: realnumber = "8";break;
			case 8: realnumber = "9";break;
			case 9: realnumber = "10";break;
			case 10: realnumber = "J";break;
			case 11: realnumber = "Q";break;
			case 12: realnumber = "K";break;
			case 13: realnumber = "A";break;
		}
		return realcolor+""+realnumber;
	}
}
class Gamer{
	int id;//id
	String name;//姓名
	Card[] hands = new Card[2];// 手牌
	public Gamer(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public String handsEcho(){
		return hands[0].toString()+" "+hands[1].toString();
	}
}