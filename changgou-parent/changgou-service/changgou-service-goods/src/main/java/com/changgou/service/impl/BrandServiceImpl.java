package com.changgou.service.impl;

import com.changgou.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandMapper brandMapper;
    @Override
    public List<Brand> findAll() {

        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(int id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}