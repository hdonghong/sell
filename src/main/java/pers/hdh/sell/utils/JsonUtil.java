package pers.hdh.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * JsonUtil class<br/>
 *
 * @author hdonghong
 * @date 2018/04/07
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
