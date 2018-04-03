package pers.hdh.sell.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pers.hdh.sell.constants.ProductStatus;
import pers.hdh.sell.dao.ProductInfoRepository;
import pers.hdh.sell.dataobject.ProductInfo;
import pers.hdh.sell.service.ProductInfoService;

import java.util.List;

/**
 * ProductInfoServiceImpl class<br/>
 *
 * @author hdonghong
 * @date 2018/04/03
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatus.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }
}
