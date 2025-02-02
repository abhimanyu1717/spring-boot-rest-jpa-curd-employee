package com.springboot.learing.curddemo.service;

import com.springboot.learing.curddemo.dao.EmployeeDAO;
import com.springboot.learing.curddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl( EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
       return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
       return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
       employeeDAO.deleteById(id);
    }
}
