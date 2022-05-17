package gos.andrey1986.employeelist.service;

import gos.andrey1986.employeelist.data.Employee;


import java.util.Map;

public interface EmployeeBook {
    boolean add (String firstName, String lastName,double salary,int deptNum);
    boolean remove(String firstName, String lastName);
    Employee find (String firstName, String lastName);
    Map<String,Employee> getEmployeeBook();
}
