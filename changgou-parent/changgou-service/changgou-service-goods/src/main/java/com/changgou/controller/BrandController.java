package com.changgou.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageInfo;
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

    @PostMapping
    public Result addNewBrand(@RequestBody Brand brand){
        brandService.addNewBrand(brand);
        return new Result(true,StatusCode.OK,"增加品牌成功！");
    }

    @PutMapping(value = "/{id}")
    public Result updateBrand(@PathVariable("id") int id,@RequestBody Brand brand){
        brand.setId(id);
        brandService.updateBrand(brand);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @DeleteMapping(value = "/{id}")
    public Result deleteBrand(@PathVariable(value = "id") Integer id){
        brandService.deleteBrand(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @PostMapping(value = "/search")
    public Result<List<Brand>> findByRequirements(@RequestBody Brand brand){
        List<Brand> brandList = brandService.findByRequirements(brand);
        return new Result<List<Brand>>(true,StatusCode.OK,"条件搜索查询",brandList);
    }

    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findByPage(@PathVariable Integer page, @PathVariable Integer size){
        PageInfo<Brand> pageInfo = brandService.findByPage(page, size);
        return new Result<PageInfo<Brand>>(true,StatusCode.OK,"分页查询成功",pageInfo);
    }

    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findByRequirementsPage(@RequestBody Brand brand,
                                                          @PathVariable Integer page,
                                                          @PathVariable Integer size){
        PageInfo<Brand> info = brandService.findByRequirementsPage(brand,page,size);
        return new Result<PageInfo<Brand>>(true,StatusCode.OK,"条件分页查询成功",info);

    }
}
