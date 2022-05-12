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
    public boolean add(@RequestParam("id") int id,
                       @RequestParam("inn") long inn,
                        @RequestParam(name = "firstName") String firstName,
                        @RequestParam(name = "lastName") String lastName) {

        return employeeBookService.add(id,inn,firstName,lastName);
    }

    @RequestMapping("/remove")
    public boolean remove(@RequestParam("inn") long inn){
        return employeeBookService.remove(inn);
    }

    @RequestMapping("/find")
    public Employee find(@RequestParam("inn") long inn) {
        return employeeBookService.find(inn);
    }

    @RequestMapping("/show")
    public Map<Long,Employee> show() {
        return employeeBookService.show();
    }
}
