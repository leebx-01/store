package com.leebx.service;

import com.leebx.mapper.UserMapper;
import com.leebx.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String username, String password) {
        if(userMapper.login(username,password)!=null){
            return userMapper.login(username,password);
        }else {
            return null;
        }
    }

    @Override
    public void register(User user) {
        userMapper.register(user);
    }

    @Override
    public void updateState(String state, Long id) {
        userMapper.updateState(state,id);
    }
}
