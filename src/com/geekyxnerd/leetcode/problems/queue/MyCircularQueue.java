package com.geekyxnerd.leetcode.problems.queue;

/**
 * @author gautam
 * Created on 04-Apr-21 at 2:48 PM.
 */
public class MyCircularQueue {

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(8);
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(9));
        System.out.println(myCircularQueue.enQueue(5));
        System.out.println(myCircularQueue.enQueue(0));
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.isEmpty());
        System.out.println(myCircularQueue.isEmpty());
        System.out.println(myCircularQueue.isEmpty());
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.deQueue());
    }
    public ListNode front;
    public ListNode rear;
    public int capacity;
    public static int size;
    public MyCircularQueue(int k) {
        capacity = k;
    }

    public boolean enQueue(int value) {
        if(size >= capacity) return false;
        else {
            ListNode newNode = new ListNode(value);
            if(isEmpty()) {
                front = newNode;
                rear = newNode;
            }
            else if(rear != null){
                rear.next = newNode;
                newNode.prev = rear;
                rear = newNode;
            }
            size++;
        }
        return true;
    }

    public boolean deQueue() {
        if(size <= 0 || front == null) return false;
        else {
            ListNode temp = front.next;
            if (temp == null) {
                rear = null;
                front = null;
            } else {
                front.next = null;
                front = temp;
                front.prev = null;
            }
            size--;
        }
        return true;
    }

    public int Front() {
        if(front == null) {
            return -1;
        }
        else {
            return front.val;
        }
    }

    public int Rear() {
        if(rear == null) {
            return -1;
        }
        else {
            return rear.val;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}