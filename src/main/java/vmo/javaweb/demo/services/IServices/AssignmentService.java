package vmo.javaweb.demo.services.IServices;

import vmo.javaweb.demo.models.entity.Assignment;

public interface AssignmentService {
    public abstract void save(Assignment assignment);
    public abstract void deleteById(Integer id);
}
