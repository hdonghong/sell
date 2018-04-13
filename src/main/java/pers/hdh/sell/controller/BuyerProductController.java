package pers.hdh.sell.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.hdh.sell.dataobject.ProductCategory;
import pers.hdh.sell.dataobject.ProductInfo;
import pers.hdh.sell.service.ProductCategoryService;
import pers.hdh.sell.service.ProductInfoService;
import pers.hdh.sell.utils.ResultVoUtil;
import pers.hdh.sell.vo.ProductInfoVo;
import pers.hdh.sell.vo.ProductVo;
import pers.hdh.sell.vo.ResultVo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BuyerProductController class<br/>
 * 买家商品
 * @author hdonghong
 * @date 2018/04/03
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService infoService;
    @Autowired
    private ProductCategoryService categoryService;

    @GetMapping("/list")
    @Cacheable(cacheNames = "product", key = "controller_123", unless = "#result.getCode() != 0")// 缓存存，key可通过方法参数值动态设置，格式：#参数名
    public ResultVo list() {
        // 1.查询所有商品
        List<ProductInfo> productInfoList = infoService.findUpAll();

        // 2.查询类目（一次性查询）
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(
                        productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList()));

        // 3.数据拼装
        List<ProductVo> productVoList = new ArrayList<>();
        productCategoryList.forEach(productCategory -> {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            productInfoList.forEach(productInfo -> {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    // spring提供的拷贝实体类属性的工具类
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            });
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        });

        return ResultVoUtil.success(productVoList);
    }
}
