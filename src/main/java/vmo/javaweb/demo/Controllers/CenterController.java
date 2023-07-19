package vmo.javaweb.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vmo.javaweb.demo.Models.Center;
import vmo.javaweb.demo.Models.Fresher;
import vmo.javaweb.demo.Models.FresherOfCenter;
import vmo.javaweb.demo.Models.Language;
import vmo.javaweb.demo.Services.CenterService;
import vmo.javaweb.demo.Services.FresherService;
import vmo.javaweb.demo.Services.LanguageService;

import java.util.List;

@RestController
public class CenterController {
    @Autowired
    CenterService centerService;
    @Autowired
    FresherService fresherService;

    @GetMapping("/admin/centers")
    public List<Center> GetAllCenter(){
        return centerService.getAll();
    }
    @PostMapping("/admin/add_to_the_center")
    public String Add_Fresher_to_Center(@RequestBody FresherOfCenter fresherOfCenter){
        String mess;
        if(fresherService.fillById(fresherOfCenter.getFresher_id()) == null){
            mess = "Fresher không tồn tại !!! ";
        } else {
            if(centerService.fillById(fresherOfCenter.getCenter_id()) == null){
                mess = "Trung tâm không tồn tại !!! ";
            }else {
                centerService.addToTheCenter(fresherOfCenter);
                mess = "Đã thêm fresher " +
                        fresherService.fillById(fresherOfCenter.getFresher_id()).getName()
                        + " vào trung tâm" + centerService.fillById(fresherOfCenter.getCenter_id());
            }
        }
        return mess;
    }
    @PostMapping("/admin/add_center")
    public String Add_fresher(@RequestBody Center center){
        String mess;
        System.out.println("Dang add");
        if(centerService.checkByName(center.getName()) == true){
            centerService.add_center(center);
            System.out.println("Add thanh cong");
            mess = "Thêm trung tâm " + center.getName() + " thành công";
        } else {
            mess = "Trung tâm đã tồn tại";
        }

        return mess;
    }
    @DeleteMapping("/admin/delete_center/{id}")
    public String Delete_Center(@PathVariable int id){
        String mess;
        Center center = centerService.fillById(id);
        if(center != null){
            centerService.delete_center(center);
            mess = "Đã xóa trung tâm " + center.getName();
        } else {
            mess = "Trung tâm không tồn tại";
        }
        return mess;
    }


}
