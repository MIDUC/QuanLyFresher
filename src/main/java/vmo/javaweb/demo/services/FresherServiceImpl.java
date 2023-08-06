package vmo.javaweb.demo.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vmo.javaweb.demo.base.IBaseService;
import vmo.javaweb.demo.exception_handler.exceptions.ServiceNotFound;
import vmo.javaweb.demo.models.entity.Assignment;
import vmo.javaweb.demo.models.entity.Fresher;
import vmo.javaweb.demo.models.entity.Language;
import vmo.javaweb.demo.repositories.FresherRepo;

import java.util.List;

@Service
public class FresherServiceImpl implements IBaseService<Fresher> {
    @Autowired
    FresherRepo fresherRepo;

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Fresher save(Fresher model) {
        return fresherRepo.save(model);
    }

    @Override
    public void save(List<Fresher> models) {
        fresherRepo.saveAll(models);
    }

    @Override
    public void deleteById(Integer id) {
        fresherRepo.deleteById(id);
    }

    @Override
    public void deleteByIds(String ids) {
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
        return fresherRepo.findById(id).orElseThrow(()-> new ServiceNotFound("fresher not found with id : " + id));
    }

    @Override
    public Fresher findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public List<Fresher> findByIds(String ids) {
        return null;
    }

    @Override
    public List<Fresher> findAll() {
        return fresherRepo.findAll();
    }

    public List<Assignment> AssignmentOfFresher (int fresher_id){
        List<Assignment> list = entityManager.createNativeQuery("SELECT * FROM assignment WHERE fresher_id = " + fresher_id ,Assignment.class).getResultList();
        return list;
    }

    public float AvgPoint (int fresher_id){
        float avg_point = 0;
        List<Assignment> assignmentList = AssignmentOfFresher(fresher_id);
        if(assignmentList.size()>0){
            for (Assignment a : assignmentList){
                avg_point += a.getPoint();
            }
            avg_point = avg_point/assignmentList.size();
        }
        return avg_point;
    }

    public List<Language> languages (int fresher_id){
        List<Language> list = entityManager.createNativeQuery("SELECT * FROM language WHERE fresher_id = " + fresher_id , Language.class).getResultList();
        return list;
    }
}
