package gos.andrey1986.employeelist.constant;

import gos.andrey1986.employeelist.data.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.MAX_VALUE;

public class EmployeeBookServDeptTestConstants {


    public static final Employee EMPLOYEE1 = new Employee("СЕРГЕЙ", "СЕРГЕЕВ", 100.00, 3);
    public static final Employee EMPLOYEE2 = new Employee("ПЕТР", "ПЕТРОВ", 200.00, 3);
    public static final Employee EMPLOYEE3 = new Employee("САДАМ", "САДАМОВ", 250.00, 1);
    public static final Employee EMPLOYEE4 = new Employee("МУРЛАН", "МУРЛАНОВ", 252.46, 1);
    public static final Employee EMPLOYEE5 = new Employee("СЕМЁН", "СЕМЁНОВ", 199.58, 3);

    public static final Employee EMPLOYEE_WITH_MIN_SALARY_IN_3_DEPT = EMPLOYEE1;
    public static final Employee EMPLOYEE_WITH_MAX_SALARY_IN_3_DEPT = EMPLOYEE2;

    public static final int DEPT_NUM = 3;
    public static final int THE_DEPARTAMENT_IS_MISSING = MAX_VALUE;

    public static final Map<String, Employee> EMPTY_BOOK = new HashMap<>();

    public static final List<Employee> LIST_OF_EMPLOYEES_IN_ONE_DEPT = List.of(EMPLOYEE1, EMPLOYEE2, EMPLOYEE5);
    public static final List<Employee> LIST_OF_ALL_EMPLOYEES = List.of(EMPLOYEE1, EMPLOYEE2, EMPLOYEE3, EMPLOYEE4, EMPLOYEE5);

    public static final Map<String, Employee> ALL_EMPLOYEES_MAP = Map.of(
            EMPLOYEE1.getFirstAndLastName(),
            EMPLOYEE1,
            EMPLOYEE2.getFirstAndLastName(),
            EMPLOYEE2,
            EMPLOYEE3.getFirstAndLastName(),
            EMPLOYEE3,
            EMPLOYEE4.getFirstAndLastName(),
            EMPLOYEE4,
            EMPLOYEE5.getFirstAndLastName(),
            EMPLOYEE5
    );
    public static final Map<String, Employee> EMPLOYEES_MAP_OF_ONE_DEPT = Map.of(
            EMPLOYEE1.getFirstAndLastName(),
            EMPLOYEE1,

            EMPLOYEE2.getFirstAndLastName(),
            EMPLOYEE2,

            EMPLOYEE5.getFirstAndLastName(),
            EMPLOYEE5
    );

}
