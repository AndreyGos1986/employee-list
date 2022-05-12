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
    Map<Long, Employee> employeeBook;


    public EmployeeBookServiceImpl() {
        employeeBook = new HashMap<>();
    }

    int nextId = 0;

    @Override
    public boolean add(int id, long inn, String firstName, String lastName) { //добавить сотрудника
        int employeeBookSize = 5;
        Employee employee = new Employee(inn, toSetId(), firstName, lastName);
        if (id <= employeeBookSize) {
            if (!employeeBook.containsKey(inn)) {
                employeeBook.put(inn, employee);
                nextId++;
            } else throw new TheEmployeeAlreadyExistsException();
            return true;
        } else throw new EmployeeIndexOutOfBoundsException();
    }

    @Override
    public boolean remove(long inn) {
        if (employeeBook.containsKey(inn)) {
            nextId--;
            return employeeBook.remove(inn, employeeBook.get(inn));
        } else throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(long inn) { // поиск сотрудника
        if (employeeBook.containsKey(inn)) {
            return employeeBook.get(inn);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Map<Long, Employee> getEmployeeBook() {
        return null;
    }

    public Map<Long, Employee> show() {
        return employeeBook;
    }

    private int toSetId() {
        int res = nextId;
        nextId = nextId + 1;
        return res;
    }

}
