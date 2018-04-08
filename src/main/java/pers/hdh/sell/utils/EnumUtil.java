package pers.hdh.sell.utils;

import pers.hdh.sell.constants.CodeEnum;

/**
 * EnumUtil class<br/>
 *
 * @author hdonghong
 * @date 2018/04/08
 */
public class EnumUtil {

    /**
     * 通过code获取枚举类
     * @param code
     * @param enumClass
     * @param <T>
     * @return
     */
    public static <T extends CodeEnum<?>> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
