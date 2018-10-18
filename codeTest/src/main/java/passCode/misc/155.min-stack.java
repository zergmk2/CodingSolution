import javafx.util.Pair;

import java.util.ArrayList;

/*
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (32.67%)
 * Total Accepted:    210.1K
 * Total Submissions: 643.3K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * 
 * 
 * pop() -- Removes the element on top of the stack.
 * 
 * 
 * top() -- Get the top element.
 * 
 * 
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 * 
 */
class MinStack {

    private ArrayList<Pair<Integer,Integer>> repository;

    private int minimumIndex = 0;
    private int size = 0;

    /** initialize your data structure here. */
    public MinStack() {
        repository = new ArrayList<>();
    }
    
    public void push(int x) {
        if (size == 0)
        {
            repository.add(new Pair<>(x, 0));
            minimumIndex = 0;
            size = 1;
        }
        else
        {
            repository.add(new Pair<>(x, minimumIndex));
            size++;
            if (x < repository.get(minimumIndex).getKey())
            {
                minimumIndex = size - 1;
            }
        }
    }
    
    public void pop() {
        if (size >= 0)
        {
            minimumIndex = repository.get(size - 1).getValue();
            repository.remove(size-1);
            size --;
        }
    }
    
    public int top() {
        return repository.get(size - 1).getKey();
    }
    
    public int getMin() {
        return repository.get(minimumIndex).getKey();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
