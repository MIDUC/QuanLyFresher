package vmo.javaweb.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vmo.javaweb.demo.Models.Center;

public interface CenterRepo extends JpaRepository<Center , Integer> {
}
