package vmo.javaweb.demo.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vmo.javaweb.demo.exception_handler.exceptions.ServiceNotFound;
import vmo.javaweb.demo.models.entity.Fresher;
import vmo.javaweb.demo.models.entity.FresherOfCenter;
import vmo.javaweb.demo.repositories.FresherOfCenterRepo;
import vmo.javaweb.demo.services.IServices.FresherOfCenterService;

import java.util.ArrayList;
import java.util.List;
@Service
public class FresherOfCenterServiceImpl implements FresherOfCenterService {
    @Autowired
    private FresherOfCenterRepo fresherOfCenterRepo;

    private FresherServiceImpl fresherService;

    @Override
    public void save(FresherOfCenter model) {
         fresherOfCenterRepo.save(model);
    }

    @Override
    public void deleteById(Integer id) {
        fresherOfCenterRepo.deleteById(id);
    }

    @Override
    public void update(Integer id, FresherOfCenter model) {

    }

    @Override
    public FresherOfCenter findById(Integer id) {
        return fresherOfCenterRepo.findById(id).orElseThrow(()->new ServiceNotFound("fresher is not in the center "));
    }

    @Override
    public List<FresherOfCenter> findAll() {
        return fresherOfCenterRepo.findAll();
    }

    @Override
    public List<Fresher> findByCenter(Integer id) {
        List<Fresher> fresherList = new ArrayList<>();
        List<FresherOfCenter> fresherOfCenterList = findAll();
        for (FresherOfCenter f : fresherOfCenterList){
            if (f.getCenter_id() == id){
                Fresher fresher = fresherService.findById(f.getFresher_id());
                fresherList.add(fresher);
            }
        }
        return fresherList;
    }
}
