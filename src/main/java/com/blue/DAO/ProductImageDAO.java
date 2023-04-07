package com.blue.DAO;

import com.blue.pojo.*;

import java.util.List;

/**
 * @author blue
 * @date 2023/4/1 16:11
 **/
public interface ProductImageDAO {
    /** 添加图片方法
     * @param bean 照片实例
     * @return 是否成功
     */
    boolean add(ProductImage bean);

    /** 更新图片方法
     * @param bean 图片实例
     * @return 更新是否成功
     */
    boolean update(ProductImage bean);

    /** 删除图片方法
     * @param id 图片id
     * @return 删除是否成功
     */
    boolean delete(Integer id);

    /** 获取图片方法
     * @param id 图片id
     * @return 返回获取的图片
     */
    ProductImage get(Integer id);

    /** 返回商品所有图片方法
     * @param bean 商品实例
     * @return 所有图片集合
     */
    List<ProductImage> list(Product bean);
}
