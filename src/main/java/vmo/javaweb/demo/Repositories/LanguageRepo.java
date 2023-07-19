package vmo.javaweb.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import vmo.javaweb.demo.Models.Language;

public interface LanguageRepo extends JpaRepository<Language, Integer> {
}
