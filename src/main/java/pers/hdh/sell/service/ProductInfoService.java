package pers.hdh.sell.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pers.hdh.sell.dataobject.ProductInfo;

import java.util.List;

/**
 * ProductInfoService interface<br/>
 * 商品
 * @author hdonghong
 * @date 2018/04/03
 */
public interface ProductInfoService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品
     * @return 所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 后台管理端的分页展示
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    // 加库存

    // 减库存
}
