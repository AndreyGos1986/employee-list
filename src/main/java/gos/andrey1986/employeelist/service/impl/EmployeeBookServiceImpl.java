package gos.andrey1986.employeelist.service.impl;

import gos.andrey1986.employeelist.data.Employee;
import gos.andrey1986.employeelist.exceptions.EmployeeNotFoundException;
import gos.andrey1986.employeelist.exceptions.TheEmployeeAlreadyExistsException;
import gos.andrey1986.employeelist.service.EmployeeBookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookService {
    Map<String, Employee> employeeBook;


    public EmployeeBookServiceImpl() {
        employeeBook = new HashMap<>();
    }


    @Override
    public boolean add(String firstName, String lastName, double salary, int deptNum) { //добавить сотрудника
        Employee employee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), salary, deptNum);

        if (!StringUtils.isAlpha(employee.getFirstName())
                || !StringUtils.isAlpha(employee.getLastName())) {
            throw new TheEmployeeAlreadyExistsException();

        } else if (!StringUtils.isAllBlank(employee.getFirstName())
                && !StringUtils.isAllBlank(employee.getLastName())
                && !employeeBook.containsKey(employee.getFirstAndLastName())) {
            employeeBook.put(StringUtils. capitalize(employee.getFirstAndLastName()), employee);

        } else {
            throw new TheEmployeeAlreadyExistsException();
        }
        return true;
    }


    @Override
    public boolean remove(String firstName, String lastName) { // удалить сотрудника
        Employee employee = find(firstName, lastName);
        if (employeeBook.containsKey(employee.getFirstAndLastName())) {
            return employeeBook.remove(employee.getFirstAndLastName(), employee);
        } else throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) { // найти сотрудника
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.containsKey(employee.getFirstAndLastName())) {
            return employeeBook.get(employee.getFirstAndLastName());
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Map<String, Employee> getEmployeeBook() {
        return employeeBook;
    }

    public Map<String, Employee> show() {
        return employeeBook;
    }

}

