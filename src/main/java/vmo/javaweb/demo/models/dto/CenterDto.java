package vmo.javaweb.demo.models.dto;


import java.util.List;

public class CenterDto {

    private Integer id;
    private int status;
    private String name;
    private String address;
    private List<Integer> idFresher;
    public CenterDto() {

    }
    public CenterDto(Integer id, int status, String name, String address, List<Integer> idFresher) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.address = address;
        this.idFresher = idFresher;
    }

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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Integer> getIdFresher() {
        return idFresher;
    }

    public void setIdFresher(List<Integer> idFresher) {
        this.idFresher = idFresher;
    }

    @Override
    public String toString() {
        return "CenterDto{" +
                "id=" + id +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", idFresher=" + idFresher +
                '}';
    }
}
