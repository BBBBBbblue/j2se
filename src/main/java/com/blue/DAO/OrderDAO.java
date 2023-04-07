package com.blue.DAO;

import com.blue.pojo.Category;
import com.blue.pojo.Order;
import com.blue.pojo.User;

import java.util.List;

/**
 * @author blue
 * @date 2023/4/1 16:03
 **/
public interface OrderDAO {
    /**获取用户订单总数方法
     * @param bean 用户实例
     * @return 数量
     */
    int getTotal(User bean);

    /** 添加订单方法
     * @param bean 订单
     * @return 是否成功
     */
    boolean add(Order bean);

    /** 更新订单方法
     * @param bean 分类实例
     * @return 是否成功
     */
    boolean update(Order bean);

    /** 删除订单方法
     * @param id 分类id
     * @return 是否成功
     */
    boolean delete(Integer id);

    /** 获取订单方法
     * @param id 订单id
     * @return 返回获取的订单
     */
    Order get(Integer id);

    /** 返回所有订单方法
     * @param bean 用户实例
     * @return 所有订单集合
     */
    List<Order> list(User bean);

    /** 分页查询方法
     * @param start limit开始处
     * @param count 结果数量
     * @param bean 用户实例
     * @return 分页查询结果集合
     */
    List<Order> list(User bean,int start,int count);
}
