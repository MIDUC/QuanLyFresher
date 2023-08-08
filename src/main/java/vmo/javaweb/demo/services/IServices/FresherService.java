package vmo.javaweb.demo.services.IServices;

import vmo.javaweb.demo.models.entity.Assignment;
import vmo.javaweb.demo.models.entity.Fresher;
import vmo.javaweb.demo.models.entity.Language;

import java.util.List;

public interface FresherService {
    public abstract void save(Fresher fresher);
    public abstract void deleteById(Integer id);
    public abstract void update(Integer id, Fresher fresher);
    public abstract List<Fresher> findAll();
    public abstract Boolean checkByName(String name);
    public abstract Fresher findById(Integer id);
    public abstract List<Assignment> AssignmentOfFresher (Integer id);
    public abstract float AvgPoint (Integer id);
    public abstract List<Language> languages (Integer id);
    public abstract List<Fresher> findByName(String name);
    public abstract List<Fresher> findByEmail(String email);
    public abstract List<Fresher> findByLanguage(String language);

}
