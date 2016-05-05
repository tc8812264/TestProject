package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CardsGameDemo {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("�����˿��Ƴɹ���");
		ArrayList<Card> cards = new ArrayList<Card>(52);
		for(int i = 1; i <= 4; ++i){
			for(int j = 1; j <= 13; ++j){
				cards.add(new Card(i,j));
			}
		}
		System.out.println(cards.toString());
		System.out.println("-----------------��ʼϴ�ƣ�-------------");
		Collections.shuffle(cards);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------------ϴ�ƽ�����-------------");
		System.out.println("-----------------�������..-------------");
		System.out.println("�������һλ��ҵ�ID��������");
		int id;
		String name;
		while (true) {
			System.out.println("������ID��");
			try{
				id=in.nextInt();		
			}catch(Exception e){
				System.out.println("���������ʽ����������������");	
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

		System.out.println("����������");
		name = in.next();
		Gamer first = new Gamer(id,name);
		System.out.println("������ڶ�λ��ҵ�ID��������");
		while (true) {
			System.out.println("������ID��");
			try{
				id=in.nextInt(); 
			}catch(Exception e){
				System.out.println("���������ʽ����������������");	
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

		System.out.println("����������");
		name = in.next();
		Gamer second = new Gamer(id,name);
		System.out.println("��ʼ���ƣ�");
		System.out.println(first.name+"����");
		first.hands[0] = cards.get(0);
		System.out.println(second.name+"����");
		second.hands[0] = cards.get(1);
		System.out.println(first.name+"����");
		first.hands[1] = cards.get(2);
		System.out.println(second.name+"����");		
		second.hands[1] = cards.get(3);
		System.out.println("���ƽ�����");
		System.out.println("��ʼ��Ϸ...");
		String firstmaxhands = findMaxHands(first).toString();
		String secondmaxhands = findMaxHands(second).toString();
	//�ҵ���ҵ�������� ;
		System.out.println("��ң�"+first.name+"���������Ϊ��"+firstmaxhands);
		System.out.println("��ң�"+second.name+"���������Ϊ��"+secondmaxhands);
		if(FindWinner(first,second)){
			System.out.println("-----------------��� "+first.name+"��ʤ��-------------");
		}else {
			System.out.println("-----------------��� "+second.name+"��ʤ��-------------");
		}
		System.out.println("��Ҹ��Ե�����Ϊ��");
		System.out.println(first.name+"��"+first.handsEcho());
		System.out.println(second.name+"��"+second.handsEcho());
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
		}//�ҵ���ҵ�������� ;
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
	int color;//1.���� 2.÷�� 3.���� 4.����
	int number; //1 = 2; 2 = 3....A =13
	public Card(int color,int number) {
		this.color = color;
		this.number = number;
	}
	public String toString(){
		String realcolor = "";
		String realnumber = "";
		switch(this.color){
			case 1: realcolor = "����";break;
			case 2: realcolor = "÷��";break;
			case 3: realcolor = "����";break;
			case 4: realcolor = "����";break;
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
	String name;//����
	Card[] hands = new Card[2];// ����
	public Gamer(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public String handsEcho(){
		return hands[0].toString()+" "+hands[1].toString();
	}
}