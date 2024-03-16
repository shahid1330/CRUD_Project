package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginForm")
public class Login_Opr extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        PrintWriter writer = response.getWriter();
        String email = request.getParameter("email1");
        String password = request.getParameter("pass1");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shahid", "root", "1234");
            
            PreparedStatement preparedStatement = connection.prepareStatement("select * from myTable where email=? and password=?");
            
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("session_name", resultSet.getString("name"));
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Profile_Opr.jsp");
                dispatcher.include(request, response);
            } else {
                response.setContentType("text/html");
                writer.print("<h3 style='color:red'> Email id and Password not matched </h3>");
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Login_Opr.jsp");
                dispatcher.include(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
            response.setContentType("text/html");
            writer.print("<h3 style='color:red'> " + e.getMessage() + " </h3>");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Login_Opr.jsp");
            dispatcher.include(request, response);
        }
    }
}
