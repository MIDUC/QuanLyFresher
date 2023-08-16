package vmo.javaweb.demo.models.dto;

import vmo.javaweb.demo.models.entity.Center;
import vmo.javaweb.demo.models.entity.Language;

import java.util.List;

public class FresherDto {

    private String name;
    private String gmail;
    private Float scores;
    private int status;
    private List<Center> idCenter;
    private List<Language> idLanguage;


    public FresherDto() {
    }

    @Override
    public String toString() {
        return "FresherDto{" +
                ", name='" + name + '\'' +
                ", gmail='" + gmail + '\'' +
                ", scores=" + scores +
                ", status=" + status +
                "idCenter=" + idCenter +
                ", idLanguage=" + idLanguage +
                '}';
    }

    public FresherDto(List<Center> idCenter, List<Language> idLanguage, int status, String name, String gmail, Float scores) {
        this.idCenter = idCenter;
        this.idLanguage = idLanguage;
        this.status = status;
        this.name = name;
        this.gmail = gmail;
        this.scores = scores;
    }
    public List<Center> getIdCenter() {
        return idCenter;
    }

    public void setIdCenter(List<Center> idCenter) {
        this.idCenter = idCenter;
    }

    public List<Language> getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(List<Language> idLanguage) {
        this.idLanguage = idLanguage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public Float getScores() {
        return scores;
    }

    public void setScores(Float scores) {
        this.scores = scores;
    }

}
