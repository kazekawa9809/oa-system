package cn.abb.oa.pojo;

import lombok.Data;

@Data
public class Depart {
    long departId;
    String departName;
    String departTel;
    String departDescription;
    String departLocation;
    long departUpperId;
    long departManagerId;

    public Depart(String departName, String departTel, String departDescription, String departLocation, long departUpperId, long departManagerId) {
        this.departName = departName;
        this.departTel = departTel;
        this.departDescription = departDescription;
        this.departLocation = departLocation;
        this.departUpperId = departUpperId;
        this.departManagerId = departManagerId;
    }
}
