package com.example.framework1.repositories;

import com.example.framework1.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juang Nasution
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
