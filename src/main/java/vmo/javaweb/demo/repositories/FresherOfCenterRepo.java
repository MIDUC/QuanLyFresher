package vmo.javaweb.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vmo.javaweb.demo.models.entity.FresherOfCenter;

public interface FresherOfCenterRepo extends JpaRepository<FresherOfCenter,Integer> {
}
