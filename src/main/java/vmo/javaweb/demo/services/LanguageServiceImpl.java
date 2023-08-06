package vmo.javaweb.demo.services;
import org.springframework.stereotype.Service;
import vmo.javaweb.demo.base.IBaseService;
import vmo.javaweb.demo.models.entity.Language;

import java.util.*;

@Service
public class LanguageServiceImpl implements IBaseService<Language> {
    @Override
    public Language save(Language model) {
        return null;
    }

    @Override
    public void save(List<Language> models) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByIds(String ids) {

    }

    @Override
    public void update(Integer id, Language model) {

    }


    @Override
    public Language findById(Integer id) {
        return null;
    }

    @Override
    public Language findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public List<Language> findByIds(String ids) {
        return null;
    }

    @Override
    public List<Language> findAll() {
        return null;
    }
}
