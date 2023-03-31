package com.jac.thymleaf.SpringMVCProject.repository;

import com.jac.thymleaf.SpringMVCProject.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
