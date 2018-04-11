package pers.hdh.sell.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * CookieUtil class<br/>
 * cookie工具类
 * @author hdonghong
 * @date 2018/04/11
 */
public class CookieUtil {

    /**
     * 设置cookie
     * @param response
     * @param name
     * @param value
     * @param maxAge
     * @return
     */
    public static Cookie set(HttpServletResponse response,
                             String name,
                             String value,
                             Integer maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
        return cookie;
    }

    /**
     * 通过cookie名获取cookie
     * @param request
     * @param name
     * @return
     */
    public static Cookie get(HttpServletRequest request, String name) {
        return readCookieMap(request).get(name);
    }

    /**
     * 将本次请求中的cookie数组转成cookie Map
     * @param request
     * @return
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    public static void main(String[] args) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie cookie = cookieMap.get("1");
        System.out.println(cookie);
    }
}
