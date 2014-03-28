package com.bulutmf.datastructures;


public class LinkedList<T> implements DataStructureOperations<T> {
	
	private Node<T> head;
	private int size = 0;
	
	public LinkedList() {
		
	}
	
	@Override
	public void insert(T element) {
		if (size == 0) {
			head = new Node<T>();
			head.value = element;
			head.next = null;
		} else {
			Node<T> cur = head;
			while(cur.next != null) {
				cur = cur.next;
			}
			
			Node<T> newNode = new Node<T>();
			newNode.value = element;
			newNode.next = null;
			cur.next = newNode;
		}
		size++;
	}

	@Override
	public void delete(T element) {
		Node<T> cur = head;
		Node<T> prev = null;
		boolean found = false;
		while(cur != null) {
			if (cur.value.equals(element)) {
				// Found it
				found = true;
				break;
			}
			
			prev = cur;
			cur = cur.next;
		}
		
		if (found) {
			if (prev != null) {
				prev.next = cur.next;
				cur = null;
			} else {
				if (size == 1) {
					head = null;
				} else {
					head = cur.next;
					cur = null;
				}
			}
			
			size--;
		}
	}

	public Node<T> find(T element) {
		Node<T> cur = head;
		while (cur != null) {
			if (cur.value.equals(element))
				return cur;
			cur = cur.next;
		}
		return null;
	}
	
	public String toString() {
		String result = "";
		Node<T> cur = head;
		while(cur != null) {
			if (cur.next == null)
				result += cur.value + "";
			else
				result += cur.value + ", ";
			
			cur = cur.next;
		}
		
		return result;
	}
	
	private static class Node<S> {
		public S value;
		public Node<S> next;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.insert(5);
		ll.insert(3);
		System.out.println(ll.toString());
		ll.delete(3);
		System.out.println(ll.toString());
		ll.delete(5);
		System.out.println(ll.toString());
		ll.insert(100);
		ll.insert(300);
		ll.insert(120);
		System.out.println(ll.toString());
		Node<Integer> node = ll.find(100);
		System.out.println(node.value);
		
	}

}
