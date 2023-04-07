package com.blue.DAO;

import com.blue.pojo.Category;
import com.blue.pojo.Product;
import com.blue.pojo.Property;

import java.util.List;

/**
 * @author blue
 * @date 2023/4/1 15:48
 **/
public interface PropertyDAO {

    /**获取分类属性总数方法
     * @param bean 分类实例
     * @return 数量
     */
    int getTotal(Category bean);

    /** 添加属性方法
     * @param bean 商品实例
     * @return 是否成功
     */
    boolean add(Property bean);

    /** 更新属性方法
     * @param bean 属性实例
     * @return 更新是否成功
     */
    boolean update(Property bean);

    /** 删除属性方法
     * @param id 商品id
     * @return 删除是否成功
     */
    boolean delete(Integer id);

    /** 获取属性方法
     * @param id 属性id
     * @return 返回获取的属性
     */
    Property get(Integer id);

    /** 返回分类所有属性方法
     * @param bean 分类实例
     * @return 所有属性集合
     */
    List<Property> list(Category bean);

    /** 分页查询方法
     * @param start limit开始处
     * @param count 结果数量
     * @param id 分类id
     * @return 分页查询结果集合
     */
    List<Property> list(Integer id,int start,int count);
}
