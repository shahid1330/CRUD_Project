package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        
        String name = request.getParameter("name1");
        String email = request.getParameter("email1");
        String password = request.getParameter("pass1");
        String gender = request.getParameter("gender1");
        String city = request.getParameter("city1");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myTable", "root", "1234");
            
            PreparedStatement preparedStatement = connection.prepareStatement("insert into register values(?,?,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, city);
            
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                response.setContentType("text/html");
                writer.print("<h3 style='color:green'> User registered successfully</h3>");
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
                dispatcher.include(request, response);
            } else {
                response.setContentType("text/html");
                writer.print("<h3 style='color:red'> User not registered due to some error</h3>");
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
                dispatcher.include(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
            response.setContentType("text/html");
            writer.print("<h3 style='color:red'> Exception Occurred: " + e.getMessage() + "</h3>");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
            dispatcher.include(request, response);
        }
    }
}
