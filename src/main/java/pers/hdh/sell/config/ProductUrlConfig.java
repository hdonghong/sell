package pers.hdh.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ProductUrl class<br/>
 *
 * @author hdonghong
 * @date 2018/04/10
 */
@Data
@ConfigurationProperties(prefix = "projectUrl")
@Component
public class ProductUrlConfig {

    /** 微信公众平台授权url */
    public String wechatMpAuthorize;

    /** 微信开放平台授权url */
    public String wechatOpenAuthorize;

    /** 点餐系统 */
    public String sell;
}
