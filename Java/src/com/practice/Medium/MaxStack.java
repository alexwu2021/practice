package com.practice.Medium;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class MaxStack {

    Stack<Integer> s;
    PriorityQueue<Integer> pq;

    public MaxStack() {
        s = new Stack<>();
        pq = new PriorityQueue<>(10000, Collections.reverseOrder());
    }

    public void push(int x) {
        s.push(x);
        pq.offer(x);
    }

    public int pop() {
        int pop = s.pop();
        pq.remove(pop);
        return pop;
    }

    public int top() {
        return s.peek();
    }

    public int peekMax() {
        return pq.peek();
    }

    public int popMax() {
        int max = pq.poll();
        Stack<Integer> sp = new Stack<>();
        while (!s.isEmpty()) {
            if (s.peek() != max) {
                sp.push(s.pop());
            } else {
                s.pop();
                break; // a must here, other wise we will have EmptyStackException
            }
        }
        while (!sp.isEmpty()) {
            s.push(sp.pop());
        }
        return max;
    }
}
