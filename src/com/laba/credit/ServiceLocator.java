package com.laba.credit;

import com.laba.credit.employee.EmployeeService;
import com.laba.credit.employee.EmployeeServiceImpl;
import com.laba.credit.login.LoginService;
import com.laba.credit.login.LoginServiceImpl;

/**
 *
 */
public class ServiceLocator {
    private static ServiceLocator instance;
    private static LoginService loginService;
    private static EmployeeService employeeService;

    public static ServiceLocator getInstance() {
        if(instance == null ) {
            instance = new ServiceLocator();
        }
        return instance;
    }

    private ServiceLocator() {
    }

    public LoginService getLoginService() {
        return loginService == null? loginService = new LoginServiceImpl() : loginService;
    }

    public EmployeeService getEmployeeService() {
        return employeeService == null? employeeService = new EmployeeServiceImpl() : employeeService;
    }
}
