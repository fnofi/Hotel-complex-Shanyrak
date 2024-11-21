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

@WebServlet(name = "deleteMemberServlet", value = "/deleteMember-servlet")
public class deleteMemberServlet extends HttpServlet {
    static final String GET_ALL_RECORDS_MEMBER = "SELECT * FROM public.member";
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
            String af =String.format("DELETE FROM public.member WHERE id='"+lap+"'");
            try {
                st.executeUpdate(af);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ResultSet resultSet = st.executeQuery(GET_ALL_RECORDS_MEMBER);
            out.println("<br><html><div style='text-align: center;'><head><title>Data base</title><meta http-equiv='Content-Type' content='text/html; charset=utf-8'></head><body>" +
                    "<table id='messages' border='1' style = 'display: inline-block; font-size: 16pt'>");
            out.println("<form action='hello-servlet' method='POST'>");
            out.println("<tr><td>Id</td><td>Имя</td><td>Фамилия</td><td>Отчество</td><td>Возраст</td><td>Роль</td><td>Действие</td></tr>");
            int i=0;
            while(resultSet.next()){
                i++;
                String id=resultSet.getString(1);
                String name=resultSet.getString(2);
                String second_name=resultSet.getString(3);
                String patronymic=resultSet.getString(4);
                String age=resultSet.getString(5);
                String role=resultSet.getString(6);
                out.println("<tr><td>"+i+"</td><td>"+name+"</td><td>"+second_name+"</td><td>"+patronymic+"</td><td>"+age+"</td><td>"+role+"</td><td><a href='actionMember-servlet?id="+id+"'>Изменить</a>|<a href='deleteMember-servlet?id="+id+"'>Удалить</a></td></tr>");
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
