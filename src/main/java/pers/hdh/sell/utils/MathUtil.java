package pers.hdh.sell.utils;

/**
 * MathUtil class<br/>
 *
 * @author hdonghong
 * @date 2018/04/07
 */
public class MathUtil {

    public static final Double MONEY_RANGE = 0.01;

    public static Boolean equals(Double d1, Double d2) {
        return Math.abs(d1 - d2) < MONEY_RANGE;
    }
}
