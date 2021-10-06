package cn.hhx.algorithm.polandnotation;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 逆波兰表达式计算器
 *
 * @author hhxStellar
 * @date 2021/10/6-19:14
 */
public class PolandNotation {
    private ArrayList<String> strings;
    private int res;

    public void setListStr(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        ArrayList<String> strings = new ArrayList<>();
        for (String str : split) {
            strings.add(str);
        }
        this.strings = strings;
    }

    public void calculate() {
        Stack<String> stack = new Stack<>();
        for (String item : strings) {
            if (item.matches("\\d+")) {
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

    public int getRes() {
        return res;
    }
}
