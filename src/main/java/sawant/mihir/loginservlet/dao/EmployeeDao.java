package sawant.mihir.loginservlet.dao;

import sawant.mihir.loginservlet.entities.Employee;

public record EmployeeDao(String userName, String password) {

    public Employee toEmployee(){
       Employee employee = new Employee();
       employee.setUserName(userName);
       employee.setPassword(password);
       return employee;
    }
}
