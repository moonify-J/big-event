package cn.moonify.service;

import cn.moonify.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

public interface UserService {
    User findByUserName(String username);

    void register(String username, String password);
}
