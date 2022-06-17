package pro.sky.profjd5_0envhw1314.services.impl;


import org.junit.jupiter.api.Test;
import pro.sky.profjd5_0envhw1314.data.Employee;
import pro.sky.profjd5_0envhw1314.exeptions.EmployeeAlreadyAddedException;
import pro.sky.profjd5_0envhw1314.exeptions.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pro.sky.profjd5_0envhw1314.constants.EmployeeServiceTestConstants.*;

class EmployeeServiceImplTest {

    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    void getEmployees_shouldReturnMapOfEmployee() {
        out.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT);
        Map<String, Employee> expected = new HashMap<>();
        expected.put(EXPECTED_ID, EXPECTED_EMPLOYEE);
        assertEquals(out.getEmployees(), expected);
    }

    @Test
    void add_ReturnEmployee() {
        Employee actual = out.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT);
        assertEquals(actual, EXPECTED_EMPLOYEE);
    }

    @Test
    void add_shouldReturnEmployeeAlreadyAddedException() {
        out.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT);
        assertThrows(EmployeeAlreadyAddedException.class, () -> out.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT));
    }

    @Test
    void getId_shouldReturnIdOfEmployee() {
        String actual = out.getId(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT);
        assertEquals(actual, EXPECTED_ID);
    }

    @Test
    void showListOfEmployee_shouldReturnListOfEmployee() {
        out.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT);
        Map<String, Employee> expected = new HashMap<>();
        expected.put(EXPECTED_ID, EXPECTED_EMPLOYEE);
        assertEquals(out.showListOfEmployee(), expected);
    }

    @Test
    void remove_shouldRemoveEmployee() {
        out.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT);
        Employee actual = out.remove(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT);
        assertEquals(actual, EXPECTED_EMPLOYEE);
    }

    @Test
    void remove_shouldReturnEmployeeNotFoundException() {
        out.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT);
        out.remove(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT);
        assertThrows(EmployeeNotFoundException.class, () -> out.remove(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT));
    }

    @Test
    void find_shouldFindEmployee() {
        out.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT);
        Employee actual = out.find(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT);
        assertEquals(actual, EXPECTED_EMPLOYEE);
    }

    @Test
    void find_shouldReturnEmployeeNotFoundException() {
        out.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT);
        out.find(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT);
        assertThrows(EmployeeNotFoundException.class, () -> out.find(FAKE_NAME, LAST_NAME, SALARY, DEPARTMENT));
    }
}