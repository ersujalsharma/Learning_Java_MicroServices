package com.sujal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujal.dto.EmployeeLogin;
import com.sujal.exception.EmployeeAuthenticateException;
import com.sujal.repository.EmployeeLoginRepository;
@Service(value="employeeLoginService")
public class EmployeeLoginServiceImpl implements EmployeeLoginService {

	@Autowired
	private EmployeeLoginRepository employeeLoginRepository;

	public String authenticateCustomer(EmployeeLogin employeeLogin) throws EmployeeAuthenticateException {
		
			String toRet = null;
			EmployeeLogin customerLoginFromDao = employeeLoginRepository
					.getEmployeeLoginByLoginName(employeeLogin.getLoginName());
			if (employeeLogin.getPassword().equals(customerLoginFromDao.getPassword())){
				toRet = "SUCCESS";
			}else{
				throw new EmployeeAuthenticateException("Service.WRONG_CREDENTIALS");
			}
			return toRet;
		
	}
}
