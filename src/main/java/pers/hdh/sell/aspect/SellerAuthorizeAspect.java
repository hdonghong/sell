package pers.hdh.sell.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pers.hdh.sell.constants.CookieConstant;
import pers.hdh.sell.constants.RedisConstant;
import pers.hdh.sell.exception.SellerAuthorizaException;
import pers.hdh.sell.utils.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * SellerAuthorizeAspect class<br/>
 *
 * @author hdonghong
 * @date 2018/04/11
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * pers.hdh.sell.controller.Seller*.*(..))" +
            "&& !execution(public * pers.hdh.sell.controller.SellerUserController.*(..))")
    public void verify() {

    }

    @Before("verify()")
    public void doVerfiry() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("【登录校验】 Cookie查不到token");
            throw new SellerAuthorizaException();
        }

        // redis里查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_RREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("【登录校验】 Redis查不到token");
            throw new SellerAuthorizaException();
        }
    }

}
