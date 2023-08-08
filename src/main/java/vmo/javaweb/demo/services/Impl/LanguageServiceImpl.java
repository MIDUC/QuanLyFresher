package vmo.javaweb.demo.services.Impl;
import org.springframework.stereotype.Service;
import vmo.javaweb.demo.models.entity.Language;
import vmo.javaweb.demo.repositories.LanguageRepo;
import vmo.javaweb.demo.services.IServices.LanguageService;

import java.util.*;

@Service
public class LanguageServiceImpl implements LanguageService {
    private LanguageRepo languageRepo;
    @Override
    public void save(Language language) {
        languageRepo.save(language);
    }

    @Override
    public void deleteById(Integer id) {
        languageRepo.deleteById(id);
    }


    @Override
    public void update(Integer id, Language model) {

    }

    @Override
    public List<Language> findAll() {
        return languageRepo.findAll();
    }
}
