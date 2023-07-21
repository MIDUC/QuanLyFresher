package vmo.javaweb.demo.Services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vmo.javaweb.demo.Models.Assignment;
import vmo.javaweb.demo.Repositories.AssignmentRepo;

import java.util.List;

@Service
public class AssignmentService {
    @PersistenceContext
    protected EntityManager entityManager;
    @Autowired
    AssignmentRepo assignmentRepo;

    public List<Assignment> AssignmentOfFresher (int fresher_id){
        Table tbl = Assignment.class.getAnnotation(Table.class);
        List<Assignment> list = entityManager.createNativeQuery("SELECT * FROM assignment WHERE fresher_id = " + fresher_id ,Assignment.class).getResultList();
        return list;
    }

    public Assignment save_agm (Assignment assignment){
        return assignmentRepo.save(assignment);
    }

    public void delete_agm(int id){
        assignmentRepo.delete(entityManager.find(Assignment.class,id));
    }

}
