package pers.hdh.sell.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pers.hdh.sell.dataobject.ProductCategory;
import pers.hdh.sell.exception.SellException;
import pers.hdh.sell.form.CategoryForm;
import pers.hdh.sell.service.ProductCategoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * SellerCategoryController class<br/>
 * 卖家类目
 * @author hdonghong
 * @date 2018/04/09
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private ProductCategoryService categoryService;

    /**
     * 类目列表
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }

    /**
     * 展示
     * @param categoryId
     * @param map
     * @return
     */
    @GetMapping("index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Map<String, Object> map) {
        if (categoryId != null) {
            ProductCategory category = categoryService.findOne(categoryId);
            map.put("category", category);
        }
        return new ModelAndView("category/index", map);
    }

    /**
     * 新增/修改类目
     * @param map
     * @return
     */
    @PostMapping("save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }
        ProductCategory category = new ProductCategory();
        try {
            if (form.getCategoryId() != null) {
                category = categoryService.findOne(form.getCategoryId());
            }
            BeanUtils.copyProperties(form, category);
            categoryService.save(category);

            map.put("url", "/sell/seller/category/list");
            return new ModelAndView("common/success", map);

        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }
    }
}
