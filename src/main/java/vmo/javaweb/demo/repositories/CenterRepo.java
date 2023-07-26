package vmo.javaweb.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vmo.javaweb.demo.models.entity.Center;

public interface CenterRepo extends JpaRepository<Center , Integer> {
}
