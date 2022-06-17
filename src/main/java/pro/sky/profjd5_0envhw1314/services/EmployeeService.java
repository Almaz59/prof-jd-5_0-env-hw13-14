package pro.sky.profjd5_0envhw1314.services;

import pro.sky.profjd5_0envhw1314.data.Employee;

import java.util.Map;

public interface EmployeeService {

    Map<String, Employee> getEmployees();

    Employee add(String firstName, String lastName, Integer salary, Integer department);

    String getId(String firstName, String lastName, Integer salary, Integer department);

    Map<String, Employee> showListOfEmployee();

    Employee remove(String firstName, String lastName, Integer salary, Integer department);

    Employee find(String firstName, String lastName, Integer salary, Integer department);

}



