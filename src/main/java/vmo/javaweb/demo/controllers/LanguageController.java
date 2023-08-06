package vmo.javaweb.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vmo.javaweb.demo.models.entity.Language;
import vmo.javaweb.demo.services.FresherServiceImpl;
import vmo.javaweb.demo.services.LanguageServiceImpl;


@RestController
@RequestMapping("/api/language")
public class LanguageController {
    @Autowired
    LanguageServiceImpl service;
    @Autowired
    FresherServiceImpl fresherService;
    @PostMapping("/fresher")
    public String AddLanguage(@RequestBody Language language){
        String mess;
        if(fresherService.findById(language.getFresher_id()) != null){
            service.save(language);
            mess = "Đã thêm " + language.getName() + " vào fresher " + fresherService.findById(language.getFresher_id()).getName();
        } else {
            mess = "Fresher không tồn tại !!! ";
        }
        return mess;
    }
}
