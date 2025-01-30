package com.sujal.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sujal.dto.EmployeeLogin;
@Repository(value="employeeLoginRepository")
public class EmployeeLoginRepositoryImpl implements EmployeeLoginRepository {
	public EmployeeLogin getEmployeeLoginByLoginName(String loginName) {
		Map<String, String> employeeCredentials = new HashMap<>();
		employeeCredentials.put("tom", "tom123");
		employeeCredentials.put("harry", "harry123");
		employeeCredentials.put("garry", "garry123");
		employeeCredentials.put("monica", "mocica123");
		EmployeeLogin employeeLogin = new EmployeeLogin();
		employeeLogin.setLoginName(loginName);
		employeeLogin.setPassword(employeeCredentials.get(loginName));
		return employeeLogin;
	}
}
