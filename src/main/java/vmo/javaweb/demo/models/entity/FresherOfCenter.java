package vmo.javaweb.demo.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fresher_of_center")
public class FresherOfCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "center_id")
    private Integer center_id;
    @Column(name = "fresher_id")
    private Integer fresher_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCenter_id() {
        return center_id;
    }

    public void setCenter_id(Integer center_id) {
        this.center_id = center_id;
    }

    public Integer getFresher_id() {
        return fresher_id;
    }

    public void setFresher_id(Integer fresher_id) {
        this.fresher_id = fresher_id;
    }
}
