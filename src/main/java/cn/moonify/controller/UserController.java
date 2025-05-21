package cn.moonify.controller;

import cn.moonify.Utils.JwtUtil;
import cn.moonify.pojo.Result;
import cn.moonify.pojo.User;
import cn.moonify.service.UserService;
import cn.moonify.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{3,16}$") String username, @Pattern(regexp = "^\\S{3,16}$") String password) {
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

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{3,16}$") String username, @Pattern(regexp = "^\\S{3,16}$") String password) {
        // 查询用户
        User loginUser = userService.findByUserName(username);
        if (loginUser == null) {
            return Result.error("用户不存在");
        }

        // 判断密码是否正确
        if (loginUser.getPassword().equals(Md5Util.getMD5String(password))) {
            // 创建token并返回
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        } else {
            // 密码错误
            return Result.error("密码错误");
        }

    }

}
