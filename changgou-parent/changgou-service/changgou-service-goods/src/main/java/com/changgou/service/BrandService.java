package com.changgou.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BrandService {
    /*
    * find all brands*/
    List<Brand> findAll();
    /*
    * find brand by id*/
    Brand findById(int id);
    /*
    * add a brand*/
    void addNewBrand(Brand brand);
    /*
    * update brand*/
    void updateBrand(Brand brand);
    /*
    * delete brand*/
    void deleteBrand(int id);
    /*
    * 多条件查询
    * */
    List<Brand> findByRequirements(Brand brand);
    /*
    * 条件查询 + 分页{page 当前页+ size}
    * */
    PageInfo<Brand> findByPage(Integer page, Integer size);

    PageInfo<Brand> findByRequirementsPage(Brand brand,Integer page,Integer size);



}
