package pers.hdh.sell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * SellerUserController class<br/>
 * 卖家用户
 * @author hdonghong
 * @date 2018/04/10
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @GetMapping("/login")
    public void login(@RequestParam("openid") String openid) {

        // 1.openid和数据库的数据匹配
    }

}
