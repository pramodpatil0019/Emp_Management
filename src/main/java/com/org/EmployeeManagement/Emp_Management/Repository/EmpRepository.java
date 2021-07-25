package com.org.EmployeeManagement.Emp_Management.Repository;

import com.org.EmployeeManagement.Emp_Management.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Employee,Integer> {
}
