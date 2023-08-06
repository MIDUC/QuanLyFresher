package vmo.javaweb.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vmo.javaweb.demo.base.IBaseService;
import vmo.javaweb.demo.exception_handler.exceptions.ServiceNotFound;
import vmo.javaweb.demo.models.entity.Center;
import vmo.javaweb.demo.repositories.CenterRepo;

import java.util.List;

@Service
public class CenterServiceImpl implements IBaseService<Center> {
    @Autowired
    private CenterRepo centerRepo;

    @Override
    public Center save(Center model) {
        return centerRepo.save(model);
    }

    @Override
    public void save(List<Center> models) {

    }

    @Override
    public void deleteById(Integer id) {
        centerRepo.deleteById(id);
    }

    @Override
    public void deleteByIds(String ids) {

    }

    @Override
    public void update(Integer id, Center model) {
        Center f = findById(id);
        f.setName(model.getName());
        f.setAddress(model.getAddress());
        f.setStatus(model.getStatus());
        centerRepo.save(f);
    }


    @Override
    public Center findById(Integer id) {
        return centerRepo.findById(id).orElseThrow(()-> new ServiceNotFound("center not found with id : " + id));
    }

    @Override
    public Center findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public List<Center> findByIds(String ids) {
        return null;
    }

    @Override
    public List<Center> findAll() {
        return centerRepo.findAll();
    }

    public Boolean checkByName(String name){
        List<Center> centers = centerRepo.findAll();
        for (Center center : centers){
            if(center.getName().toUpperCase().equals(name.toUpperCase())){
                return false;
            }
        }
        return true;
    } // được nhưng hơi mất time
}
