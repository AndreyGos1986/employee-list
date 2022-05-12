package gos.andrey1986.employeelist.service;

import gos.andrey1986.employeelist.data.Employee;


import java.util.Map;

public interface EmployeeBook {
    boolean add (int id,long inn, String firstName, String lastName);
    boolean remove(long inn);
    Employee find (long inn);
    Map<Long,Employee> getEmployeeBook();
}
