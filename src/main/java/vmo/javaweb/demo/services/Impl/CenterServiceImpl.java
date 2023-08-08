package vmo.javaweb.demo.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vmo.javaweb.demo.exception_handler.exceptions.ServiceNotFound;
import vmo.javaweb.demo.models.entity.Center;
import vmo.javaweb.demo.repositories.CenterRepo;
import vmo.javaweb.demo.services.IServices.CenterService;

import java.util.List;

@Service
public class CenterServiceImpl implements CenterService {
    @Autowired
    private CenterRepo centerRepo;

    @Override
    public void save(Center model) {
        centerRepo.save(model);
    }

    @Override
    public void deleteById(Integer id) {
        centerRepo.deleteById(id);
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
