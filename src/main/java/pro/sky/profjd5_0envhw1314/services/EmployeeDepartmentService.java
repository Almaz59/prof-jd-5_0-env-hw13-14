package pro.sky.profjd5_0envhw1314.services;

import pro.sky.profjd5_0envhw1314.data.Employee;

import java.util.List;

public interface EmployeeDepartmentService {

    List<Employee> showAllList();

    Employee findMaxSalary(Integer department);

    Employee findMinSalary(Integer department);

    List<Employee> showAllListEmployee(Integer department);

}
