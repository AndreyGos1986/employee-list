package gos.andrey1986.employeelist.constant;

import gos.andrey1986.employeelist.data.Employee;

import static org.mockito.Mockito.mock;

public class EmployeeBookServiceTestConstants {

    public static final String FIRST_NAME="SomeFirstName";
    public static final String LAST_NAME="SomeSurname";
    public static final double SALARY=100.00;
    public static final Integer DEPT_NUM=11;
    public static final Employee EMPLOYEE = new Employee(FIRST_NAME,LAST_NAME,SALARY,DEPT_NUM);

}
