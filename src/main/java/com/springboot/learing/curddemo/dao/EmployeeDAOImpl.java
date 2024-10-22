package com.springboot.learing.curddemo.dao;

import com.springboot.learing.curddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery <Employee> queryForAllEmp = entityManager.createQuery("From Employee",Employee.class);
        List<Employee> employeeList = queryForAllEmp.getResultList();
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        Employee dbEmployee = entityManager.find(Employee.class,id);
        return dbEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }
}
