package gos.andrey1986.employeelist.controller;


import gos.andrey1986.employeelist.data.Employee;
import gos.andrey1986.employeelist.service.impl.EmployeeBookServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employeelist")
public class EmployeeController {
    private final EmployeeBookServiceImpl employeeBookService;


    public EmployeeController(EmployeeBookServiceImpl employeeService) {
        this.employeeBookService  = employeeService;
    }

    @RequestMapping("/add")
    public boolean add( @RequestParam(name = "firstName") String firstName,
                        @RequestParam(name = "lastName") String lastName) {
        return employeeBookService.add(firstName,lastName);
    }

    @RequestMapping("/remove")
    public boolean remove(@RequestParam(name = "firstName") String firstName,
                          @RequestParam(name = "lastName") String lastName){
        return employeeBookService.remove(firstName,lastName);
    }

    @RequestMapping("/find")
    public Employee find(@RequestParam(name = "firstName") String firstName,
                         @RequestParam(name = "lastName") String lastName) {
        return employeeBookService.find(firstName,lastName);
    }

    @RequestMapping("/show")
    public Map<String,Employee> show() {
        return employeeBookService.show();
    }
}
