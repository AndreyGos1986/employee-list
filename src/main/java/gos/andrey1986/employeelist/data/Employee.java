package gos.andrey1986.employeelist.data;

import java.util.Objects;

public class Employee {

    private int id;
    private long inn;
    private String firstName;
    private String lastName;


    public Employee(long inn, int id, String firstName, String lastName) {
        this.id = id;
        this.inn = inn;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && inn == employee.inn && firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, inn, firstName, lastName);
    }

}
