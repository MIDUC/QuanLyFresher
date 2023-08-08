package vmo.javaweb.demo.services.IServices;

import vmo.javaweb.demo.models.entity.Language;

import java.util.List;

public interface LanguageService {
    public abstract void save(Language language);
    public abstract void deleteById(Integer id);
    public abstract void update(Integer id, Language language);
    public abstract List<Language> findAll();

}
