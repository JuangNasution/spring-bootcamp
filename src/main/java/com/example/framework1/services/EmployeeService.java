package com.example.framework1.services;

import com.example.framework1.models.Department;
import com.example.framework1.models.Employee;
import com.example.framework1.repositories.DepartmentRepository;
import com.example.framework1.repositories.EmployeeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juang Nasution
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee findById(String id) {
        return employeeRepository.findById(id).get();
    }

    public void delete(String id) {
        employeeRepository.delete(findById(id));
    }
}
