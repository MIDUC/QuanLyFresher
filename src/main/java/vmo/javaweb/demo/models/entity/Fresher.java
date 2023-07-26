package vmo.javaweb.demo.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fresher")
public class Fresher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "status", nullable = true)
    private int status;
    @Column(name = "name")
    private String name;

    @Column(name = "gmail")
    private String gmail;



    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name ;
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

    @Override
    public String toString() {
        return "Fresher{" +
                "id=" + id +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", gmail='" + gmail + '\'' +
                '}';
    }
}
