package pers.hdh.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * SellerInfo class<br/>
 * 卖家信息
 * @author hdonghong
 * @date 2018/04/10
 */
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
