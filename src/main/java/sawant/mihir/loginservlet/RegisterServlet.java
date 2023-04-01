package sawant.mihir.loginservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sawant.mihir.loginservlet.dao.EmployeeDao;
import sawant.mihir.loginservlet.services.EmployeeService;

import java.io.IOException;
import java.io.PrintWriter;


public class RegisterServlet extends HttpServlet {

    private EmployeeService employeeService;
    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/register.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        EmployeeDao dao = new EmployeeDao(userName, password);
        int result = employeeService.insertNewEmployee(dao.toEmployee());
        if(result == 1){
            resp.sendRedirect("/login_servlet_war_exploded/login");
        }
    }
}
