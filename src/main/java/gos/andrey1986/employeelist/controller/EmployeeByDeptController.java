package gos.andrey1986.employeelist.controller;


import gos.andrey1986.employeelist.data.Employee;
import gos.andrey1986.employeelist.service.EmployeeBookServByDept;
import gos.andrey1986.employeelist.service.impl.EmployeeBookServByDeptImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class EmployeeByDeptController {
    private final EmployeeBookServByDept employeeBookServByDept;

    public EmployeeByDeptController(EmployeeBookServByDept employeeBookServByDept) {
        this.employeeBookServByDept=employeeBookServByDept;
    }

    @RequestMapping("/max-salary")
    public Employee findEmplWithMaxSalByDeptnum(@RequestParam(name = "departmentId") int departmentId
    ) {
        return employeeBookServByDept.findEmplWithMaxSalByDeptnum(departmentId);
    }

    @RequestMapping("/min-salary")
    public Employee findEmplWithMinSalByDeptnum(@RequestParam(name = "departmentId") int departmentId
    ){
        return employeeBookServByDept.findEmplWithMinSalByDeptnum(departmentId);
    }

    @RequestMapping("/all-in-dep")
    public List<Employee> findEmployeesByDeptNum(@RequestParam(name = "departmentId") int departmentId
    ){
        return employeeBookServByDept.findEmployeesByDeptNum(departmentId);
    }
    @RequestMapping("/all")
    public List<Employee> showAllEmployees(){
        return employeeBookServByDept.getAll();
    }
}
