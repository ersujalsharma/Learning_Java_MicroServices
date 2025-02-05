package com.sujal.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sujal.dto.CustomerLoginDTO;

@Repository(value="customerLoginRepository")
public class CustomerLoginRepositoryImpl implements CustomerLoginRepository {
	public CustomerLoginDTO getCustomerLoginByLoginName(String loginName) {
		Map<String, String> customerCredentials = new HashMap<String, String>();
		customerCredentials.put("robin", "robin123");
		customerCredentials.put("harry", "harry123");
		customerCredentials.put("garry", "garry123");
		customerCredentials.put("monica", "mocica123");
		CustomerLoginDTO customerLogin = new CustomerLoginDTO();
		customerLogin.setLoginName(loginName);
		customerLogin.setPassword(customerCredentials.get(loginName));
		return customerLogin;
	}
}
