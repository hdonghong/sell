package pers.hdh.sell.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.hdh.sell.constants.ProductStatusEnum;
import pers.hdh.sell.constants.ResultEnum;
import pers.hdh.sell.dao.ProductInfoRepository;
import pers.hdh.sell.dataobject.ProductInfo;
import pers.hdh.sell.dto.CartDto;
import pers.hdh.sell.exception.SellException;
import pers.hdh.sell.service.ProductInfoService;

import java.util.List;

/**
 * ProductInfoServiceImpl class<br/>
 *
 * @author hdonghong
 * @date 2018/04/03
 */
@Service
@Slf4j
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDto> cartDtoList) {
        cartDtoList.forEach(e -> {
            ProductInfo productInfo = productInfoRepository.findOne(e.getProductId());
            if (productInfo == null) {
                log.error("【加库存】 该商品不存在, productId={}", e.getProductId());
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            productInfo.setProductStock(
                    productInfo.getProductStock() + e.getProductQuantity());
            productInfoRepository.save(productInfo);
        });
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDto> cartDtoList) {
        cartDtoList.forEach(e -> {
            ProductInfo productInfo = productInfoRepository.findOne(e.getProductId());
            if (productInfo == null) {
                log.error("【减库存】 该商品不存在, productId={}", e.getProductId());
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            int currStock = productInfo.getProductStock() - e.getProductQuantity();
            if (currStock < 0) {
                log.error("【减库存】 商品\"超卖\"错误, productStock={}, productQuantity={}",
                        productInfo.getProductStock(), e.getProductQuantity());
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(currStock);
            productInfoRepository.save(productInfo);
        });
    }
}
