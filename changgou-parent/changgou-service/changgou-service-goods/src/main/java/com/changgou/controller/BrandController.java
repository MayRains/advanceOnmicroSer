package com.changgou.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/brand")
@CrossOrigin
public class BrandController {
    @Resource
    private BrandService brandService;

    @GetMapping
    public Result<List<Brand>> findAll(){
        List<Brand> brands = brandService.findAll();
        return new Result<List<Brand>>(true,StatusCode.OK,"查询品牌集合成功！",brands);
    }

    @GetMapping(value = "/{id}")
    public Result<Brand> findBrandById(@PathVariable(value = "id") int id){
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true,StatusCode.OK,"查询品牌成功！",brand);
        // {"flag":true,"code":20000,"message":"查询品牌成功！","data":{"id":1115,"name":"HTC","image":"","letter":"H","seq":null}}
    }
}
