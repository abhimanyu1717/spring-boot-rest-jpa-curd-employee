package com.springboot.learing.curddemo.dao;

import com.springboot.learing.curddemo.entity.Employee;


import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee theEmployee);
    void deleteById(int id);

}
