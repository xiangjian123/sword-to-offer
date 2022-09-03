package com.company.normal;

import java.util.Stack;

public class P_Stack_With_Calculator {
    public static void main(String[] args) {
        String[] arr = {"21", "+", "3", "-", "5", "*", "8"};
    }

    public int calculator(String[] arr) {

        Stack<Integer> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();

        for (String str : arr) {
            if (!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")) {
                s1.push(Integer.parseInt(str));
            } else {
                if (s2.isEmpty()) {
                    s2.push(str);
                } else {
                    String temp = s2.peek();
                    if (str.equals("+") || str.equals("-")) {
                        if (temp.equals("*") || temp.equals("/")) {


                            int t1 = s1.pop();
                            int t2 = s1.pop();


                        }
                    }
                }
            }
        }

        return 0;

    }

}

enum Operator {
    ADD("+", 1),
    REDUCE("-", 1),
    MULTI("*", 2),
    DIVIDE("/", 2);

    private final String operate;
    private final int priority;

    Operator(String operate, int priority) {
        this.operate = operate;
        this.priority = priority;
    }

    public String getOperate() {
        return operate;
    }

    public int getPriority() {
        return priority;
    }
}
