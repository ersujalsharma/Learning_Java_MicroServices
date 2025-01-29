package com.sujal.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sujal.dao.MobileServiceDAO;
import com.sujal.dao.MobileServiceDAOImpl;
import com.sujal.exception.MobileServiceException;
import com.sujal.model.ServiceReport;
import com.sujal.model.ServiceRequest;
import com.sujal.model.Status;
import com.sujal.validator.Validator;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MobileServiceImpl implements MobileService{
	private static final Log LOGGER = LogFactory.getLog(Validator.class);

	private MobileServiceDAO dao=new MobileServiceDAOImpl();

	Configurations configurations = new Configurations();
	PropertiesConfiguration config;

    {
        try {
            config = configurations.properties("configuration.properties");
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    private Validator validator=new Validator();
	@Override
	public ServiceRequest registerRequest(ServiceRequest service) throws MobileServiceException {
		validator.validate(service);
		float val = calculateEstimateCost(service.getIssues());
		if(val<=0){
			try {
				throw new MobileServiceException("Service.INVALID_ISSUES");
			} catch (MobileServiceException e) {
				LOGGER.error(config.getProperty(e.getMessage()));
				throw e;
			}
		}
		service.setServiceFee(val);
		service.setStatus(Status.ACCEPTED);
		service.setTimeOfRequest(LocalDateTime.now());
		ServiceRequest serviceRequest = dao.registerRequest(service);
		return serviceRequest;
	}

	@Override
	public Float calculateEstimateCost(List<String> issues) throws MobileServiceException {
		float val = 0;
		for(String str : issues){
			if(str.equalsIgnoreCase("BATTERY")){
				val+=10;
			}
			else if(str.equalsIgnoreCase("CAMERA")){
				val+=5;
			}
			else if(str.equalsIgnoreCase("SCREEN")){
				val+=15;
			}
		}
		return val;
	}

	@Override
	public List<ServiceReport> getServices(Status status) throws MobileServiceException {
		List<ServiceReport> list = new ArrayList<>();
		List<ServiceRequest> serviceRequests = dao.getServices();
		serviceRequests.stream().filter((s)->s.getStatus().equals(status)).forEach((s)->{
			list.add(new ServiceReport(s.getServiceId(),s.getBrand(),s.getIssues(),s.getServiceFee()));
		});
		try{
			if(list.isEmpty()){
				throw new MobileServiceException("Service.NO_RECORDS_FOUND");
			}
		}catch(MobileServiceException e){
			LOGGER.error(config.getProperty(e.getMessage()));
			throw e;
		}
		return list;
	}

}
