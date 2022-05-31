package gos.andrey1986.employeelist.service;

import gos.andrey1986.employeelist.data.Employee;

import java.util.List;

public interface EmployeeBookDeptNum {
    Employee findEmplWithMaxSalByDeptnum(Integer deptNum);
    Employee findEmplWithMinSalByDeptnum(Integer deptNum);
    List findEmployeesByDeptNum(Integer deptNum);
    List <Employee> getAll();

}