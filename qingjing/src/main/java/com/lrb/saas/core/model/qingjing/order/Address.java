package com.lrb.saas.core.model.qingjing.order;

import com.lrb.saas.core.annotation.SAASField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@GenericGenerator(
        name = "uuid",
        strategy = "uuid"
)
public class Address {
    @Id
    @SAASField(
            name = "主键"
    )
    @GeneratedValue(
            generator = "uuid"
    )
    private String id;
    @SAASField(
            name = "姓名"
    )
    private String name;
    @SAASField(
            name = "手机号"
    )
    private String phoneNumber;
    @SAASField(
            name = "地址"
    )
    private String location;
    @SAASField(
            name = "地址"
    )
    private String location2;
    @SAASField(
            name = "微信号openid"
    )
    private String openid;

    public Address() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOpenid() {
        return this.openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getLocation2() {
        return this.location2;
    }

    public void setLocation2(String location2) {
        this.location2 = location2;
    }
}
