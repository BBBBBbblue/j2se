package com.blue.DAO;

import com.blue.pojo.Category;

import java.util.List;

/**
 * @author blue
 * @date 2023/3/31 16:55
 **/
public interface CategoryDAO {
   /* 获取的所有分类实例，集合中的分类实例
    其products集合的引用都为空，需要额外调用其他方法绑定*/

    /**获取分类总数方法
     * @return 数量
     */
      int getTotal();

    /** 添加分类方法
     * @param bean 分类实例
     * @return 是否成功
     */
    boolean add(Category bean);

    /** 更新分类方法
     * @param bean 分类实例
     * @return 是否成功
     */
    boolean update(Category bean);

    /** 删除分类方法
     * @param id 分类id
     * @return 是否成功
     */
    boolean delete(Integer id);

    /** 获取分类方法
     * @param id 分类id
     * @return 返回获取的分类
     */
    Category get(Integer id);

    /** 返回所有分类方法
     * @return 所有分类集合
     */
    List<Category> list();

    /** 分页查询方法
     * @param start limit开始处
     * @param count 结果数量
     * @return 分页查询结果集合
     */
    List<Category> list(int start,int count);
}
