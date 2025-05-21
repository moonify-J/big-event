package cn.moonify.service;

import cn.moonify.pojo.User;
import jakarta.validation.constraints.Pattern;

public interface UserService {
    User findByUserName(String username);

    void register(String username, String password);

}
