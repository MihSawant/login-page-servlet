package sawant.mihir.loginservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sawant.mihir.loginservlet.services.DbService;
import sawant.mihir.loginservlet.services.EmployeeService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

public class LoginServlet extends HttpServlet {

    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        employeeService = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        int count = employeeService.checkIfUserExists(userName);
        if(count < 1){
            resp.sendRedirect("/login_servlet_war_exploded/register");
        } else{
            String dbPassword = employeeService.getPasswordForEmployee(userName);
            if(dbPassword.equals(password)){
                RequestDispatcher reqDispatch = req.getRequestDispatcher("/success.jsp");
                reqDispatch.forward(req, resp);
            } else{
                writer.println("<h1 style='color:red'>Login Failed, Wrong Failed</h1>");
             }

        }

        writer.close();
    }
}
