package com.laba.credit.employee;

import java.util.HashSet;
import java.util.Set;

import com.laba.credit.util.SerializationUtils;

/**
 *
 */
public class EmployeeServiceImpl implements EmployeeService {
    private static final String FILE = "SerializedEmployees.dat";

    private HashSet<Employee> employees = new HashSet<Employee>();

    public EmployeeServiceImpl() {
        Object restored = new SerializationUtils().restoreObjectFromFile(FILE);
        if (restored != null && restored instanceof HashSet) {
            employees = (HashSet<Employee>) restored;
            System.out.println("restored: " + employees.size());
        }
    }

    @Override
    public void saveEmployee(Employee employee) {
        employees.add(employee);
        persist();
    }

    @Override
    public Employee findByName(String name) {
        for(Employee employee: employees) {
            if(employee.getName().equalsIgnoreCase(name)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public Set<Employee> getAll() {
        return employees;
    }

    private void persist() {
        new SerializationUtils().saveObjectToFile(FILE, employees);
        System.out.println("saved: " + employees.size());
    }
}
