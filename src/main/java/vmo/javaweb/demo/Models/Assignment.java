package vmo.javaweb.demo.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "assignment")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "status", nullable = true)
    private int status;
    @Column(name = "content")
    private String content;
    @Column(name = "point")
    private float point;
    @Column(name = "fresher_id")
    private Integer fresher_id;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public Integer getFresher_id() {
        return fresher_id;
    }

    public void setFresher_id(Integer fresher_id) {
        this.fresher_id = fresher_id;
    }

    @Override
    public String toString() {
        return  "{" +
                "content='" + content + '\'' +
                ", point=" + point + "}";
    }
}
