package Easy;

import java.util.*;

public class MyStack {
    //one Queue solution
    private Queue<Integer> q = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
        for(int i = 1; i < q.size(); i ++) { //rotate the queue to make the tail be the head
            q.add(q.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}


//class MyStack:
//        def __init__(self):
//        self._queue = collections.deque()
//
//        def push(self, x):
//        q = self._queue
//        q.append(x)
//        for _ in range(len(q) - 1):
//        q.append(q.popleft())
//
//        def pop(self):
//        return self._queue.popleft()
//
//        def top(self):
//        return self._queue[0]
//
//        def empty(self):
//        return not len(self._queue)
