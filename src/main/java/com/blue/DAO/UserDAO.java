package com.blue.DAO;

import com.blue.pojo.User;

/**
 * @author blue
 * @date 2023/4/3 9:44
 **/
public interface UserDAO {
    /** 登录方法
     * @param user 用户实例
     * @return 返回用户实例
     */
    User get(User user);

    /** 用户注册
     * @param bean 用户实例
     * @return 判断布尔值
     */
    boolean register(User bean);
}
