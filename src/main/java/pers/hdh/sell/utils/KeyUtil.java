package pers.hdh.sell.utils;

import java.util.Random;

/**
 * KeyUtil class<br/>
 * 生成主键
 * @author hdonghong
 * @date 2018/04/04
 */
public class KeyUtil {

    public static synchronized String getUniqueKey() {
        Random random = new Random();
        int randomNo = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(randomNo);
    }
}
