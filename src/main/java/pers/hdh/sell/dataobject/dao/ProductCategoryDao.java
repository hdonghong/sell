package pers.hdh.sell.dataobject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import pers.hdh.sell.dataobject.mapper.ProductCategoryMapper;

import java.util.Map;

/**
 * ProductCategoryDao class<br/>
 * 封装mapper，只作演示
 * @author hdonghong
 * @date 2018/04/12
 */
public class ProductCategoryDao {

    @Autowired
    ProductCategoryMapper mapper;

    int insertByMap(Map<String, Object> map) {
        return mapper.insertByMap(map);
    }

}
