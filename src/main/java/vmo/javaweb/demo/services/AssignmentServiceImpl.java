package vmo.javaweb.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vmo.javaweb.demo.base.IBaseService;
import vmo.javaweb.demo.models.entity.Assignment;
import vmo.javaweb.demo.repositories.AssignmentRepo;

import java.util.List;


@Service
public class AssignmentServiceImpl implements IBaseService<Assignment> {
    @Autowired
    AssignmentRepo assignmentRepo;
    @Override
    public Assignment save(Assignment model) {
        return assignmentRepo.save(model);
    }

    @Override
    public void save(List<Assignment> models) {

    }

    @Override
    public void deleteById(Integer id) {
        assignmentRepo.deleteById(id);
    }

    @Override
    public void deleteByIds(String ids) {

    }

    @Override
    public void update(Integer id, Assignment model) {

    }

    @Override
    public Assignment findById(Integer id) {
        return null;
    }

    @Override
    public Assignment findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public List<Assignment> findByIds(String ids) {
        return null;
    }

    @Override
    public List<Assignment> findAll() {
        return null;
    }
}
