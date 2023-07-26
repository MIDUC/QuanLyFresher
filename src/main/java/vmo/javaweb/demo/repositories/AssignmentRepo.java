package vmo.javaweb.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vmo.javaweb.demo.models.entity.Assignment;

public interface AssignmentRepo extends JpaRepository<Assignment, Integer> {

}
