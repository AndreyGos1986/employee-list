package gos.andrey1986.employeelist.service.impl;

import gos.andrey1986.employeelist.data.Employee;
import gos.andrey1986.employeelist.exceptions.EmployeeIndexOutOfBoundsException;
import gos.andrey1986.employeelist.exceptions.EmployeeNotFoundException;
import gos.andrey1986.employeelist.exceptions.TheEmployeeAlreadyExistsException;
import gos.andrey1986.employeelist.service.EmployeeBook;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeBookServiceImpl implements EmployeeBook {
    List<Employee> employeeBook;


    public EmployeeBookServiceImpl() {
        employeeBook = new ArrayList<>();
    }


    @Override
    public boolean add(int id, String firstName, String lastName) { //добавить сотрудника
        int enployeeBookSize = 10;
        Employee employee = new Employee(id, firstName, lastName);
        if (id <= enployeeBookSize) {
            for (int i = 0; i < employeeBook.size(); i++) {
                if (employeeBook.get(i).getId() == employee.getId() ||
                        employeeBook.get(i).getFirstName().equalsIgnoreCase(employee.getFirstName()) &&
                                employeeBook.get(i).getLastName().equalsIgnoreCase(employee.getLastName())) {
                    throw new TheEmployeeAlreadyExistsException();
                }
            }
            return employeeBook.add(employee);
        } else throw new EmployeeIndexOutOfBoundsException();
    }

    @Override
    public boolean remove(int id) {
        if (employeeBook.get(id).getId()==id) {
            return employeeBook.remove(employeeBook.get(id));
        } else throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(int id) { // поиск сотрудника
        if (id >= 0 && id<employeeBook.size()) {
            return employeeBook.get(id);
    }
    else  {
            throw new EmployeeNotFoundException();
            }
    }

    @Override
    public List<Employee> getEmployeeBook() {
        return null;
    }

    public List<Employee> show() {
        return employeeBook;
    }

}
