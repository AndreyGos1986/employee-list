package gos.andrey1986.employeelist.service;

import gos.andrey1986.employeelist.data.Employee;
import gos.andrey1986.employeelist.exceptions.EmployeeNotFoundException;
import gos.andrey1986.employeelist.service.impl.EmployeeBookServByDeptImpl;
import gos.andrey1986.employeelist.service.impl.EmployeeBookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static gos.andrey1986.employeelist.constant.EmployeeBookServDeptTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeBookServDeptTest {

    @Mock
    private EmployeeBookServiceImpl employeeBookServiceMock;
    @InjectMocks
    private EmployeeBookServByDeptImpl out;

    @Test
    void shouldfindEmployeeWithMaxSalByDeptnumAndReturnEmployee() {
        when(employeeBookServiceMock.getEmployeeBook())
                .thenReturn(EMPLOYEES_MAP_OF_ONE_DEPT);
        Employee actual = out.findEmplWithMaxSalByDeptnum(DEPT_NUM);
        assertEquals(EMPLOYEE2, actual);
    }

    @Test
    void shouldThrowEmployeeNotFoundExceptionIfNothingNotFoundOrEmployeeBookIsEmpty() { //ТЕСТ НАПИСАЛ ОДИН, Т.К. ОН ПРОВЕРЯЕТ
        when(employeeBookServiceMock.getEmployeeBook())                                    // НАЛИЧИЕ ДЕПАРТАМЕНТА ПРИ ПОИСКЕ МАКС. И МИН. ЗП.
                .thenReturn(EMPLOYEES_MAP_OF_ONE_DEPT);
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmplWithMaxSalByDeptnum(THE_DEPARTAMENT_IS_MISSING));

    }

    @Test
    void shouldfindEmployeeWithMinSalByDeptnum() {
        when(employeeBookServiceMock.getEmployeeBook())
                .thenReturn(EMPLOYEES_MAP_OF_ONE_DEPT);
        Employee actual = out.findEmplWithMinSalByDeptnum(DEPT_NUM);
        assertEquals(EMPLOYEE1, actual);
    }


    @Test
    void shouldFindEmployeesByDeptNumAndReturnTrue() {
        when(employeeBookServiceMock.getEmployeeBook())
                .thenReturn(EMPLOYEES_MAP_OF_ONE_DEPT);
        List<Employee> expected = LIST_OF_EMPLOYEES_IN_ONE_DEPT;
        List<Employee> actual = out.findEmployeesByDeptNum(DEPT_NUM);
        assertEquals(expected,actual);
    }

    @Test
    void getAll() {
        when(employeeBookServiceMock.getEmployeeBook())
                .thenReturn(ALL_EMPLOYEES_MAP);
        List<Employee> expected = LIST_OF_ALL_EMPLOYEES;
        List<Employee> actual = out.getAll();
        assertEquals(expected,actual);
    }

    @Test
    void shouldThrowEmployeeNotFoundExceptionIfEmployeeBookIsEmpty() {
        when(employeeBookServiceMock.getEmployeeBook())
                .thenReturn(EMPTY_BOOK);
        assertThrows(EmployeeNotFoundException.class, () -> out.getAll());

    }


}