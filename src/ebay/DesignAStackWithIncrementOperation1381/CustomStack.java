package ebay.DesignAStackWithIncrementOperation1381;

import java.util.Stack;

public class CustomStack {
    int[] incre;
    int maxSize;
    Stack<Integer> stack;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        incre = new int[maxSize];
        stack = new Stack<>();
    }

    public void push(int x) {
        if(stack.size()==maxSize){
            return;
        }
        stack.push(x);
    }

    public int pop() {
        if(stack.size()==0){
            return -1;
        }

        int increValue = incre[stack.size()-1];
        incre[stack.size()-1] = 0;
        int result = stack.pop() + increValue;

        if(stack.size()!=0){
            incre[stack.size()-1] += increValue;
        }

        return result;
    }

    public void increment(int k, int val) {
        if(stack.size()==0){
            return;}
        int index = Math.min(stack.size()-1, k-1);
        incre[index] += val;
    }
}
