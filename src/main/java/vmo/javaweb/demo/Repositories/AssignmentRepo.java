package vmo.javaweb.demo.Repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import vmo.javaweb.demo.Models.Assignment;

public interface AssignmentRepo extends JpaRepository<Assignment, Integer> {

}
