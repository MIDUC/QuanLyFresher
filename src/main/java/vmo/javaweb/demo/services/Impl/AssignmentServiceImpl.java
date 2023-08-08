package vmo.javaweb.demo.services.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vmo.javaweb.demo.models.entity.Assignment;
import vmo.javaweb.demo.repositories.AssignmentRepo;
import vmo.javaweb.demo.services.IServices.AssignmentService;


@Service
public class AssignmentServiceImpl implements AssignmentService {
    @Autowired
    AssignmentRepo assignmentRepo;
    @Override
    public void save(Assignment assignment) {
         assignmentRepo.save(assignment);
    }
    @Override
    public void deleteById(Integer id) {
        assignmentRepo.deleteById(id);
    }

}
