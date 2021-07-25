package com.org.EmployeeManagement.Emp_Management.Service;

import com.org.EmployeeManagement.Emp_Management.Entity.Employee;
import com.org.EmployeeManagement.Emp_Management.Repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmpService {

    @Autowired
    EmpRepository repository;


    public void addEmployee(Employee empDetail){
        repository.save(empDetail);
    }

    public void updateEmployee(Employee empDetail){
        repository.deleteById(empDetail.getEmployee_id());
        System.out.println("Emp "+empDetail.getEmployee_id()+" is Deleted Successfully!!");
        repository.save(empDetail);
    }

    public void deleteEmployee(Integer id){
        repository.deleteById(id);
    }

    public Employee getSpecificEmpDetails(Integer id){
        return repository.findById(id).get();
    }

    public List<Employee> getAllEmpDetails(){
        return  repository.findAll();
    }
}
