package com.anshare.project.core;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 */
public interface Service<T> {
    void save(T model,boolean setGuid);
    // 保存  ps:
    // if (Guid=="") 则会自动生成一个Guid
    // else 则以传入的Guid为准


    void save(List<T> models);//batch批量保存
    void deleteById(String id);//通过主鍵刪除 (软删除，更新IsDeleted=1)
    void deleteByIds(String ids);//批量刪除 eg：ids -> “1,2,3,4”
    void deleteByCondition(Condition con);//真实删除(通过条件删除);
    void update(T model);//更新
    T findById(String id);//通过ID查找
    T findBy(String fieldName, Object value) throws TooManyResultsException; //通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
    List<T> findByIds(String ids);//通过多个ID查找//eg：ids -> “1,2,3,4”
    List<T> findByCondition(Condition condition);//根据条件查找
    List<T> findAll();//获取所有
}
