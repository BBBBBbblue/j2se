package com.blue.DAO;

import com.blue.pojo.Category;
import com.blue.pojo.Property;
import com.blue.pojo.PropertyValue;

import java.util.List;

/**
 * @author blue
 * @date 2023/4/1 15:57
 **/
public interface PropertyValueDAO {

    /** 添加属性值方法
     * @param bean 商品实例
     * @return 是否成功
     */
    boolean add(PropertyValue bean);

    /** 更新属性值方法
     * @param bean 属性实例
     * @return 更新是否成功
     */
    boolean update(PropertyValue bean);

    /** 删除属性值方法
     * @param id 商品id
     * @return 删除是否成功
     */
    boolean delete(Integer id);

    /** 获取属性方法
     * @param pid 商品id
     * @param id 属性id
     * @return 返回获取的属性
     */
    PropertyValue get(Integer pid,Integer id);

}
