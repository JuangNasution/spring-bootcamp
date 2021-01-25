package com.example.framework1.repositories;

import com.example.framework1.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juang Nasution
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

}
