package gos.andrey1986.employeelist.service;

import gos.andrey1986.employeelist.data.Employee;
import gos.andrey1986.employeelist.exceptions.EmployeeNotFoundException;
import gos.andrey1986.employeelist.exceptions.TheEmployeeAlreadyExistsException;
import gos.andrey1986.employeelist.service.impl.EmployeeBookServiceImpl;
import org.junit.jupiter.api.Test;


import static gos.andrey1986.employeelist.constant.EmployeeBookServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;



class EmployeeBookServiceTest {


    private final EmployeeBookServiceImpl out = new EmployeeBookServiceImpl();


    @Test
    public void shouldAddEmployeeAndReturnTrue() {
        boolean actual = out.add(FIRST_NAME, LAST_NAME, SALARY, DEPT_NUM);
        assertTrue(actual);
    }

    @Test
    public void shouldThrowTheEmployeeAlreadyExistExceptionIfEmployeeIsAlreadyExist() {
        out.add(FIRST_NAME, LAST_NAME, SALARY, DEPT_NUM);
        assertThrows(TheEmployeeAlreadyExistsException.class, () -> out.add(FIRST_NAME, LAST_NAME, SALARY, DEPT_NUM));
    }

    @Test
    void shouldRemoveAndReturnTrue() {
        out.add(FIRST_NAME, LAST_NAME, SALARY, DEPT_NUM);
        boolean actual = out.remove(FIRST_NAME, LAST_NAME);
        assertTrue(actual);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionIfEmployeeForRemoveIsNotFound() {
        assertThrows(EmployeeNotFoundException.class, () -> out.remove(FIRST_NAME, LAST_NAME));
    }

    @Test
    void find() {
        out.add(FIRST_NAME, LAST_NAME, SALARY, DEPT_NUM);
        Employee actual = out.find(FIRST_NAME, LAST_NAME);
        assertEquals(EMPLOYEE, actual);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionIfEmployeeNotFound() {
        assertThrows(EmployeeNotFoundException.class, () -> out.find(FIRST_NAME, LAST_NAME));
    }
}