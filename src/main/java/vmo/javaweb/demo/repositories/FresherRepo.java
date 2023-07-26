package vmo.javaweb.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vmo.javaweb.demo.models.entity.Fresher;

public interface FresherRepo extends JpaRepository<Fresher , Integer> {
}
