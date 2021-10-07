package cn.hhx.algorithm2.polandnotation;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 逆波兰表达式计算器
 *
 * @author hhxStellar
 * @date 2021/10/6-19:14
 */
public class PolandNotation {
    private ArrayList<String> strings;//存放后缀表达式
    private int res;

    //直接存放后缀表达式
    public void setListStr(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        ArrayList<String> strings = new ArrayList<>();
        for (String str : split) {
            strings.add(str);
        }
        this.strings = strings;
    }

    //通过后缀表达式计算结果
    public void calculate() {
        Stack<String> stack = new Stack<>();
        for (String item : strings) {
            if (item.matches("(-)?\\d+")) {
                stack.push(item);
            } else {
                int num2 = Integer.valueOf(stack.pop());
                int num1 = Integer.valueOf(stack.pop());
                int result = 0;
                switch (item) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("运算符有错");
                }
                stack.push(String.valueOf(result));
            }
        }
        this.res = Integer.valueOf(stack.pop());
    }

    //将中缀表达式解析为后缀表达式,并存放到对象属性中
    public void parseToSuffixExp(String expression) {
        String[] s = expression.split(" ");
        Stack<String> resStack = new Stack<>();
        Stack<String> operStack = new Stack<>();
        for (String item : s) {
            if (item.matches("\\d")) {
                resStack.push(item);
            } else if ("(".equals(item)) {
                operStack.push(item);
            } else if (")".equals(item)) {
                while (!"(".equals(operStack.peek())) {
                    resStack.push(operStack.pop());
                }
                operStack.pop();
            } else {
                while (!operStack.isEmpty() && !"(".equals(operStack.peek()) && getPriority(item) <= getPriority(operStack.peek())) {
                    resStack.push(operStack.pop());
                }
                operStack.push(item);
            }
        }

        while (!operStack.isEmpty()) {
            resStack.push(operStack.pop());
        }

        strings = new ArrayList<>();

        while (!resStack.isEmpty()) {
            strings.add(0, resStack.pop());
        }
    }

    private int getPriority(String oper) {
        switch (oper) {
            case "+":
            case "-": {
                return 1;
            }
            case "*":
            case "/": {
                return 2;
            }
            default: {
                throw new RuntimeException("运算符不符合规律");
            }
        }
    }


    public int getRes() {
        return res;
    }
}
