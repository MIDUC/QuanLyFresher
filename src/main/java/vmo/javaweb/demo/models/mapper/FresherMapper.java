package vmo.javaweb.demo.models.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import vmo.javaweb.demo.models.dto.FresherDto;
import vmo.javaweb.demo.models.entity.Center;
import vmo.javaweb.demo.models.entity.Fresher;
import vmo.javaweb.demo.models.entity.Language;
import vmo.javaweb.demo.services.IServices.CenterService;

import java.util.ArrayList;
import java.util.List;

public class FresherMapper {

    public static FresherDto toFresherDto (Fresher fresher , List<Center> centers , List<Language> languages , Float score ){
        FresherDto fresherDto = new FresherDto();
        fresherDto.setName(fresher.getName());
        fresherDto.setGmail(fresher.getGmail());
        fresherDto.setStatus(fresher.getStatus());
        fresherDto.setIdCenter(centers);
        fresherDto.setIdLanguage(languages);
        fresherDto.setScores(score);
        return fresherDto ;
    }
}
