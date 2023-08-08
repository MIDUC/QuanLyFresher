package vmo.javaweb.demo.services.IServices;
import vmo.javaweb.demo.models.entity.Fresher;
import vmo.javaweb.demo.models.entity.FresherOfCenter;

import java.util.List;

public interface FresherOfCenterService {

    public abstract void save(FresherOfCenter fresherOfCenter);
    public abstract void deleteById(Integer id);
    public abstract void update(Integer id, FresherOfCenter fresherOfCenter);
    public abstract List<FresherOfCenter> findAll();
    public abstract FresherOfCenter findById(Integer id);
    public abstract List<Fresher> findByCenter (Integer id);
}
