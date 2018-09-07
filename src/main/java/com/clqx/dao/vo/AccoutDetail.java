package com.clqx.dao.vo;

import java.util.Date;

public class AccoutDetail {
    private Integer id;

    private Integer inPrice;

    private Integer outPrice;

    private String userName;

    private Integer userId;

    private Integer status;

    private Date createDate;

    private String describe;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}