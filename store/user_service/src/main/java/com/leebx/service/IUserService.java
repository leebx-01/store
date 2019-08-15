package com.leebx.service;

import com.leebx.pojo.User;

public interface IUserService {
    public User login(String username, String password);
    public void register(User user);
    public void updateState(String state,Long id);
}
