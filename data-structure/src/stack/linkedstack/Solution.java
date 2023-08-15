package stack.linkedstack;

import java.util.Stack;

class Solution {

    public boolean isValid(String s) {

        LinkedStack<Character> stack = new LinkedStack<Character>();
        int i = 0;
        for (i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    break;
                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    break;
                if (c == ']' && topChar != '[')
                    break;
                if (c == '}' && topChar != '{')
                    break;
            }
        }
        System.out.println(i);
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isValid("()[]{}"));
        System.out.println((new Solution()).isValid("([)]"));
    }
}
