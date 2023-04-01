package sawant.mihir.loginservlet.services;

import sawant.mihir.loginservlet.dao.EmployeeDao;
import sawant.mihir.loginservlet.entities.Employee;

import java.sql.*;

public class EmployeeService {

    private static final String USER_NAME = "root";
    private static final String PASSWORD = "toor";
    public int checkIfUserExists(String userName) {

        PreparedStatement checkStatement = null;
       String userCheck = "SELECT COUNT(user_name) FROM employees WHERE user_name LIKE ?";
        try {
            Connection conn = DbService.getMysqlConnection();

            checkStatement = conn.prepareStatement(userCheck);
            checkStatement.setString(1, userName);
            ResultSet resultSet = checkStatement.executeQuery();

            if(resultSet.next()){
                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    public int insertNewEmployee(Employee employee){
        try{
            Connection conn = DbService.getMysqlConnection();
            String insert = "INSERT INTO employees(user_name, password) VALUES(?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insert);
            insertStatement.setString(1, employee.getUserName());
            insertStatement.setString(2, employee.getPassword());
            insertStatement.execute();
            return insertStatement.getUpdateCount();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public int verifyCredentials(Employee employee){
        try{
            Connection conn = DbService.getMysqlConnection();
            String user = "SELECT * FROM employees WHERE user_name = ?";
            PreparedStatement matchStatement = conn.prepareStatement(user);
            matchStatement.setString(1, employee.getUserName());
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public String getPasswordForEmployee(String userName){
        try{
            Connection conn = DbService.getMysqlConnection();
            String getPassword = "SELECT password FROM employees WHERE user_name = ?";
            PreparedStatement findPass = conn.prepareStatement(getPassword);
            findPass.setString(1, userName);
            ResultSet employeeResultSet = findPass.executeQuery();
            if(employeeResultSet.next()){
                return employeeResultSet.getString(1);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
