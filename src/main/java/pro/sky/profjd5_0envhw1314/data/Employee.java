package pro.sky.profjd5_0envhw1314.data;

import java.util.Objects;

public class Employee {
    private final String firstNameOfEmployee;
    private final String lastNameOfEmployee;
    private Integer salary;
    private Integer department;

    public Employee(String firstNameOfEmployee, String lastNameOfEmployee, Integer salary, Integer department) {
        this.firstNameOfEmployee = firstNameOfEmployee;
        this.lastNameOfEmployee = lastNameOfEmployee;
        this.salary = salary;
        this.department = department;
    }


    public String getFirstNameOfEmployee() {
        return this.firstNameOfEmployee;
    }

    public String getLastNameOfEmployee() {
        return this.lastNameOfEmployee;
    }

    public Integer getSalary() {
        return this.salary;
    }

    public Integer getDepartment() {
        return this.department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary.equals(employee.salary) && department.equals(employee.department)
                && firstNameOfEmployee.equals(employee.firstNameOfEmployee)
                && lastNameOfEmployee.equals(employee.lastNameOfEmployee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNameOfEmployee, lastNameOfEmployee, salary, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstNameOfEmployee='" + firstNameOfEmployee + '\'' +
                ", lastNameOfEmployee='" + lastNameOfEmployee + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}



