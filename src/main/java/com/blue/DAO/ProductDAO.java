package com.blue.DAO;

import com.blue.pojo.Category;
import com.blue.pojo.Product;

import java.util.List;

/**
 * @author blue
 * @date 2023/4/1 15:43
 **/
public interface ProductDAO {
    /**获取商品总数方法
     * @return 数量
     */
    int getTotal();

    /** 添加商品方法
     * @param bean 商品实例
     * @return 是否成功
     */
    boolean add(Product bean);

    /** 更新商品方法
     * @param bean 商品实例
     * @return 是否成功
     */
    boolean update(Product bean);

    /** 删除商品方法
     * @param id 商品id
     * @return 是否成功
     */
    boolean delete(Integer id);

    /** 获取商品方法
     * @param id 商品d
     * @return 返回获取的商品
     */
    Product get(Integer id);

    /** 返回所有商品方法
     * @param id 分类id
     * @return 所有商品集合
     */
    List<Product> list(Integer id);

    /** 分页查询方法
     * @param start limit开始处
     * @param count 结果数量
     * @return 分页查询结果集合
     */
    List<Product> list(int start,int count);
}
