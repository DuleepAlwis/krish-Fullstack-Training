package com.tutorials;

import java.util.ArrayList;

public class SearchAlgo {

	public static void main(String [] args) {
		
		Graph gr = new Graph();
		System.out.println("Start");
		int [] arr = {3,2,1,5,6,7};
		
		for(int i=0;i<arr.length;i++) {
			gr.insert(arr[i]);
		}
		
		gr.printGraphBSF();
	}
}

class Node{
	
	Node left;
	Node right;
	int val;
	
	Node(int val){
		this.val = val;
	}
}

class Graph{
	
	Node root;
	
	public void insert(int val) {
		
		if(this.root==null) {
			this.root = new Node(val);
		}else {
			Node cur = this.root;
			while(cur!=null) {
				if(cur.val>val) {
					if(cur.left==null) {
						System.out.println("value is left "+val);
						cur.left = new Node(val);
						break;
					}
					cur = cur.left;
				}else if(cur.val<=val) {
					if(cur.right==null) {
						System.out.println("value is right "+val);

						cur.right = new Node(val);
						break;
					}
					cur = cur.right;
				}
			}
				
			
		}
	}
	
	public void printGraphBSF() {
		
		Node cur = this.root;
		
		ArrayList<Node> queue = new ArrayList<Node>();
		int pointer = 0;
		queue.add(cur);

		while(cur!=null) {
			
			if(pointer<queue.size()) {
				cur = queue.get(pointer++);

			}else {
				break;
			}
			
			System.out.println(cur.val);
			if(cur.left!=null) {
				queue.add(cur.left);
			}
			if(cur.right!=null) {
				queue.add(cur.right);
			}
		}
	}
	
	public void printGraphDFS() {
		
		int pointer = 0;
		ArrayList<Node> stack = new ArrayList<Node>();
		
		Node cur = this.root;
		
		while(cur!=null) {
			if(cur.left!=null) {
				cur = cur.left;
			}else {
				stack.add(cur);
				pointer++;
			}
			if(cur.right!=null) {
				cur = cur.right;
			}else {
				stack.add(cur);
				pointer++;
			}
		}
	}
}
