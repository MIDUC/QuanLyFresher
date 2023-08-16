package vmo.javaweb.demo.services.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vmo.javaweb.demo.exception_handler.exceptions.ServiceNotFound;
import vmo.javaweb.demo.models.dto.FresherDto;
import vmo.javaweb.demo.models.entity.*;
import vmo.javaweb.demo.models.mapper.FresherMapper;
import vmo.javaweb.demo.repositories.CenterRepo;
import vmo.javaweb.demo.repositories.FresherRepo;
import vmo.javaweb.demo.services.IServices.FresherService;

import java.util.ArrayList;
import java.util.List;

@Service
public class FresherServiceImpl implements FresherService {
    @Autowired
    private FresherRepo fresherRepo;
    @Autowired
    private CenterRepo centerRepo;
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void save(Fresher model) {
        fresherRepo.save(model);
    }

    @Override
    public void deleteById(Integer id) {
        fresherRepo.deleteById(id);
    }

    @Override
    public void update(Integer id, Fresher model) {
        Fresher f = findById(id);
        f.setName(model.getName());
        f.setGmail(model.getGmail());
        f.setStatus(model.getStatus());
        fresherRepo.save(f);
    }

    @Override
    public Fresher findById(Integer id) {
        Fresher fresher = fresherRepo.findById(id).orElseThrow(()-> new ServiceNotFound("fresher not found with id : " + id));
        return fresher;
    }
    @Override
    public List<Fresher> findAll() {
        return fresherRepo.findAll();
    }

    @Override
    public Boolean checkByName(String name) {
        List<Fresher> list = fresherRepo.findAll();
        for (Fresher fresher : list){
            if(fresher.getName().toUpperCase().equals(name.toUpperCase())){
                return false;
            }
        }
        return true;
    }

    public List<Assignment> AssignmentOfFresher (Integer id){
        List<Assignment> list = entityManager.createNativeQuery("SELECT * FROM assignment WHERE fresher_id = " + id ,Assignment.class).getResultList();
        return list;
    }

    public float AvgPoint (Integer id){
        float avg_point = 0;
        List<Assignment> assignmentList = AssignmentOfFresher(id);
        if(assignmentList.size()>0){
            for (Assignment a : assignmentList){
                avg_point += a.getPoint();
            }
            avg_point = avg_point/assignmentList.size();
        }
        return avg_point;
    }

    public List<Language> languages (Integer id){
        List<Language> list = entityManager.createNativeQuery("SELECT * FROM language WHERE fresher_id = " + id , Language.class).getResultList();
        return list;
    }

    @Override
    public List<Fresher> findByName(String name) {
        List<Fresher> fresherList = entityManager
                .createNativeQuery("SELECT * FROM fresher f WHERE f.name like \"%"+ name +"%\"", Fresher.class)
                .getResultList();
        return fresherList;
    }

    @Override
    public List<Fresher> findByEmail(String email) {
        List<Fresher> fresherList = entityManager
                .createNativeQuery("SELECT * FROM fresher f WHERE f.gmail like \"%"+ email +"%\"",Fresher.class)
                .getResultList();
        return fresherList;
    }

    @Override
    public List<Integer> findCentersById(Integer id) {
        List<FresherOfCenter> fresherOfCenterList = entityManager
                .createNativeQuery("SELECT * FROM fresher_of_center WHERE fresher_of_center.center_id = " + id , FresherOfCenter.class)
                .getResultList();
        List<Integer> centerIds = new ArrayList<>();
        for (FresherOfCenter fresherOfCenter : fresherOfCenterList){
            centerIds.add(fresherOfCenter.getCenter_id());
        }
        return centerIds;
    }

    @Override
    public List<Fresher> findByLanguage(String language) {
        List<Fresher> fresherList = new ArrayList<>();
        List<Fresher> list = findAll();
        for (Fresher f : list){
            int c = 0 ;
            List<Language> languageList = languages(f.getId());
            for (Language l : languageList){
                if(l.getName().toUpperCase().equals(language.toUpperCase())){
                    c =  1;
                }
            }
            if(c == 1) {
                fresherList.add(f);
            }
        }
        return fresherList;
    }

    @Override
    public FresherDto findDtoById(Integer id) {
        Fresher fresher = findById(id);
        List<Integer> centerIds = findCentersById(id);
        List<Center> centers = new ArrayList<>();
        for (Integer i : centerIds){
            centers.add(centerRepo.findById(i).orElseThrow());
        }
        List<Language> languages = languages(id);
        FresherDto fresherDto = FresherMapper.toFresherDto(fresher,centers,languages,AvgPoint(id));
        return fresherDto;
    }
}
