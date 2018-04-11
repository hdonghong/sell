package pers.hdh.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * WeixinController class<br/>
 * 因为有了WechatController，故被淘汰<br/>
 * @author hdonghong
 * @date 2018/04/05
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
@Deprecated
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("进入auth方法");
        log.info("code={}", code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxa8c24bb0b6a0cdad&secret=d8779ad92a513f530146dc355b73c59c&code=" +
                code +"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
    }
}
