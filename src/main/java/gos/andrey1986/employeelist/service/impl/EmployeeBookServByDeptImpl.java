package gos.andrey1986.employeelist.service.impl;

import gos.andrey1986.employeelist.data.Employee;
import gos.andrey1986.employeelist.exceptions.EmployeeNotFoundException;
import gos.andrey1986.employeelist.service.EmployeeBookDeptNum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeBookServByDeptImpl implements EmployeeBookDeptNum {
    private final EmployeeBookServiceImpl employeeBookService;

    public EmployeeBookServByDeptImpl(EmployeeBookServiceImpl employeeBookService) {
        this.employeeBookService = employeeBookService;
    }


    @Override
    public List<Employee> getAll() {
        return employeeBookService.getEmployeeBook()
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Employee findEmplWithMaxSalByDeptnum(Integer deptNum) { //найти сотрудника с максимальным доходом по номеру отдела
        return employeeBookService.getEmployeeBook()
                .values()
                .stream()
                .filter(emp -> emp.getDeptNum().equals(deptNum))
                .collect(Collectors.toList())
                .stream().max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee findEmplWithMinSalByDeptnum(Integer deptNum) { //поиск минимального дохода по номеру отдела
        return employeeBookService.getEmployeeBook()
                .values()
                .stream()
                .filter(employee -> employee.getDeptNum().equals(deptNum))
                .collect(Collectors.toList())
                .stream().min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> findEmployeesByDeptNum(Integer deptNum) { // найти всех сотрудников по номеру отдела
        List<Employee> employeesList = employeeBookService.getEmployeeBook()
                .values().stream()
                .filter(employee -> employee.getDeptNum().equals(deptNum))
                .collect(Collectors.toList());
        return employeesList;
    }

}
