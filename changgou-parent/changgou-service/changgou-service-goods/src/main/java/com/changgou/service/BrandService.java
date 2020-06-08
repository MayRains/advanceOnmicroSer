package com.changgou.service;

import com.changgou.goods.pojo.Brand;

import java.util.List;

public interface BrandService {
    /*
    * find all brands*/
    List<Brand> findAll();
    /*
    * find brand by id*/
    Brand findById(int id);

}
