package com.blue.Service.Impl;

import com.blue.DAO.Impl.UserDAOImpl;
import com.blue.DAO.UserDAO;
import com.blue.Service.UserService;
import com.blue.pojo.User;

/**
 * @author blue
 * @date 2023/4/3 9:42
 **/
public class UserServiceImpl implements UserService {
    public UserDAOImpl userDAO = new UserDAOImpl();
    @Override
    public boolean login(User user) {
        if (user.getName() == null || user.getPassword() == null){
            return false;
        }
        User confirm = userDAO.get(user);
        return confirm != null;
    }
}
