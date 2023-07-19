package vmo.javaweb.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vmo.javaweb.demo.Models.Fresher;

public interface FresherRepo extends JpaRepository<Fresher , Integer> {
}
