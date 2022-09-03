package com.company.swordoffer;

import java.util.Stack;

public class Stack_Push_Pop {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {4,5,3,2,1};

        System.out.println(validateStackSequences(arr1, arr2));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        if (len == 0) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < len; i++) {
            if (pushed[i] != popped[popIndex]) {
                stack.push(pushed[i]);
            } else {
                // try pop and continue
                popIndex++;
                int pre = stack.size() - 1;
                int index = popIndex;

                while (pre >= 0 && stack.peek() == popped[index]) {
                    stack.pop();
                    index++;
                    pre--;
                }

                popIndex = index;
            }
        }

        for (int i = popIndex; i < len; i++) {
            if (popped[i] != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}
