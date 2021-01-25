package com.example.framework1.services;

import com.example.framework1.models.Department;
import com.example.framework1.repositories.DepartmentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juang Nasution
 */
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public void save(Department department) {
        departmentRepository.save(department);
    }

    public Department findById(String id) {
        return departmentRepository.findById(id).get();
    }

    public void delete(String id) {
        departmentRepository.delete(findById(id));
    }
}
