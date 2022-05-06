package gos.andrey1986.employeelist.controller;


import gos.andrey1986.employeelist.data.Employee;
import gos.andrey1986.employeelist.service.impl.EmployeeBookServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employeelist")
public class EmployeeController {
    private final EmployeeBookServiceImpl employeeBookService;


    public EmployeeController(EmployeeBookServiceImpl employeeService) {
        this.employeeBookService  = employeeService;
    }

    @RequestMapping("/add")
    public boolean add(@RequestParam("id") int id,
                        @RequestParam(name = "firstName") String firstName,
                        @RequestParam(name = "lastName") String lastName) {
        return employeeBookService.add(id,firstName,lastName);
    }

    @RequestMapping("/remove")
    public boolean remove(@RequestParam("id") int id){
        return employeeBookService.remove(id);
    }

    @RequestMapping("/find")
    public Employee find(@RequestParam("id") int id) {
        return employeeBookService.find(id);
    }

    @RequestMapping("/show")
    public List<Employee> show() {
        return employeeBookService.show();
    }
}
