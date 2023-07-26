package vmo.javaweb.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import vmo.javaweb.demo.models.entity.Language;

public interface LanguageRepo extends JpaRepository<Language, Integer> {
}
