package gos.andrey1986.employeelist.service;

import gos.andrey1986.employeelist.data.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeBookServDept {
    Employee findEmplWithMaxSalByDeptnum(Integer deptNum);
    Employee findEmplWithMinSalByDeptnum(Integer deptNum);
    List findEmployeesByDeptNum(Integer deptNum);
    List <Employee> getAll();

}