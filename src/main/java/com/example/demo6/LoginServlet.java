package com.example.demo6;
import sun.security.rsa.RSASignature;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    static final String GET_ALL_RECORDS = "SELECT username,password FROM public.login";
    public static String encryptThisString(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        DbCon db = new DbCon();
        String name = request.getParameter("username");
        String password1 = request.getParameter("password");
        password1=encryptThisString(password1);
        Connection conn;
        try {
            conn = db.getCon();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Statement st = null;
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet resultSet = st.executeQuery(GET_ALL_RECORDS);
            while(resultSet.next()){
                String username=resultSet.getString(1);
                String password=resultSet.getString(2);
                if(Objects.equals(name, username) && Objects.equals(password1, password)) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
                    dispatcher.forward(request,response);
                }
                else{
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/wrong.jsp");
                    dispatcher.forward(request,response);
                }
            }
            resultSet.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
