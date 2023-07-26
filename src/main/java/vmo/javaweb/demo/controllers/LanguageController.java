package vmo.javaweb.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vmo.javaweb.demo.models.entity.Language;
import vmo.javaweb.demo.services.FresherService;
import vmo.javaweb.demo.services.LanguageService;

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
