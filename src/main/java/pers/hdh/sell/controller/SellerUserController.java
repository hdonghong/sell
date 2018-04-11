package pers.hdh.sell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pers.hdh.sell.config.ProjectUrlConfig;
import pers.hdh.sell.constants.CookieConstant;
import pers.hdh.sell.constants.RedisConstant;
import pers.hdh.sell.constants.ResultEnum;
import pers.hdh.sell.dataobject.SellerInfo;
import pers.hdh.sell.service.SellerService;
import pers.hdh.sell.utils.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * SellerUserController class<br/>
 * 卖家用户
 * @author hdonghong
 * @date 2018/04/10
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              Map<String, Object> map,
                              HttpServletResponse response) {

        // 1.openid和数据库的数据匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        if (sellerInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMsg());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        // 2.设置token至redis
        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_RREFIX, token), openid, RedisConstant.EXPIRE, TimeUnit.SECONDS);

        // 3.设置token至cookie
        Cookie cookie = CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);

        return new ModelAndView("redirect:" + projectUrlConfig.getSell() +"/sell/seller/order/list");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletResponse response,
                       HttpServletRequest request,
                       Map<String, Object> map) {
        // 1.从cookie中查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null) {
            // 2.清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_RREFIX, cookie.getValue()));

            // 3.清除cookie
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }
        map.put("msg", ResultEnum.LOGIN_SUCCESS.getMsg());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }

}
