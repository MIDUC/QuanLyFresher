package vmo.javaweb.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vmo.javaweb.demo.models.entity.Assignment;
import vmo.javaweb.demo.models.entity.Fresher;
import vmo.javaweb.demo.models.entity.Language;
import vmo.javaweb.demo.services.FresherService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/fresher")
public class FresherController {
    @Autowired
    FresherService service;
    @GetMapping("")
    public List<Fresher> getAllFresher(){
        return service.fillAll();
    }

    @GetMapping("/count")
    public int Count_fresher(){
        List<Fresher> list = service.fillAll();
        return list.size();
    }
    @GetMapping("/{id}")
    public Fresher getFresher(@PathVariable int id){
        return service.fillById(id);
    }

//    @GetMapping("/info_fresher/{id}")
//    public String getInfo_Fresher(@PathVariable int id){
//        String mess ;
//        Fresher fresher = service.fillById(id);
//        float point = service.AvgPoint(id);
//        List<Assignment> assignmentList = service.AssignmentOfFresher(id);
//        List<Language> languageList = service.languages(id);
//        mess = fresher.toString() + "\n" + languageList.toString() +"\n"+ point + "\n" + assignmentList.toString();
//        return mess;
//    }


    @PostMapping("")
    public String Add_fresher(@RequestBody Fresher fresher){
        System.out.println("Dang add");
        if(true){
            service.save_fresher(fresher);
            System.out.println("Add thanh cong");
        } else {
            service.save_fresher(fresher);
        }
        String mess = "Thêm fresher " + fresher.getName() + " thành công";
        return mess;
    }

    @PutMapping("/{id}")
    public String Update_fresher(@PathVariable int id , @RequestBody Fresher f){
        Fresher Update_fresher = service.fillById(id);
        Update_fresher.setName(f.getName());
        Update_fresher.setGmail(f.getGmail());
        Update_fresher.setStatus(f.getStatus());
        service.save_fresher(Update_fresher);
        String mess = "Sửa fresher " + Update_fresher.getName() + " thành công";
        return mess;
    }


    @DeleteMapping("/{id}")
    public String Delete_fresher(@PathVariable int id ){
        String mess = "Xóa fresher " + service.fillAll().get(id).getName() + " thành công";
        service.delete_fresher(id);
        return mess;
    }

    @GetMapping("/search/{key}")
    public List<Fresher> Search_fresher(@PathVariable String key ){
        List<Fresher> list = service.fillAll();
        List<Fresher> list_search = new ArrayList<>() ;
        for (Fresher f : list){
            if(f.getName().toUpperCase().contains(key.toUpperCase()) || f.getGmail().toUpperCase().equals(key.toUpperCase())){
                list_search.add(f);
            }
        }
        return list_search;
    }

}

//{
//        "id": 1,
//        "status": 1,
//        "name": "Doan Minh Duc",
//        "language": "Java",
//        "gmail": "Duc1234@gmail.com",
//        "point": 10.0
//        },
//        {
//        "id": 2,
//        "status": 0,
//        "name": "Đoàn Nguyễn B",
//        "language": "ReactJS",
//        "gmail": "NguyenB21@gmail.com",
//        "point": 6.0
//        },
//        {
//        "id": 3,
//        "status": 0,
//        "name": "Nguyễn Văn A #",
//        "language": "ReactJS",
//        "gmail": "Duc2961@gmail.com",
//        "point": 5.0
//        }