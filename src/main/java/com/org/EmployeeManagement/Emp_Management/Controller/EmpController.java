package com.org.EmployeeManagement.Emp_Management.Controller;

import com.org.EmployeeManagement.Emp_Management.Entity.Employee;
import com.org.EmployeeManagement.Emp_Management.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1")
public class EmpController {

    @Autowired
    EmpService service;

    @PostMapping(value = "/addEmp")
    public ResponseEntity addEmp(@RequestBody Employee input){
        service.addEmployee(input);
        return ResponseEntity.ok().body(Collections.singletonMap("Msg","Employee Added"));
    }

    @PutMapping(value = "/updateEmp")
    public ResponseEntity updateEmp(@RequestBody Employee input){
        service.updateEmployee(input);
        return ResponseEntity.ok().body(Collections.singletonMap("Msg","Employee Updated"));
    }

    @DeleteMapping(value = "/deleteEmp/{id}")
    public ResponseEntity deleteEmp(@PathVariable Integer id){
        service.deleteEmployee(id);
        return ResponseEntity.ok().body(Collections.singletonMap("Msg","Employee Deleted"));
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity getEmployeeDetailsById(@PathVariable Integer id){
         Employee emp=service.getSpecificEmpDetails(id);
         return ResponseEntity.ok().body(emp);
    }

    @GetMapping(value = "/employees")
    public ResponseEntity getEmpList(){
        List<Employee> empList=service.getAllEmpDetails();
        return ResponseEntity.ok().body(empList);
    }
}
