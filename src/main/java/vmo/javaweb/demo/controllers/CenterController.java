package vmo.javaweb.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vmo.javaweb.demo.models.entity.Center;
import vmo.javaweb.demo.models.entity.FresherOfCenter;
import vmo.javaweb.demo.services.IServices.CenterService;
import vmo.javaweb.demo.services.IServices.FresherOfCenterService;
import vmo.javaweb.demo.services.IServices.FresherService;
import java.util.List;

@RestController
@RequestMapping("/api/centers")
@CrossOrigin()
public class CenterController {
    @Autowired
    CenterService centerService;
    @Autowired
    FresherService fresherService;
    @Autowired
    FresherOfCenterService fresherOfCenterService;

    @GetMapping("")
    public List<Center> GetAllCenter(){
        return centerService.findAll();
    }
    @PostMapping("/fresher")
    public String AddFresherToCenter(@RequestBody FresherOfCenter fresherOfCenter){
        String mess = "No successful";
        fresherOfCenterService.save(fresherOfCenter);
        mess = "Đã thêm fresher " +
                fresherService.findById(fresherOfCenter.getFresher_id()).getName()
                + " vào trung tâm " + centerService.findById(fresherOfCenter.getCenter_id()).getName();
        return mess;
    }
    @PostMapping("")
    public String Add_Center(@RequestBody Center center){
        String mess;
        if(centerService.checkByName(center.getName()) == true){
            centerService.save(center);
            mess = "Thêm trung tâm " + center.getName() + " thành công";
        } else {
            mess = "Trung tâm đã tồn tại";
        }

        return mess;
    }
    @DeleteMapping("/{id}")
    public String Delete_Center(@PathVariable int id){
        String mess;
        if(centerService.findById(id) != null){
            centerService.deleteById(id);
            mess = "Đã xóa trung tâm ";
        } else {
            mess = "Trung tâm không tồn tại";
        }
        return mess;
    }
    @GetMapping("/{id}")
    public Center FindOne(@PathVariable int id){
        return centerService.findById(id);
    }

}
