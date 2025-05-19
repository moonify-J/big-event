package cn.moonify.controller;

import cn.moonify.pojo.Result;
import cn.moonify.pojo.User;
import cn.moonify.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username,@Pattern(regexp = "^\\S{5,16}$") String password) {
        // 查询用户
        User u = userService.findByUserName(username);
        if (u == null) {
            // 用户不存在，注册
            userService.register(username, password);
            return Result.success();
        } else {
            // 用户已存在，返回失败
            return Result.error("用户已存在");
        }


    }

    @Autowired
    private UserService userService;
}
