package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("热狗");
        productInfo.setProductPrice(new BigDecimal(5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("热狗很好吃");
        productInfo.setProductIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=" +
                "1521390499118&di=b11e48fd5741b05c4987ff10b9a171be&imgtype=0&src=http%3A%2F%2Fimg.taopic." +
                "com%2Fuploads%2Fallimg%2F120210%2F2506-12021010054649.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(4);

        ProductInfo productInfo1 = productInfoRepository.save(productInfo);
        Assert.assertNotNull(productInfo1);
    }

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> productInfos = productInfoRepository.findByProductStatus(0);
        Assert.assertTrue(productInfos.size()>0);
    }

}