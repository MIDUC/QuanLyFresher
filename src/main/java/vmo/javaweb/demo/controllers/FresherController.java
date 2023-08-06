package vmo.javaweb.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vmo.javaweb.demo.models.entity.Fresher;
import vmo.javaweb.demo.services.FresherServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/freshers") // thêm v1,v2...
public class FresherController {
    @Autowired
    FresherServiceImpl service;
    @GetMapping("")
    public List<Fresher> getAllFresher(){
        return service.findAll();
    }

    @GetMapping("/size")
    public int Count_fresher(){
        List<Fresher> list = service.findAll();
        return list.size();
    }
    @GetMapping("/{id}")
    public Fresher getFresher(@PathVariable int id){
        return service.findById(id);
    }

    @PostMapping("")
    public String Add_fresher(@RequestBody Fresher fresher){
        System.out.println("Dang add");
        if(true){
            service.save(fresher);
            System.out.println("Add thanh cong");
        } else {
            service.save(fresher);
        }
        return null;
    }

    @PutMapping("/{id}")
    public String Update_fresher(@PathVariable int id , @RequestBody Fresher f){
        service.update(id,f);
        return null;
    }

    @DeleteMapping("/{id}")
    public String Delete_fresher(@PathVariable int id ){

        service.deleteById(id);
        return "Thành công";
    }

    @GetMapping("?name={key}")
    public List<Fresher> SearchByName(@PathVariable String key ){
        List<Fresher> list = service.findAll();
        List<Fresher> list_search = new ArrayList<>() ;
        for (Fresher f : list){
            if(f.getName().toUpperCase().contains(key.toUpperCase())){
                list_search.add(f);
            }
        }
        return list_search;
    }

}
