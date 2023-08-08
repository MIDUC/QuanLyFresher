package vmo.javaweb.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vmo.javaweb.demo.models.entity.Language;
import vmo.javaweb.demo.services.IServices.FresherService;
import vmo.javaweb.demo.services.IServices.LanguageService;


@RestController
@RequestMapping("/api/languages")
public class LanguageController {
    @Autowired
    LanguageService languageService;
    @Autowired
    FresherService fresherService;
    @PostMapping("/fresher")
    public String AddLanguage(@RequestBody Language language){
        String mess;
        if(fresherService.findById(language.getFresher_id()) != null){
            languageService.save(language);
            mess = "Đã thêm " + language.getName() + " vào fresher " + fresherService.findById(language.getFresher_id()).getName();
        } else {
            mess = "Fresher không tồn tại !!! ";
        }
        return mess;
    }
}
