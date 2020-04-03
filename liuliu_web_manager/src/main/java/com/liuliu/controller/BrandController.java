package com.liuliu.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.liuliu.entity.ResponseData;
import com.liuliu.goods.IBrandService;
import com.liuliu.pojo.Brand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goods")
@Api(tags = "商品品牌管理接口")
public class BrandController {

    @Reference
    private IBrandService brandService;

    @RequestMapping(value = "/brandList", method = RequestMethod.GET)
    @ApiOperation(value = "品牌列表", notes = "获取所有的品牌信息")
    public ResponseData<Brand> branList() {
        List<Brand> brands = brandService.brandList();
        if (brands != null) {
            return ResponseData.success().putDataValue("brandList", brands);
        }
        return ResponseData.serverInternalError();
    }

    @RequestMapping(value = "/brandQuery", method = RequestMethod.POST)
    @ApiOperation(value = "条件查询品牌列表", notes = "根据用户条件来查询品牌信息")
    @ApiImplicitParam(value = "查询条件", name = "queryMap", required = false, dataType = "Map", paramType = "body")
    public ResponseData<Brand> brandListQuery(@RequestBody Map<String, Object> queryMap) {
        List<Brand> brandList = brandService.brandListByCondition(queryMap);
        if (brandList != null) {
            return ResponseData.success().putDataValue("brandList", brandList);
        }
        return ResponseData.serverInternalError();
    }

    @RequestMapping(value = "/brandPage", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询", notes = "根据页数和每页数据的数量来查询所有品牌")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页数", name = "pageNum", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(value = "每页的数据个数", name = "pageSize", required = true, dataType = "Integer", paramType = "query")
    })
    public ResponseData<Brand> brandPage(Integer pageNum, Integer pageSize) {
        IPage<Brand> brandPage = brandService.brandPage(pageNum, pageSize);
        return ResponseData.success().putDataValue("total", brandPage.getTotal())
                .putDataValue("pages", brandPage.getPages())
                .putDataValue("brandList", brandPage.getRecords());
    }

    @RequestMapping(value = "/pageQuery", method = RequestMethod.POST)
    @ApiOperation(value = "按条件的分页查询", notes = "根据页数以及每页数据量和查询条件查询品牌信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页数", name = "pageNum", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(value = "每一页的数据个数", name = "pageSize", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(value = "查询条件", name = "queryMap", required = false, dataType = "Map", paramType = "body")
    })
    public ResponseData<Brand> brandPageQuery(Integer pageNum, Integer pageSize, @RequestBody Map<String, Object> queryMap) {
        IPage<Brand> page = brandService.brandPageByCondition(pageNum, pageSize, queryMap);
        return ResponseData.success().putDataValue("total", page.getTotal())
                .putDataValue("pages", page.getPages())
                .putDataValue("brandList", page.getRecords());
    }
}
