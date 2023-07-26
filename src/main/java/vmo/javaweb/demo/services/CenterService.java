package vmo.javaweb.demo.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vmo.javaweb.demo.exception_handler.exceptions.CenterNotFound;
import vmo.javaweb.demo.models.entity.Center;
import vmo.javaweb.demo.models.entity.FresherOfCenter;
import vmo.javaweb.demo.repositories.CenterRepo;
import vmo.javaweb.demo.repositories.FresherOfCenterRepo;
import vmo.javaweb.demo.repositories.FresherRepo;

import java.util.List;

@Service
public class CenterService {
    @PersistenceContext
    protected EntityManager entityManager;
    @Autowired
    FresherOfCenterRepo fresherOfCenterRepo;
    @Autowired
    FresherRepo fresherRepo;
    @Autowired
    CenterRepo centerRepo;
    public FresherOfCenter addToTheCenter(FresherOfCenter fresherOfCenter){
        return fresherOfCenterRepo.save(fresherOfCenter);
    }
    public List<Center> getAll(){
        return centerRepo.findAll();
    }
    public Center fillById(int id){
        return centerRepo.findById(id).orElseThrow(()->new CenterNotFound("center not found with id : " + id));
    }

    public Center add_center(Center center){
        return centerRepo.save(center);
    }
    public void delete_center(Center center){
        centerRepo.delete(center);
    }
    public Center fillByName(String name){
        List<Center> centers = entityManager.createNativeQuery("SELECT * FROM center WHERE name = " + name, Center.class).getResultList();
        return centers.get(0);
    } // Không được

    public Boolean checkByName(String name){
        List<Center> centers = centerRepo.findAll();
        for (Center center : centers){
            if(center.getName().toUpperCase().equals(name.toUpperCase())){
                return false;
            }
        }
        return true;
    } // được nhưng hơi mất time

    public List<FresherOfCenter> countFresher(int id){
        List<FresherOfCenter> fresherOfCenters = entityManager.createNativeQuery("SELECT * FROM fresher_of_center WHERE center_id = " + id , FresherOfCenter.class).getResultList();
        return fresherOfCenters;
    }
}