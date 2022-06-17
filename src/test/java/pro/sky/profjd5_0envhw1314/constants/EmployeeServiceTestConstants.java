package pro.sky.profjd5_0envhw1314.constants;

import pro.sky.profjd5_0envhw1314.data.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceTestConstants {
    public static final String FIRST_NAME = "Almaz";
    public static final String LAST_NAME = "Mamatov";
    public static final Integer SALARY = 5000;
    public static final Integer DEPARTMENT = 5;
    public static final String FAKE_NAME = "Ivan";

    public static final Employee EXPECTED_EMPLOYEE = new Employee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT);
    public static final String EXPECTED_ID = (FIRST_NAME + LAST_NAME + SALARY + DEPARTMENT).toLowerCase();
}
