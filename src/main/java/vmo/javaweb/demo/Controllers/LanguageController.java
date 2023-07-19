package vmo.javaweb.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vmo.javaweb.demo.Models.Fresher;
import vmo.javaweb.demo.Models.Language;
import vmo.javaweb.demo.Repositories.FresherRepo;
import vmo.javaweb.demo.Repositories.LanguageRepo;
import vmo.javaweb.demo.Services.FresherService;
import vmo.javaweb.demo.Services.LanguageService;

import java.util.List;

@RestController
public class LanguageController {
    @Autowired
    LanguageService service;
    @Autowired
    FresherService fresherService;
    @PostMapping("/fresher/add_language")
    public String AddLanguage(@RequestBody Language language){
        String mess;
        if(fresherService.fillById(language.getFresher_id()) != null){
            service.save_language(language);
            mess = "Đã thêm " + language.getName() + " vào fresher " + fresherService.fillById(language.getFresher_id()).getName();
        } else {
            mess = "Fresher không tồn tại !!! ";
        }
        return mess;
    }
}
