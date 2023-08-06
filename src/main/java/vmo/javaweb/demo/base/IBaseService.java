package vmo.javaweb.demo.base;

import vmo.javaweb.demo.models.entity.Fresher;

import java.util.List;

public interface IBaseService<T> {
    T save(T model);
    void save(List<T> models);
    void deleteById(Integer id);
    void deleteByIds(String ids);// eg：ids -> “1,2,3,4”
    void update(Integer id ,T model);
    T findById(Integer id);
    T findBy(String fieldName, Object value);
    List<T> findByIds(String ids); //eg：ids -> “1,2,3,4”
    List<T> findAll();
}
