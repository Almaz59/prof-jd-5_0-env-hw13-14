package pro.sky.profjd5_0envhw1314.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.profjd5_0envhw1314.data.Employee;
import pro.sky.profjd5_0envhw1314.exeptions.EmployeeNotFoundException;
import pro.sky.profjd5_0envhw1314.services.EmployeeDepartmentService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeDepartmentServiceImpl implements EmployeeDepartmentService {
    private final EmployeeServiceImpl employeeService;

    public EmployeeDepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> showAllList() {
        return new ArrayList<>(employeeService.getEmployees().values());
    }

    @Override
    public Employee findMaxSalary(Integer department) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment().equals(department)) // е является элементом массива. e.getDepartment() возвращает номера отделов из листа и сравнивает их с номером отдела переданном из браузера через department
                .max((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary())) // e1 и е2 два эллемента массива которые сравниваются между собой через метод compare типа Integer
                .orElseThrow(EmployeeNotFoundException::new); // возвращает ошибку если в листе отсутсвует отдел перданный через брайзер
    }

    @Override
    public Employee findMinSalary(Integer department) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment().equals(department))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> showAllListEmployee(Integer department) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

}
