package cn.hhx.algorithm.polandnotation;

import org.junit.Test;

/**
 * @author hhxStellar
 * @date 2021/10/6-19:47
 */
public class TestPoland {
    @Test
    public void test1() {
        String suffixExp = "10 6 9 3 + -11 * / * 17 + 5 +";
        PolandNotation polandCal = new PolandNotation();
        polandCal.setListStr(suffixExp);
        polandCal.calculate();
        int res = polandCal.getRes();
        System.out.println(res);
    }

    @Test
    public void test2() {
//        String expression = "1 + ( ( 2 + 3 ) * 4 ) - 5 ";
        String expression = "( 3 + 4 ) * 5 - 8 / 2";
        PolandNotation polandNotation = new PolandNotation();
        polandNotation.parseToSuffixExp(expression);
        polandNotation.calculate();
        System.out.println(polandNotation.getRes());
    }

}
