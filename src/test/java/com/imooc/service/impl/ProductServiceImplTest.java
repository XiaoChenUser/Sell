package com.imooc.service.impl;

import com.imooc.Enums.ProductStatusEnum;
import com.imooc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productService.findOne("123456");
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void findAll() throws Exception {
        List<ProductInfo> productInfos = productService.findAll(ProductStatusEnum.UP.getCode());
        Assert.assertTrue(productInfos.size()>0);
    }

    @Test
    public void findAll1() throws Exception {
        PageRequest pageRequest = PageRequest.of(0,5);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
        System.out.println(productInfoPage.getTotalElements());
        Assert.assertTrue(productInfoPage.getTotalPages()>0);
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(5));
        productInfo.setProductStock(0);
        productInfo.setProductDescription("皮皮虾很好吃");
        productInfo.setProductIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=" +
                "1521390499118&di=b11e48fd5741b05c4987ff10b9a171be&imgtype=0&src=http%3A%2F%2Fimg.taopic." +
                "com%2Fuploads%2Fallimg%2F120210%2F2506-12021010054649.jpg");
        productInfo.setProductStatus(1);
        productInfo.setCategoryType(4);

        ProductInfo productInfo1 = productService.save(productInfo);
        Assert.assertTrue(productInfo.getProductId()==productInfo1.getProductId());
    }

}