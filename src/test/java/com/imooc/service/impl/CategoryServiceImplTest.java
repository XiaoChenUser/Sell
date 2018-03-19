package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory = categoryServiceImpl.findOne(2);
        Assert.assertNotEquals("女生最爱",productCategory.getCategoryType());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> productCategoryList = categoryServiceImpl.findAll();
        Assert.assertTrue(productCategoryList.size()>0);
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategoryList = categoryServiceImpl.findByCategoryTypeIn(Arrays.asList(1,2,3));
        Assert.assertTrue(productCategoryList.size()>0);
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(4);
        productCategory.setCategoryName("精美小吃");
        ProductCategory result = categoryServiceImpl.save(productCategory);
        Assert.assertNotNull(result);
    }

}