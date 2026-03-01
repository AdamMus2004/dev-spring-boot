package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeRepository employeeRepository;
    private JsonMapper jsonMapper;

    @Autowired
    public EmployeeRestController(EmployeeRepository employeeRepository,JsonMapper jsonMapper){
        this.jsonMapper=jsonMapper;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Employee employee = employeeRepository.getReferenceById(id);
        if (employee==null) {
            throw new RuntimeException("Employee id not found - "+id);
        } else {
            return employee;
        }
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        Employee dbEmployee = employeeRepository.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeesById(@PathVariable int id){
        Employee employee = employeeRepository.getReferenceById(id);
        if (employee==null) {
            throw new RuntimeException("Employee id not found - "+id);
        }
        employeeRepository.deleteById(id);
        return "Employee with id - "+ id + " successfully removed.";
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee dbEmployee = employeeRepository.save(employee);
        return dbEmployee;
    }
    @PatchMapping("/employees/{id}")
    public Employee patchEmployee(@PathVariable int id, @RequestBody Map<String, Object> patchPayload) {
        Employee tempEmployee = employeeRepository.getReferenceById(id);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - "+id);
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in request body - "+id);
        }

        Employee patchedEmployee = jsonMapper.updateValue(tempEmployee,patchPayload);
        Employee dbEmployee =  employeeRepository.save(patchedEmployee);
        return dbEmployee;
    }
}
