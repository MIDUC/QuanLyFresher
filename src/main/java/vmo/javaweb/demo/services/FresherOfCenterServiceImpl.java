package vmo.javaweb.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vmo.javaweb.demo.base.IBaseService;
import vmo.javaweb.demo.exception_handler.exceptions.ServiceNotFound;
import vmo.javaweb.demo.models.entity.FresherOfCenter;
import vmo.javaweb.demo.repositories.FresherOfCenterRepo;
import java.util.List;
@Service
public class FresherOfCenterServiceImpl implements IBaseService<FresherOfCenter> {
    @Autowired
    private FresherOfCenterRepo fresherOfCenterRepo;

    @Override
    public FresherOfCenter save(FresherOfCenter model) {
        return fresherOfCenterRepo.save(model);
    }

    @Override
    public void save(List<FresherOfCenter> models) {

    }

    @Override
    public void deleteById(Integer id) {
        fresherOfCenterRepo.deleteById(id);
    }

    @Override
    public void deleteByIds(String ids) {

    }

    @Override
    public void update(Integer id, FresherOfCenter model) {

    }

    @Override
    public FresherOfCenter findById(Integer id) {
        return fresherOfCenterRepo.findById(id).orElseThrow(()->new ServiceNotFound("fresher is not in the center "));
    }

    @Override
    public FresherOfCenter findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public List<FresherOfCenter> findByIds(String ids) {
        return null;
    }

    @Override
    public List<FresherOfCenter> findAll() {
        return fresherOfCenterRepo.findAll();
    }
}
