package vmo.javaweb.demo.Services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import org.springframework.stereotype.Service;
import vmo.javaweb.demo.Models.Assignment;

import java.util.List;

@Service
public class AssignmentService {
    @PersistenceContext
    protected EntityManager entityManager;

    public List<Assignment> AssignmentOfFresher (int fresher_id){
        Table tbl = Assignment.class.getAnnotation(Table.class);
        List<Assignment> list = entityManager.createNativeQuery("SELECT * FROM assignment WHERE fresher_id = " + fresher_id ,Assignment.class).getResultList();
        return list;
    }

}
