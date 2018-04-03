package pers.hdh.sell.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.hdh.sell.dataobject.ProductInfo;

import java.util.List;

/**
 * ProductInfoRepository interface<br/>
 * 商品
 * @author hdonghong
 * @date 2018/04/03
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
