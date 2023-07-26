package vmo.javaweb.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vmo.javaweb.demo.models.entity.Assignment;
import vmo.javaweb.demo.services.AssignmentService;

@RestController
public class AssignmentController {
    @Autowired
    AssignmentService assignmentService;
    @PostMapping("admin/assignment/add")
    public String Add_Assignment(@RequestBody Assignment assignment){
        String mess;
        assignmentService.save_agm(assignment);
        mess = "Thành công";
        return mess;
    }
    @DeleteMapping("admin/assignment/delete/{id}")
    public String Delete_Assignment(@PathVariable int id){
        String mess;
        assignmentService.delete_agm(id);
        mess = "Thành công";
        return mess;
    }
}
