package pro.sky.profjd5_0envhw1314.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.profjd5_0envhw1314.data.Employee;
import pro.sky.profjd5_0envhw1314.services.EmployeeDepartmentService;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class EmployeeDepartmentController {

    private final EmployeeDepartmentService employeeDepartmentService;

    public EmployeeDepartmentController(EmployeeDepartmentService employeeDepartmentService) {
        this.employeeDepartmentService = employeeDepartmentService;
    }

    @GetMapping("/max-salary")
    public Employee findMaxSalary(@RequestParam("department") Integer department) {
        return employeeDepartmentService.findMaxSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee findMinSalary(@RequestParam("department") Integer department) {
        return employeeDepartmentService.findMinSalary(department);
    }

    @GetMapping("/show")
    public List<Employee> showAllListEmployee(@RequestParam("department") Integer department) {
        return employeeDepartmentService.showAllListEmployee(department);
    }

    @GetMapping("/all")
    public List<Employee> showAllList() {
        return employeeDepartmentService.showAllList();
    }
}
