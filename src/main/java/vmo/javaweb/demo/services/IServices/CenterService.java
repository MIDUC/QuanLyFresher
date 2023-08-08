package vmo.javaweb.demo.services.IServices;

import vmo.javaweb.demo.models.entity.Center;

import java.util.List;

public interface CenterService {
    public abstract void save(Center center);
    public abstract void deleteById(Integer id);
    public abstract void update(Integer id, Center center);
    public abstract List<Center> findAll();
    public abstract Boolean checkByName(String name);
    public abstract Center findById(Integer id);
}
