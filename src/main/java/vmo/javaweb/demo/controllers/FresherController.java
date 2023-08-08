package vmo.javaweb.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vmo.javaweb.demo.models.entity.Fresher;
import vmo.javaweb.demo.services.IServices.FresherService;
import java.util.List;

@RestController
@RequestMapping("/api/freshers") // thêm v1,v2...
public class FresherController {
    @Autowired
    FresherService fresherService;
    @GetMapping("")
    public List<Fresher> getAllFresher(){
        return fresherService.findAll();
    }

    @GetMapping("/size")
    public int Count_fresher(){
        List<Fresher> list = fresherService.findAll();
        System.out.println(list.size());
        return list.size();
    }
    @GetMapping("/{id}")
    public Fresher Get_one_fresher(@PathVariable int id){
        return fresherService.findById(id);
    }

    @PostMapping("")
    public String Add_fresher(@RequestBody Fresher fresher){
        fresherService.save(fresher);
        return null;
    }

    @PutMapping("/{id}")
    public String Update_fresher(@PathVariable int id , @RequestBody Fresher f){
        fresherService.update(id,f);
        return null;
    }

    @DeleteMapping("/{id}")
    public String Delete_fresher(@PathVariable int id ){
        fresherService.deleteById(id);
        return "Thành công";
    }

    @GetMapping("/name/{key}")
    public List<Fresher> SearchByName(@PathVariable String key ){
        List<Fresher> list_search = fresherService.findByName(key);
        return list_search;
    }

    @GetMapping("/gmail/{key}")
    public List<Fresher> SearchByGmail(@PathVariable String key ){
        List<Fresher> list_search = fresherService.findByEmail(key);
        return list_search;
    }
    @GetMapping("/language/{key}")
    public List<Fresher> SearchByLanguage(@PathVariable String key ){
        List<Fresher> list_search = fresherService.findByLanguage(key);
        return list_search;
    }

}
