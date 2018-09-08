package com.ssqx.dao.vo;

import java.util.Date;

public class ClothInfo {
    private Integer id;

    private Integer inPrice;

    private Integer outPrice;

    private Integer number;

    private Integer status;

    private Date createDate;

    private Date updateDate;

    private String detail;

    private String storeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInPrice() {
        return inPrice;
    }

    public void setInPrice(Integer inPrice) {
        this.inPrice = inPrice;
    }

    public Integer getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(Integer outPrice) {
        this.outPrice = outPrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }
}