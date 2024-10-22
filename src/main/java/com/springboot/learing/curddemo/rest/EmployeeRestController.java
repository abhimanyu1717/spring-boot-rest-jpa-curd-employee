package com.springboot.learing.curddemo.rest;

import com.springboot.learing.curddemo.dao.EmployeeDAO;
import com.springboot.learing.curddemo.entity.Employee;
import com.springboot.learing.curddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService =  theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{empId}")
    public Employee findById(@PathVariable int empId) {
        Employee theEmployee =  employeeService.findById(empId);
        if(theEmployee == null) {
            throw new RuntimeException("Employee id not found - "+ empId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
        employee.setId(0);
        Employee theEmployee = employeeService.save(employee);
      return theEmployee;
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        Employee theEmployee = employeeService.save(employee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{empId}")
    public String deleteEmployee(@PathVariable int empId) {
        Employee theEmp = employeeService.findById(empId);
        if (theEmp == null) {
           throw  new RuntimeException("Employee not found - " + empId);
        }
        employeeService.deleteById(empId);

        return "Delete employee id - " + empId;
    }


}
