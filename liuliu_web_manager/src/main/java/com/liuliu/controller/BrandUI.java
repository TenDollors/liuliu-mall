package com.liuliu.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liuliu.goods.IBrandService;
import com.liuliu.pojo.Brand;

public class BrandUI {
    @Reference
    IBrandService brandService;

    public static void main(String[] args) {
        BrandUI brandUI = new BrandUI();
        Brand all = brandUI.getAll();
        System.out.println(all);
    }
    public Brand getAll() {
        System.out.println(brandService);
        Brand brand = brandService.brandById(1115);
        return brand;
    }
}
