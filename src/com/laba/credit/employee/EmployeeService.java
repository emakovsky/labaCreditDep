package com.laba.credit.employee;

import java.util.Set;

/**
 *
 */
public interface EmployeeService {

    void saveEmployee(Employee employee);

    Set<Employee> getAll();
}
