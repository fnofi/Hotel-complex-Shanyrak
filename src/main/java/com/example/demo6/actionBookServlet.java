package com.example.demo6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@WebServlet(name = "actionBookServlet", value = "/actionBook-servlet")
public class actionBookServlet extends HttpServlet {
    static final String GET_ALL_RECORDS_BOOK = "SELECT * FROM public.book";
    String lap="";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        lap=request.getParameter("id");
        PrintWriter out = response.getWriter();
        DbCon db = new DbCon();
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
        out.println("<br><html lang='ru'><div style='text-align: center;'><head><title>Data base</title><meta http-equiv='Content-Type' content='text/html; charset=utf-8'></head><body><form action='actionBook-servlet' method='POST'>" +
                "<h2>Имя:<input name='name' /><br><br>Фамилия:<input name='second_name' /><br><br>Телефон:<input name='phone_number' /><br><br>" +
                "Почта:<input name='email' /><br><br>Примечание:<input name='note' /><br><br><font size='24pt'><input type='submit' name='s1' value='Подтвердить' /></font>" +
                "</h2></form>");
        try {
            ResultSet resultSet = st.executeQuery(GET_ALL_RECORDS_BOOK);
            out.println("<table id='messages' border='1' style = 'display: inline-block; font-size: 16pt'>");
            out.println("<form action='actionBook-servlet' method='POST'>");
            out.println("<tr><td>Id</td><td>Имя</td><td>Фамилия</td><td>Телефон</td><td>Почта</td><td>Примечание</td></tr>");
            int i=0;
            while(resultSet.next()){
                i++;
                String name=resultSet.getString(2);
                String second_name=resultSet.getString(3);
                String phone_number=resultSet.getString(4);
                String email=resultSet.getString(5);
                String note=resultSet.getString(6);
                out.println("<tr><td>"+i+"</td><td>"+name+"</td><td>"+second_name+"</td><td>"+phone_number+"</td><td>"+email+"</td><td>"+note+"</td></tr>");
            }
            resultSet.close();
            st.close();
            conn.close();
            out.println("</table><br><br><input type='submit' name='s1' value='Главное меню' />&nbsp;&nbsp;</form></body></div></html>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String cap=request.getParameter("s1");
        PrintWriter out = response.getWriter();
        DbCon db = new DbCon();
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
        if(cap.equals("Подтвердить")){
            String name1 = request.getParameter("name");
            String second_name1 = request.getParameter("second_name");
            String phone_number1 = request.getParameter("phone_number");
            String email1 = request.getParameter("email");
            String note1 = request.getParameter("note");
            String af =String.format("UPDATE public.book SET id='"+lap+"', first_name='"+name1+"', second_name='"+second_name1+"', phone_number='"+phone_number1+"', email='"+email1+"', note='"+note1+"' WHERE id='"+lap+"'");
            try {
                st.executeUpdate(af);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                ResultSet resultSet = st.executeQuery(GET_ALL_RECORDS_BOOK);
                out.println("<br><html><div style='text-align: center;'><head><title>Data base</title><meta http-equiv='Content-Type' content='text/html; charset=utf-8'></head><body><form action='hello-servlet' method='POST'>" +
                        "<table id='messages' border='1' style = 'display: inline-block; font-size: 16pt'>");
                out.println("<tr><td>Id</td><td>Имя</td><td>Фамилия</td><td>Телефон</td><td>Почта</td><td>Примечание</td><td>Действие</td></tr>");
                int i=0;
                while(resultSet.next()){
                    i++;
                    String id=resultSet.getString(1);
                    String name=resultSet.getString(2);
                    String second_name=resultSet.getString(3);
                    String phone_number=resultSet.getString(4);
                    String email=resultSet.getString(5);
                    String note=resultSet.getString(6);
                    out.println("<tr><td>"+i+"</td><td>"+name+"</td><td>"+second_name+"</td><td>"+phone_number+"</td><td>"+email+"</td><td>"+note+"</td><td><a href='actionBook-servlet?id="+id+"'>Изменить</a>|<a href='deleteBook-servlet?id="+id+"'>Удалить</a></td></tr>");
                }
                resultSet.close();
                st.close();
                conn.close();
                out.println("</table><br><br><input type='submit' name='s1' value='Главное меню' />&nbsp;&nbsp;</form></body></div></html>");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}