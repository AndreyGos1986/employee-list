package gos.andrey1986.employeelist.service.impl;

import gos.andrey1986.employeelist.data.Employee;
import gos.andrey1986.employeelist.exceptions.EmployeeIndexOutOfBoundsException;
import gos.andrey1986.employeelist.exceptions.EmployeeNotFoundException;
import gos.andrey1986.employeelist.exceptions.TheEmployeeAlreadyExistsException;
import gos.andrey1986.employeelist.service.EmployeeBook;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeBookServiceImpl implements EmployeeBook {
    Map<String, Employee> employeeBook;


    public EmployeeBookServiceImpl() {
        employeeBook = new HashMap<>();
    }


    @Override
    public boolean add(String firstName, String lastName) { //добавить сотрудника
        Employee employee = new Employee(firstName, lastName);
            if (!employeeBook.containsKey(employee.getFirstAndLastName())) {
                employeeBook.put(employee.getFirstAndLastName(), employee);
            } else throw new TheEmployeeAlreadyExistsException();
            return true;
        }


    @Override
    public boolean remove(String firstName, String lastName) {
        Employee employee = find(firstName,lastName);
        if (employeeBook.containsKey(employee.getFirstAndLastName())) {
                 return employeeBook.remove(employee.getFirstAndLastName(),employee);
        } else throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) { // поиск сотрудника
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.containsKey(employee.getFirstAndLastName())) {
            return employeeBook.get(employee.getFirstAndLastName());
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Map<String, Employee> getEmployeeBook() {
        return null;
    }

    public Map<String, Employee> show() {
        return employeeBook;
    }

}

