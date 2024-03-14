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

@WebServlet("/UpdateForm")
public class Update extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String email = request.getParameter("email1");
        String password = request.getParameter("pass1");
        String city = request.getParameter("city1");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_demo", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("update register set city=? where email=? and password=?");

            preparedStatement.setString(1, city);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                response.setContentType("text/html");
                writer.print("<h3 style='color:green'> User updated Successfully</h3>");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
                dispatcher.include(request, response);
            } else {
                response.setContentType("text/html");
                writer.print("<h3 style='color:red'> User not found or update failed</h3>");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
                dispatcher.include(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();

            response.setContentType("text/html");
            writer.print("<h3 style='color:red'> " + e.getMessage() + " </h3>");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
            dispatcher.include(request, response);
        }
    }
}
