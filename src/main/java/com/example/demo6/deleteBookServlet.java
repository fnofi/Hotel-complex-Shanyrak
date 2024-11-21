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

@WebServlet(name = "deleteBookServlet", value = "/deleteBook-servlet")
public class deleteBookServlet extends HttpServlet {
    static final String GET_ALL_RECORDS_BOOK = "SELECT * FROM public.book";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String lap=request.getParameter("id");
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
        try {
            String af =String.format("DELETE FROM public.book WHERE id='"+lap+"'");
            try {
                st.executeUpdate(af);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
