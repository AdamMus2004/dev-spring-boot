package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private JsonMapper jsonMapper;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService,JsonMapper jsonMapper){
        this.jsonMapper=jsonMapper;
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
            throw new RuntimeException("Employee id not found - "+id);
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
    @PatchMapping("/employees/{id}")
    public Employee patchEmployee(@PathVariable int id, @RequestBody Map<String, Object> patchPayload) {
        Employee tempEmployee = employeeService.findById(id);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - "+id);
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in request body - "+id);
        }

        Employee patchedEmployee = jsonMapper.updateValue(tempEmployee,patchPayload);
        Employee dbEmployee =  employeeService.save(patchedEmployee);
        return dbEmployee;
    }
}
