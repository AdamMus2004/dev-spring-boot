package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if (employee==null) {
            throw new RuntimeException("Employee id not found id: ["+id+"]");
        } else {
            return employee;
        }
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeesById(@PathVariable int id){
        employeeService.deleteById(id);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
       Employee dbEmployee = employeeService.save(employee);
       return dbEmployee;
    }
}
