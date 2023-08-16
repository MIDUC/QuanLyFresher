package vmo.javaweb.demo.services.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vmo.javaweb.demo.exception_handler.exceptions.ServiceNotFound;
import vmo.javaweb.demo.models.entity.Center;
import vmo.javaweb.demo.models.entity.Fresher;
import vmo.javaweb.demo.models.entity.FresherOfCenter;
import vmo.javaweb.demo.repositories.CenterRepo;
import vmo.javaweb.demo.services.IServices.CenterService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CenterServiceImpl implements CenterService {
    @Autowired
    private CenterRepo centerRepo;
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void save(Center model) {
        centerRepo.save(model);
    }

    @Override
    public void deleteById(Integer id) {
        centerRepo.deleteById(id);
    }


    @Override
    public void update(Integer id, Center model) {
        Center f = findById(id);
        f.setName(model.getName());
        f.setAddress(model.getAddress());
        f.setStatus(model.getStatus());
        centerRepo.save(f);
    }


    @Override
    public Center findById(Integer id) {
        return centerRepo.findById(id).orElseThrow(()-> new ServiceNotFound("center not found with id : " + id));
    }

    @Override
    public List<Integer> findByIdFresher(Integer id) {
//        List<FresherOfCenter> fresherOfCenterList =entityManager
//                .createNativeQuery("SELECT * FROM fresher_of_center WHERE fresher_of_center.center_id = " + id , FresherOfCenter.class)
//                .getResultList();
//        List<Integer> centerIds = new ArrayList<>();
//        for (FresherOfCenter fresherOfCenter : fresherOfCenterList){
//            centerIds.add(fresherOfCenter.getCenter_id());
//        }
//        return centerIds;
        return null;
    }

    @Override
    public List<Integer> findFresherById(Integer id) {
        List<FresherOfCenter> fresherOfCenterList =entityManager.createNativeQuery("SELECT * FROM fresher_of_center WHERE fresher_of_center.center_id = " + id , FresherOfCenter.class).getResultList();
        List<Integer> fresherIdList = new ArrayList<>();
        for (FresherOfCenter fresherOfCenter : fresherOfCenterList){
            fresherIdList.add(fresherOfCenter.getFresher_id());
        }
        return fresherIdList;
    }

    @Override
    public List<Center> findAll() {
        return centerRepo.findAll();
    }

    public Boolean checkByName(String name){
        List<Center> centers = centerRepo.findAll();
        for (Center center : centers){
            if(center.getName().toUpperCase().equals(name.toUpperCase())){
                return false;
            }
        }
        return true;
    } // được nhưng hơi mất time
}
