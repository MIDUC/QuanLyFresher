package vmo.javaweb.demo.Services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vmo.javaweb.demo.Models.Assignment;
import vmo.javaweb.demo.Models.Fresher;
import vmo.javaweb.demo.Models.Language;
import vmo.javaweb.demo.Repositories.FresherRepo;

import java.util.List;

@Service
public class FresherService {
    @PersistenceContext
    protected EntityManager entityManager;
    @Autowired
    FresherRepo repo;
    public List<Fresher> fillAll(){
        List<Fresher> list = repo.findAll();
        return list ;
    }

    public Fresher fillById(int id){
        Fresher fresher = entityManager.find(Fresher.class,id);
        return fresher;
    }

    public void save_fresher(Fresher fresher){
        repo.save(fresher);
    }

    public void delete_fresher (int id){
        repo.delete(repo.getById(id));
    }
    
    public List<Assignment> AssignmentOfFresher (int fresher_id){
        Table tbl = Assignment.class.getAnnotation(Table.class);
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
