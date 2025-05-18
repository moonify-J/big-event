package cn.moonify.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String findByUserName(String username);

    void register(String username, String password);
}
