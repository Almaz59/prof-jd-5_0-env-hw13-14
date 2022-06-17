package pro.sky.profjd5_0envhw1314.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.profjd5_0envhw1314.data.Employee;
import pro.sky.profjd5_0envhw1314.exeptions.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import static org.assertj.core.api.Assertions.*;
import static pro.sky.profjd5_0envhw1314.constants.EmployeeDepartmentTestConstants.*;
import static pro.sky.profjd5_0envhw1314.constants.EmployeeServiceTestConstants.*;

@ExtendWith(MockitoExtension.class)
class EmployeeDepartmentServiceImplTest {

    @Mock // данной аннотацией мы инжектим методы класса EmployeeServiceImpl для дальнейшей работы с ними
    private EmployeeServiceImpl employeeServiceMock;

    @InjectMocks // данной аннотацией мы инжектим методы класса EmployeeDepartmentServiceImpl для дальнейшей работы с ними
    private EmployeeDepartmentServiceImpl out;

    @Test
    void showAllList_shouldReturnAllListOfEmployee() {
        Map<String, Employee> expected = new HashMap<>();
        expected.put(EXPECTED_ID, EXPECTED_EMPLOYEE);
        when(employeeServiceMock.getEmployees()).thenReturn(expected); // когда (when) мы вызываем метод
        // getEmployees() должна вернуться (thenReturn) мапа с ID (ключ) и данными (значения) сотрудника
        assertThat(out.showAllList()).containsAll(expected.values());

    }

    @Test
    void findMaxSalary_shouldReturnMaxSalryOfEmployeeOfDepartment() {
        Map<String, Employee> expected = new HashMap<>();
        expected.put(EXPECTED_ID, EXPECTED_EMPLOYEE);
        when(employeeServiceMock.getEmployees()).thenReturn(expected);
        assertThat(out.findMaxSalary(DEPARTMENT).equals(EMPLOYEE_MAX_SALARY));
    }

    @Test
    void findMaxSalary_shouldReturnNotFoundExceptionForMaxSalary() {
        Map<String, Employee> expected = new HashMap<>();
        expected.put(EXPECTED_ID, EXPECTED_EMPLOYEE);
        when(employeeServiceMock.getEmployees()).thenReturn(expected);
        assertThrows(EmployeeNotFoundException.class, () -> out.findMaxSalary(FAKE_DEPARTMENT));
    }

    @Test
    void findMinSalary_shouldReturnMinSalaryOfEmployeeOfDepartment() {
        Map<String, Employee> expected = new HashMap<>();
        expected.put(EXPECTED_ID, EXPECTED_EMPLOYEE);
        when(employeeServiceMock.getEmployees()).thenReturn(expected);
        assertThat(out.findMinSalary(DEPARTMENT).equals(EMPLOYEE_MIN_SALARY));
    }

    @Test
    void findMaxSalary_shouldReturnNotFoundExceptionForMinSalary() {
        Map<String, Employee> expected = new HashMap<>();
        expected.put(EXPECTED_ID, EXPECTED_EMPLOYEE);
        when(employeeServiceMock.getEmployees()).thenReturn(expected);
        assertThrows(EmployeeNotFoundException.class, () -> out.findMinSalary(FAKE_DEPARTMENT));
    }

    @Test
    void showAllListEmployee() {
        Map<String, Employee> expected = new HashMap<>();
        expected.put(EXPECTED_ID, EXPECTED_EMPLOYEE);
        when(employeeServiceMock.getEmployees()).thenReturn(expected);
        assertThat(out.showAllListEmployee(DEPARTMENT)).containsAll(expected.values());
    }
}