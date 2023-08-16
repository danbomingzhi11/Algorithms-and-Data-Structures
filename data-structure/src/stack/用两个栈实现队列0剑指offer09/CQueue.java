package stack.用两个栈实现队列0剑指offer09;

import java.util.Stack;

class CQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public CQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        //不够优雅
//        if (stack2.size() == 0) {
//            if (stack1.size() == 0) {
//                return -1;
//            }
//            while (stack1.size() != 0) {
//                stack2.push(stack1.pop());
//            }
//        }
//        return stack2.pop();
        if (!outStack.isEmpty())
            return outStack.pop();
        else
            while (!inStack.isEmpty()) outStack.push(inStack.pop());
            return outStack.isEmpty() ? -1 : outStack.pop();
    }
}
