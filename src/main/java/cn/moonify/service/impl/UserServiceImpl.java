package cn.moonify.service.impl;

import cn.moonify.Utils.Md5Util;
import cn.moonify.mapper.UserMapper;
import cn.moonify.pojo.User;
import cn.moonify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserMapper mapper;

    public UserServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public User findByUserName(String username) {
        return mapper.findByUserName(username);
    }

    @Override
    public void register(String username, String password) {
        String md5String = Md5Util.getMD5String(password);
        if(findByUserName(username) == null) {
            mapper.add(username, md5String);
        }

    }
}
