package com.imooc.controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @GetMapping("/list")
    public ResultVO buyProduct(){
        ResultVO resultVO = new ResultVO();
        ProductVO productVO = new ProductVO();
        ProductInfoVO productInfoVO = new ProductInfoVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        productVO.setCategoryName("热卖");
        productVO.setCategoryType(1);
        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
        resultVO.setProductVOList(Arrays.asList(productVO));
        return resultVO;
    }
}
