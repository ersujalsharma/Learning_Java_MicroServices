package com.sujal.repository;

import com.sujal.dto.EmployeeLogin;

public interface EmployeeLoginRepository {
	public EmployeeLogin getEmployeeLoginByLoginName(String loginName);
}
