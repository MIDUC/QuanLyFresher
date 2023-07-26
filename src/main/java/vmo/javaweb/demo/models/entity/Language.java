package vmo.javaweb.demo.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fresher_id")
    private Integer fresher_id;
    @Column(name = "name")
    private String name;
    @Override
    public String toString() {
        return name ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFresher_id() {
        return fresher_id;
    }

    public void setFresher_id(Integer fresher_id) {
        this.fresher_id = fresher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
