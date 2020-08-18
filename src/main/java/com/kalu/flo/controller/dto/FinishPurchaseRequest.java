package com.kalu.flo.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

public class FinishPurchaseRequest {

    @NotNull
    private Map<Integer,Integer> productIdProductCount;
    @NotEmpty
    private String userName;
    @NotEmpty
    private String userSurname;
    @NotEmpty
    private String email;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String address;
    private String comment;

    public FinishPurchaseRequest() {
    }

    public Map<Integer, Integer> getProductIdProductCount() {
        return productIdProductCount;
    }

    public void setProductIdProductCount(Map<Integer, Integer> productIdProductCount) {
        this.productIdProductCount = productIdProductCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
