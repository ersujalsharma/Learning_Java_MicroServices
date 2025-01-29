package com.sujal.service;

import java.util.List;

import com.sujal.model.ServiceRequest;
import com.sujal.exception.MobileServiceException;
import com.sujal.model.ServiceReport;
import com.sujal.model.Status;

public interface MobileService {
	public ServiceRequest registerRequest(ServiceRequest service) throws MobileServiceException;
	public Float calculateEstimateCost(List<String> issues) throws MobileServiceException;
	public List<ServiceReport> getServices(Status status) throws MobileServiceException;
}
