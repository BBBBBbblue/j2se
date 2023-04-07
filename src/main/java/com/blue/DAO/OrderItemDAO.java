package com.blue.DAO;


import com.blue.pojo.Order;
import com.blue.pojo.OrderItem;
import com.blue.pojo.User;


import java.util.List;

/**
 * @author blue
 * @date 2023/4/1 16:19
 **/
public interface OrderItemDAO {
    /**获取用户购物车方法
     * @param bean 用户实例
     * @return 购物车详情集合
     */
    List<OrderItem> getCarts(User bean);

    /** 添加订单详情方法
     * @param bean 订单详情实例
     * @return 是否成功
     */
    boolean add(OrderItem bean);

    /** 更新详情方法
     * @param bean 订单详情实例
     * @return 是否成功
     */
    boolean update(OrderItem bean);

    /** 删除详情方法
     * @param id 订单详情id
     * @return 是否成功
     */
    boolean delete(Integer id);

    /** 获取订单详情方法
     * @param id 订单详情id
     * @return 返回获取的订单详情
     */
    OrderItem get(Integer id);

    /** 返回所有订单详情方法
     * @param bean 订单实例
     * @return 所有订单详情集合
     */
    List<OrderItem> list(Order bean);

}
