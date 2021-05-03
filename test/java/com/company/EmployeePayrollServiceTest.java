package com.company;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeePayrollServiceTest {
    static EmployeePayrollService employeePayrollService;

    @BeforeClass
    public static void EmpPayRollServiceObj() {
        employeePayrollService = new EmployeePayrollService();
    }

    @Test
    public void givenEmployeePayRollInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        Assertions.assertEquals(3, employeePayrollData.size());
    }
}
