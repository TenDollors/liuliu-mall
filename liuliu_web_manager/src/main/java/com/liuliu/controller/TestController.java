package com.liuliu.controller;


import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api("这是一个测试接口")
@ApiModel(value = "这是测试接口", description = "测试swagger接口文档")
public class TestController {
    @RequestMapping(value = "/api", method = RequestMethod.POST)
    // value是方法的用途、作用 notes是方法的备注说明
    // paramType： query表示参数使用@RequestParam来查找 path表示参数使用@PathVariable注解
    @ApiOperation(value = "接口方法测试", notes = "匹配用户名和密码")
    // 参数的说明 paramType
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", paramType = "query", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", paramType = "path", value = "密码", dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功")
    })
    public String testApi(String username, String password) {
        return null;
    }
}
