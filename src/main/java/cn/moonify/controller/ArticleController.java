package cn.moonify.controller;

import cn.moonify.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("list")
    public Result<String> list(){

        return Result.success("文章数据");
    }

}
