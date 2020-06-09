package com.changgou.service.impl;

import com.changgou.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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

    @Override
    public void addNewBrand(Brand brand) {
        // selective == 忽略空值 只插入有值的column
        brandMapper.insertSelective(brand);
    }

    @Override
    public void updateBrand(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void deleteBrand(int id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Brand> findByRequirements(Brand brand) {

        Example example = createExample(brand);
        return brandMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Brand> findByPage(Integer page, Integer size) {
        // 分页 == 集合查询
        PageHelper.startPage(page, size);
        List<Brand> brandList = brandMapper.selectAll();
        return new PageInfo<Brand>(brandList);
    }

    @Override
    public PageInfo<Brand> findByRequirementsPage(Brand brand, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        Example example = createExample(brand);
        List<Brand> brandList = brandMapper.selectByExample(example);
        return new PageInfo<Brand>(brandList);

    }


    private Example createExample(Brand brand) {
        Example example = new Example(Brand.class);
        Example.Criteria criterion = example.createCriteria();// 条件构造器
        // name && first letter == null ?
        if (brand != null) {
            if (!StringUtils.isEmpty(brand.getName())) {
                criterion.andLike("name", "%" + brand.getName() + "%");
            } else if (!StringUtils.isEmpty(brand.getLetter())) {
                criterion.andEqualTo("letter", brand.getLetter());
            }
        }
        return example;
    }
}
