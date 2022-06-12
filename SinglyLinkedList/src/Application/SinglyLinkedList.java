package Application;

import java.util.ArrayList;

public class SinglyLinkedList {

	public static void main(String [] args) {
		LinkedList ll = new LinkedList();
		int[] arr = {10, 20, 30, 40};
		Stack st = new Stack();
		
		for(int i:arr) {
			//System.out.println(i);
			Node node = new Node(i,null);
			ll.insertVal(node);
			st.push(node);
		}
		
		System.out.println("Reversed using the prev variable");
		ll.reverseLinkedList();
		ll.printList();
		
		System.out.println("Reversed using stack");
		while(st.isEmpty()==false) {
			System.out.println(st.pop().val);
		}
		
		//Check whether a palindrome
		
		LinkedList ll_p = new LinkedList();
		String palindrome = "madam";
		for(int i = 0;i<palindrome.length();i++) {
			
			Node n = new Node(palindrome.charAt(i),null);
			ll_p.insertVal(n);
		}
		
		ll_p.reverseLinkedList();
		String reversedStr = ll_p.createString();
		System.out.println("palindrome : "+palindrome+" Reversed : "+reversedStr);
		System.out.println("Ispalindrome : "+palindrome.equalsIgnoreCase(reversedStr));

		
	}
	
	
}

class Node{
	
	Node next;
	int val;
	char c;
	
	Node(int val,Node next){
		this.val = val;
		this.next = next;
	}
	
	Node(char c,Node next){
		this.c = c;
		this.next = next;
	}
}
class LinkedList{
	
	Node root;
	
	public LinkedList() {
		
	}
	
	public void insertVal(Node val) {
		Node node = val;
		
		if(root==null) {
			root = node;
			System.out.println("Node added to the linked list {"+val.val+"}");

		}else {
			Node cur = root;
			while(cur.next!=null) {
				cur = cur.next;
			}
			cur.next = node;
			System.out.println("Node added to the linked list {"+val.val+"}");
		}
	}
	
	public void printList() {
		Node cur = root;
		while(cur!=null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
	
	public Node reverseLinkedList() {
		
		Node prev = null;
		Node current = root;
		Node next = null;
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		root = prev;
	        return root;
	}
	
	public String createString() {
		
		Node cur = this.root;
		String str = "";
		while(cur!=null) {
			str = str+cur.c;
			cur = cur.next;
		}
		
		return str;
	}
	
}

class Stack{
	
	public ArrayList<Node> stack = new ArrayList<Node>();
	public int pos = 0;
	
	public void push(Node node) {
		
		stack.add(node);
		pos++;
	}
	
	public Node pop() {
		Node node = stack.get(--pos);
		return node;
	}
	
	public boolean isEmpty() {
		if(pos==0) {
			return true;
		}else {
			return false;
		}
	}
}