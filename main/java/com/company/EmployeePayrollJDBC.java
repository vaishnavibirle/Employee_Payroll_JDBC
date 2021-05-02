package com.company;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class EmployeePayrollJDBC {
    public static void main(String[] args) {

        //Connecting to database
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName = "root";
        String password = "Vaishnavi@123";
        //Establishing connection
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find driver in classpath!", e);
        }
        //adding jdbc driver
        listDrivers();
        try{
            System.out.println("Connecting to database: " + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection is successful!!!!!" + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Checking list drivers
    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" " + driverClass.getClass().getName());
        }
    }
}
