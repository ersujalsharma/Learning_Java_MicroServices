package com.sujal.dao;

import java.util.List;

import com.sujal.model.ServiceRequest;

public interface MobileServiceDAO {
	public ServiceRequest registerRequest(ServiceRequest service) ;
	public List<ServiceRequest> getServices() ;
}
