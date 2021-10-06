package cn.hhx.algorithm.polandnotation;

import org.junit.Test;

/**
 * @author hhxStellar
 * @date 2021/10/6-19:47
 */
public class TestPoland {
    @Test
    public void test1() {
        String suffixExp = "4 5 * 8 - 60 + 8 2 / +";
        PolandNotation polandCal = new PolandNotation();
        polandCal.setListStr(suffixExp);
        polandCal.calculate();
        int res = polandCal.getRes();
        System.out.println(res);
    }

}
