package com.lrb.saas.core.model.qingjing.order;

import com.alibaba.fastjson.annotation.JSONField;
import com.lrb.saas.core.annotation.SAASField;
import com.lrb.saas.core.model.qingjing.production.ProductionType;
import com.lrb.saas.core.util.UUIDUtil;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class OrderList {
    @Transient
    @JSONField(
            serialize = false,
            deserialize = false
    )
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    @Id
    @SAASField(
            name = "主键"
    )
    private String id = UUIDUtil.randomUUIDString();
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
            name = "微信号openid"
    )
    private String openid;
    @SAASField(
            name = "产品"
    )
    @OneToMany(
            cascade = {CascadeType.ALL}
    )
    private List<OrderItem> orderItems = new ArrayList();
    @SAASField(
            name = "总金额"
    )
    private String money;
    @SAASField(
            name = "总数量"
    )
    private Integer count;
    @SAASField(
            name = "状态",
            uiComponent = "Select",
            dictionaryUrl = "http://m.qinjuu.com/cdn/js/dictionary/orderListStatus.js"
    )
    private String status;
    @SAASField(
            name = "快递号"
    )
    private String expressNO;
    @SAASField(
            name = "快递公司"
    )
    private String expressCompany;
    @SAASField(
            name = "创建时间"
    )
    private Date sys_createDateTime;

    public OrderList() {
    }

    public String getExpressCompany() {
        return this.expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
    }

    public DecimalFormat getDecimalFormat() {
        return this.decimalFormat;
    }

    public void setDecimalFormat(DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
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

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getMoney() {
        this.money = this.money();
        return this.money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExpressNO() {
        return this.expressNO;
    }

    public void setExpressNO(String expressNO) {
        this.expressNO = expressNO;
    }

    public Integer getCount() {
        return (Integer) this.orderItems.stream().map((o) -> {
            return o.getCount();
        }).reduce(Integer.valueOf(0), Integer::sum);
    }

    public void setCount(Integer count) {
        this.count = (Integer) this.orderItems.stream().map((o) -> {
            return o.getCount();
        }).reduce(Integer.valueOf(0), Integer::sum);
    }

    public Date getSys_createDateTime() {
        return this.sys_createDateTime;
    }

    public void setSys_createDateTime(Date sys_createDateTime) {
        this.sys_createDateTime = sys_createDateTime;
    }

    public void add(ProductionType productionType) {
        if (((List) this.orderItems.stream().filter((item) -> {
            if (productionType.getId().equals(item.getProductionType().getId())) {
                item.setCount(Integer.valueOf(item.getCount().intValue() + 1));
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList())).size() == 0) {
            OrderItem item = new OrderItem();
            item.setCount(Integer.valueOf(1));
            item.setProductionType(productionType);
            item.setId(UUIDUtil.randomUUIDString());
            this.orderItems.add(item);
        }

    }

    public String money() {
        return this.decimalFormat.format(this.orderItems.stream().map((o) -> {
            return Double.valueOf((double) o.getCount().intValue() * Double.valueOf(o.getProductionType().getProduction().getPrice()).doubleValue());
        }).reduce(Double.valueOf(0.0D), Double::sum));
    }

    public void reduce(ProductionType productionType) {
        this.orderItems.stream().filter((item) -> {
            return productionType.getId().equals(item.getProductionType().getId());
        }).forEach((orderItem) -> {
            if (orderItem.getCount().intValue() > 0) {
                orderItem.setCount(Integer.valueOf(orderItem.getCount().intValue() - 1));
            }

        });
    }

    public void del(ProductionType productionType) {
        for (int i = 0; i < this.orderItems.size(); ++i) {
            if (((OrderItem) this.orderItems.get(i)).getProductionType().getId().equals(productionType.getId())) {
                this.orderItems.remove(i);
                --i;
            }
        }

    }
}
