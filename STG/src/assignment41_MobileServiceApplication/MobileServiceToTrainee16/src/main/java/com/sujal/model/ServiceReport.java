package com.sujal.model;


import java.util.List;

public class ServiceReport {
	private Integer serviceId;
    private String brand;
    private List<String> issues;
    private Float serviceFee;

    public ServiceReport(Integer serviceId, String brand, List<String> issues, Float serviceFee) {
        this.serviceId = serviceId;
        this.brand = brand;
        this.issues = issues;
        this.serviceFee = serviceFee;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<String> getIssues() {
        return issues;
    }

    public void setIssues(List<String> issues) {
        this.issues = issues;
    }

    public Float getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Float serviceFee) {
        this.serviceFee = serviceFee;
    }
}
