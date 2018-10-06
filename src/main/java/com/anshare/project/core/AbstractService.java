package com.anshare.project.core;


import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
public abstract class AbstractService<T> implements Service<T> {

    @Autowired
    protected Mapper<T> mapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public void save(T model,boolean setGuid) {

        Field field = null;
        try {




            if(setGuid)
            {

                field = modelClass.getDeclaredField("id");
                field.setAccessible(true);
                String mid = UUID.randomUUID().toString();

                field.set(model,mid);

            }



            Field field2 = modelClass.getDeclaredField("timestamp");
            field2.setAccessible(true);
            Timestamp ts=new Timestamp(new Date().getTime());
            field2.set(model, ts);


            Field field3 = modelClass.getDeclaredField("isdeleted");
            field3.setAccessible(true);
            field3.set(model, false);


        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }



        mapper.insertSelective(model);
    }

    public void save(List<T> models) {

        for(T model:models){

            Field field = null;
            try {
                field = modelClass.getDeclaredField("id");
                field.setAccessible(true);
                String mid = UUID.randomUUID().toString();
                field.set(model, mid);


                Field field2 = modelClass.getDeclaredField("timestamp");
                field2.setAccessible(true);
                Timestamp ts=new Timestamp(new Date().getTime());
                field2.set(model, ts);


                Field field3 = modelClass.getDeclaredField("isdeleted");
                field3.setAccessible(true);
                field3.set(model, false);



            } catch (ReflectiveOperationException e) {
                throw new ServiceException(e.getMessage(), e);
            }

        }




        mapper.insertList(models);
    }

    public void deleteById(String id) {

        try {
            T model = findById(id);
            Field field = modelClass.getDeclaredField("isdeleted");
            field.setAccessible(true);
            boolean flag = true;
            field.set(model, flag);


            Field field2 = modelClass.getDeclaredField("timestamp");
            field2.setAccessible(true);
            Timestamp ts=new Timestamp(new Date().getTime());
            field2.set(model, ts);


             mapper.updateByPrimaryKeySelective(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }


        //mapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }


    public void deleteByCondition(Condition con) {
        mapper.deleteByCondition(con);
    }


    public void update(T model) {

        try {
            Field field2 = modelClass.getDeclaredField("timestamp");
            field2.setAccessible(true);
            Timestamp ts=new Timestamp(new Date().getTime());
            field2.set(model, ts);



            mapper.updateByPrimaryKeySelective(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }



        mapper.updateByPrimaryKeySelective(model);
    }

    public T findById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<T> findByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    public List<T> findByCondition(Condition condition) {
        return mapper.selectByCondition(condition);
    }

    public List<T> findAll() {


        Condition condition = new Condition(modelClass);
        condition.createCriteria()
                .andEqualTo("isdeleted",false);
        return findByCondition(condition);
    }
}
