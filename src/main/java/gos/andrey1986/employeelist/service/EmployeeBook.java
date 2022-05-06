package gos.andrey1986.employeelist.service;

import gos.andrey1986.employeelist.data.Employee;

import java.util.List;

public interface EmployeeBook {
    boolean add (int id, String firstName, String lastName);
    boolean remove(int id);
    Employee find (int id);
    List <Employee> getEmployeeBook();
}
