package com.sujal.dao;

import java.util.Arrays;
import java.util.List;

import com.sujal.model.ServiceRequest;
import com.sujal.model.Status;

public class MobileServiceDAOImpl implements MobileServiceDAO {
	
	@Override
	public ServiceRequest registerRequest(ServiceRequest service)  {
		service.setServiceId(1000);
		return service;
	}

	@Override
	public List<ServiceRequest> getServices()  {
		ServiceRequest service = new ServiceRequest("TwoMinus", Arrays.asList("Battery", "Camera", "Screen"), 908070605L, "Jhon",
				1234567890123456L);
		ServiceRequest service1 = new ServiceRequest("TwoMinus", Arrays.asList("Camera", "Screen"), 908070605L, "Tim",
				1234567890123457L);
		ServiceRequest service2 = new ServiceRequest("Motorolling", Arrays.asList("Camera"), 908070605L, "Kim", 1234567890123458L);
		ServiceRequest service3 = new ServiceRequest("Motorolling", Arrays.asList("Camera", "Screen"), 908070605L, "Jim",
				1234567890123459L);
		ServiceRequest service4 = new ServiceRequest("Pineapple", Arrays.asList("Battery Drain", "Camera"), 908070605L, "Timmy",
				1234567890123460L);
		ServiceRequest service5 = new ServiceRequest("Pineapple", Arrays.asList("Battery Drain", "Screen"), 908070605L, "Bella",
				1234567890123461L);
		ServiceRequest service6 = new ServiceRequest("TwoMinus", Arrays.asList("Battery Drain"), 908070605L, "Jack",
				1234567890123462L);
		ServiceRequest service7 = new ServiceRequest("TwoMinus", Arrays.asList("Screen"), 908070605L, "Sam", 1234567890123463L);
		
		
		service.setServiceId(1001);
		service1.setServiceId(1002);
		service3.setServiceId(1003);
		service2.setServiceId(1004);
		service4.setServiceId(1005);
		service5.setServiceId(1006);
		service6.setServiceId(1007);
		service7.setServiceId(1008);

		service.setStatus(Status.IN_PROGRESS);
		service1.setStatus(Status.COMPLETED);
		service3.setStatus(Status.COMPLETED);
		service2.setStatus(Status.COMPLETED);
		service4.setStatus(Status.COMPLETED);
		service5.setStatus(Status.ACCEPTED);
		service6.setStatus(Status.COMPLETED);
		service7.setStatus(Status.COMPLETED);

		service.setServiceFee(15f);
		service1.setServiceFee(5f);
		service3.setServiceFee(5f);
		service2.setServiceFee(5f);
		service4.setServiceFee(15f);
		service5.setServiceFee(10f);
		service6.setServiceFee(5f);
		service7.setServiceFee(10f);

		return Arrays.asList(service, service1, service2, service3, service4, service5, service6, service7);
	}

}
