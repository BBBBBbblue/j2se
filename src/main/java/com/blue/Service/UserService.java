package com.blue.Service;

import com.blue.pojo.User;

/**
 * @author blue
 * @date 2023/4/3 9:41
 **/
public interface UserService {
    /**
     * @param user
     * @return
     */
    boolean login(User user);
}
