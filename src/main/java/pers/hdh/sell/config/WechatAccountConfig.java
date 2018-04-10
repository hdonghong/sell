package pers.hdh.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * WeChatAccountConfig class<br/>
 * 微信公众号账户配置
 * @author hdonghong
 * @date 2018/04/05
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    /** 微信公众平台id */
    private String mpAppId;

    /** 微信公众平台密钥 */
    private String mpAppSecret;

    /** 微信开放平台id */
    private String openAppId;

    /** 微信开放平台密钥 */
    private String openAppSecret;

    /** 商户号 */
    private String mchId;

    /** 商户密钥 */
    private String mchKey;

    /** 商户证书路径 */
    private String keyPath;

    /** 微信支付异步通知地址，重要！*/
    private String notifyUrl;
}
