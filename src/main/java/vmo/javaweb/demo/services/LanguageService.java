package vmo.javaweb.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vmo.javaweb.demo.models.entity.Language;
import vmo.javaweb.demo.repositories.LanguageRepo;

@Service
public class LanguageService {
    @Autowired
    LanguageRepo languageRepo;

    public Language save_language(Language language){
        return languageRepo.save(language);
    }
}
