package com.github.yafeiwang1240.algorithm;

import java.util.Stack;

/**
 * 最小值栈
 */

interface MinStack {

    Integer push(Integer item);
    Integer pop();
    Integer peek();
    boolean empty();
    Integer min();

}
public class DoubleStack implements MinStack {

    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();


    @Override
    public Integer push(Integer item) {
        if (item < minStack.peek()) {
            minStack.push(item);
        } else {
            minStack.push(minStack.peek());
        }
        return stack.push(item);
    }

    @Override
    public Integer pop() {
        minStack.pop();
        return stack.pop();
    }

    @Override
    public Integer peek() {
        return stack.peek();
    }

    @Override
    public boolean empty() {
        return stack.empty();
    }

    @Override
    public Integer min() {
        return minStack.peek();
    }
}
