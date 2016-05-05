package practice;

import java.util.Hashtable;

public class NodeDemo {
	public static void main(String[] args){
		MyLinkedList list = new MyLinkedList();
		list.addNode(1);
		list.addNode(3);
		list.addNode(3);
		list.addNode(5);
		System.out.println(list.length());
		list.deleteDuplicate(list.head);
		list.printList();
	}
}
class Node{
	Node next = null;
	int data;
	public Node(int data) {
		this.data = data;
	}
}
class MyLinkedList{
	Node head = null;
	public void addNode(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		Node tmp = head;
		while(tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = newNode;
	}
	public int length() {
		int length = 0;
		Node tmp = head;
		while(tmp != null) {
			length++;
			tmp = tmp.next;
		}
		return length;
	}
	public boolean deleteNode(int index) {
		if(index < 0|| index > length() - 1) return false;
/*		if(index == 0) {
			head = head.next;
			return true;
		}*/
		int i = 0;
		Node preNode = head;
		Node curNode = preNode.next;
		while(curNode != null) {
			if(i == index) {
				preNode.next = curNode.next;
				return true;
			}
			preNode = curNode;
			curNode = curNode.next;
			++i;
		}
		return true;
	}
	public void deleteDuplicate(Node head) {
		Node pre = null;
		Node tmp = head;
		Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
		while(tmp != null) {
			if(table.containsKey(tmp.data)) {
				pre.next = tmp.next;
			}else {
				table.put(tmp.data, 1);
				pre = tmp;
			}
			tmp = tmp.next;
		}
	}
	
	public void printList() {
		Node tmp = head;
		while(tmp != null) {
			System.out.print(tmp.data+" ");
			tmp = tmp.next;
		}
	}
}
