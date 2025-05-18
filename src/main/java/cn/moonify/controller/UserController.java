package cn.moonify.controller;

import cn.moonify.pojo.Result;
import cn.moonify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username, String password){
        // 查询用户
        String u = userService.findByUserName(username);
                if(u == null){
                    // 用户不存在，注册
                    userService.register(username, password);
                    return Result.success();
                }else{
                    // 用户已存在，返回失败
                    return Result.error("用户已存在");
                }



    }
}
